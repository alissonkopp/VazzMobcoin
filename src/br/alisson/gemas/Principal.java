package br.alisson.gemas;

import br.alisson.gemas.commands.MobCoinCommand;
import br.alisson.gemas.database.MySQL;
import br.alisson.gemas.listeners.InventoryListener;
import br.alisson.gemas.listeners.PlayerListener;
import br.alisson.gemas.listeners.PlayerPickupItemListener;
import br.alisson.gemas.utils.PlayerMobCoin;
import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

public class Principal extends JavaPlugin {
    private MySQL sql;
    private static Principal plugin;
    public HashMap<String, PlayerMobCoin> mobcoin = new HashMap();

    public void onEnable() {
        plugin = this;
        this.saveDefaultConfig();
        new MobCoinCommand(this);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerPickupItemListener(), this);
        if (this.getConfig().getBoolean("MySQL.Ativar")) {
            String user = this.getConfig().getString("MySQL.User");
            String password = this.getConfig().getString("MySQL.Password");
            String host = this.getConfig().getString("MySQL.Host");
            String database = this.getConfig().getString("MySQL.Database");
            this.sql = new MySQL(user, password, host, database, MySQL.SQLType.MySQL, this);
            this.sql.startConnection();
        } else {
            if (!this.getDataFolder().exists()) {
                this.getDataFolder().mkdir();
            }

            this.sql = new MySQL("Principal", this.getDataFolder(), MySQL.SQLType.SQLite, this);
            this.sql.startConnection();
        }

    }

    public void onDisable() {
        Iterator var2 = this.mobcoin.values().iterator();

        while(var2.hasNext()) {
            PlayerMobCoin pc = (PlayerMobCoin)var2.next();
            pc.save();
        }

    }

    public void saveDefaultConfig() {
        File file = Paths.get(this.getDataFolder().getAbsolutePath(), "config.yml").toFile();
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdirs();
        }

        if (!file.exists()) {
            ByteSource source = new ByteSource() {
                public InputStream openStream() throws IOException {
                    return Principal.this.getResource("config.yml");
                }
            };

            try {
                String configValue = source.asCharSource(Charsets.UTF_8).read();
                this.getConfig().loadFromString(configValue);
                Files.write(configValue, file, Charsets.UTF_8);
            } catch (InvalidConfigurationException | IOException var4) {
                var4.printStackTrace();
            }

        }
    }

    public MySQL getSql() {
        return this.sql;
    }

    public PlayerMobCoin getPlayerMobCoin(String name) {
        return (PlayerMobCoin)this.mobcoin.get(name);
    }

    public PlayerMobCoin addPlayerMobCoin(String name, PlayerMobCoin pc) {
        return (PlayerMobCoin)this.mobcoin.put(name, pc);
    }

    public static Principal getPlugin() {
        return (Principal)JavaPlugin.getPlugin(Principal.class);
    }
}