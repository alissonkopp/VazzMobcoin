package br.alisson.gemas.listeners;

import br.alisson.gemas.Principal;
import java.util.Random;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class PlayerPickupItemListener implements Listener {
    @EventHandler
    public void Drop(EntityDeathEvent e) {
        Player p = e.getEntity().getKiller();
        Entity enty = e.getEntity();
        if (e.getEntity().getKiller() instanceof Player && enty.getType() != EntityType.PLAYER) {
            if (enty.getType() == EntityType.COW) {
                if (this.percentChance(25.0D)) {
                    Principal.getPlugin().getPlayerMobCoin(p.getName()).depositMobCoin(1);
                    p.sendTitle("§a", "§aVocê ganhou + 1.00 mobcoins!");
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
                }
            } else if (enty.getType() == EntityType.CAVE_SPIDER) {
                if (this.percentChance(25.0D)) {
                    Principal.getPlugin().getPlayerMobCoin(p.getName()).depositMobCoin(3);
                    p.sendTitle("§a", "§aVocê ganhou + 3.00 mobcoins!");
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
                }
            } else if (enty.getType() == EntityType.ZOMBIE) {
                if (this.percentChance(25.0D)) {
                    Principal.getPlugin().getPlayerMobCoin(p.getName()).depositMobCoin(5);
                    p.sendTitle("§a", "§aVocê ganhou + 5.00 mobcoins!");
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
                }
            } else if (enty.getType() == EntityType.PIG_ZOMBIE) {
                if (this.percentChance(25.0D)) {
                    Principal.getPlugin().getPlayerMobCoin(p.getName()).depositMobCoin(8);
                    p.sendTitle("§a", "§aVocê ganhou + 8.00 mobcoins!");
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
                }
            } else if (enty.getType() == EntityType.BLAZE) {
                if (this.percentChance(25.0D)) {
                    Principal.getPlugin().getPlayerMobCoin(p.getName()).depositMobCoin(12);
                    p.sendTitle("§a", "§aVocê ganhou + 12.00 mobcoins!");
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
                }
            } else if (enty.getType() == EntityType.IRON_GOLEM) {
                if (this.percentChance(25.0D)) {
                    Principal.getPlugin().getPlayerMobCoin(p.getName()).depositMobCoin(25);
                    p.sendTitle("§a", "§aVocê ganhou + 25.00 mobcoins!");
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
                }
            } else if (enty.getType() == EntityType.WITHER && this.percentChance(25.0D)) {
                Principal.getPlugin().getPlayerMobCoin(p.getName()).depositMobCoin(50);
                p.sendTitle("§a", "§aVocê ganhou + 50.00 mobcoins!");
                p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
            }
        }

    }

    protected final boolean percentChance(double percent) {
        if (!(percent < 0.0D) && !(percent > 100.0D)) {
            double result = (new Random()).nextDouble() * 100.0D;
            return result <= percent;
        } else {
            throw new IllegalArgumentException("A percentagem nao pode ser maior do que 100 nem menor do que 0");
        }
    }
}