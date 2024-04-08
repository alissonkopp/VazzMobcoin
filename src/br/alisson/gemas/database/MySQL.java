package br.alisson.gemas.database;

import br.alisson.gemas.Principal;
import br.alisson.gemas.utils.PlayerMobCoin;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class MySQL {
    private String user;
    private String host;
    private String database;
    private String password;
    private Connection connection;
    private Statement statement;
    private MySQL.SQLType sqlType;
    private File db;
    public Principal plugin;

    public MySQL(String user, String password, String host, String database, MySQL.SQLType sqlType, Principal plugin) {
        this.plugin = plugin;
        this.user = user;
        this.password = password;
        this.host = host;
        this.database = database;
        this.sqlType = sqlType;
    }

    public MySQL(String database, File folder, MySQL.SQLType sqlType, Principal VrauMobCoins) {
        this.plugin = VrauMobCoins;
        this.db = folder;
        this.database = database;
        this.sqlType = sqlType;
    }

    public MySQL(Principal plugin) {
        this.plugin = plugin;
    }

    public void startConnection() {
        if (this.getType().equals(MySQL.SQLType.MySQL)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                this.connection = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.database, this.user, this.password);
                this.statement = this.connection.createStatement();
                this.statement.execute("CREATE TABLE IF NOT EXISTS mobcoin (name VARCHAR(16), mobcoin INT)");
            } catch (ClassNotFoundException | SQLException var3) {
                var3.printStackTrace();
            }
        } else if (this.getType().equals(MySQL.SQLType.SQLite)) {
            try {
                Class.forName("org.sqlite.JDBC");
                this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.db.getAbsolutePath() + File.separator + this.database + ".db");
                this.statement = this.connection.createStatement();
                this.statement.execute("CREATE TABLE IF NOT EXISTS mobcoin (name VARCHAR(16), mobcoin INT)");
            } catch (SQLException | ClassNotFoundException var2) {
                var2.printStackTrace();
            }
        }

    }

    public boolean hasAccount(String name) {
        this.checkConnection();

        try {
            PreparedStatement ps = this.plugin.getSql().connection.prepareStatement("SELECT * FROM mobcoin WHERE name='" + name + "';");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        return false;
    }

    public void createAccount(final String name) {
        this.checkConnection();
        (new BukkitRunnable() {
            public void run() {
                try {
                    PreparedStatement ps = MySQL.this.plugin.getSql().connection.prepareStatement("INSERT INTO mobcoin (name, mobcoin) VALUES (?,?)");
                    ps.setString(1, name);
                    ps.setInt(2, 0);
                    ps.executeUpdate();
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        }).runTaskAsynchronously(this.plugin);
    }

    public int getMobCoin(String name) {
        this.checkConnection();

        try {
            PreparedStatement ps = this.plugin.getSql().connection.prepareStatement("SELECT * FROM mobcoin WHERE name='" + name + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("mobcoin");
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return 0;
    }

    public int setMobCoin(String name, int mobcoin) {
        this.checkConnection();

        try {
            PreparedStatement ps = this.plugin.getSql().connection.prepareStatement("UPDATE mobcoin SET mobcoin=? WHERE name=?");
            ps.setString(2, name);
            ps.setInt(1, mobcoin);
            ps.executeUpdate();
            return mobcoin;
        } catch (Exception var4) {
            var4.printStackTrace();
            return 0;
        }
    }

    public void getAllPlayerMobCoin() {
        this.checkConnection();
        (new BukkitRunnable() {
            public void run() {
                try {
                    PreparedStatement ps = MySQL.this.plugin.getSql().connection.prepareStatement("SELECT * FROM mobcoin");
                    ResultSet rs = ps.executeQuery();

                    while(rs.next()) {
                        String name = rs.getString("name");
                        int mobcoin = rs.getInt("mobcoin");
                        PlayerMobCoin pc = new PlayerMobCoin(name, mobcoin, MySQL.this.plugin);
                        MySQL.this.plugin.addPlayerMobCoin(name, pc);
                    }
                } catch (Exception var6) {
                    var6.printStackTrace();
                }

            }
        }).runTaskAsynchronously(this.plugin);
    }

    public void closeConnection() {
        try {
            this.statement.close();
            this.connection.close();
        } catch (SQLException var2) {
        }

    }

    public MySQL.SQLType getType() {
        return this.sqlType;
    }

    public void checkConnection() {
        try {
            if (this.connection.isClosed() || this.connection == null) {
                this.startConnection();
                Bukkit.getConsoleSender().sendMessage("�a  A conex�o com o MySQL foi restabelecida");
            }
        } catch (SQLException var2) {
            Bukkit.getConsoleSender().sendMessage("�4 Erro ao checar a conex�o: ");
            var2.printStackTrace();
        }

    }

    public Connection getConnection() {
        return this.connection;
    }

    public static enum SQLType {
        MySQL,
        SQLite;
    }
}
