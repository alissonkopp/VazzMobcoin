package br.alisson.gemas.listeners;

import br.alisson.gemas.Principal;
import br.alisson.gemas.utils.PlayerMobCoin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    private Principal plugin;

    public PlayerListener(Principal plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String name;
        int mobcoin;
        PlayerMobCoin pc;
        if (!this.plugin.getSql().hasAccount(p.getName())) {
            this.plugin.getSql().createAccount(p.getName());
            name = p.getName();
            mobcoin = this.plugin.getSql().getMobCoin(name);
            pc = new PlayerMobCoin(name, mobcoin, this.plugin);
            this.plugin.addPlayerMobCoin(name, pc);
        } else {
            name = p.getName();
            mobcoin = this.plugin.getSql().getMobCoin(name);
            pc = new PlayerMobCoin(name, mobcoin, this.plugin);
            this.plugin.addPlayerMobCoin(name, pc);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        PlayerMobCoin pc = this.plugin.getPlayerMobCoin(p.getName());
        this.plugin.addPlayerMobCoin(p.getName(), pc);
        this.plugin.getSql().setMobCoin(p.getName(), pc.getMobCoin());
    }
}