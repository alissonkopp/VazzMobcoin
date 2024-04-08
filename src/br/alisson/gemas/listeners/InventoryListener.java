package br.alisson.gemas.listeners;

import br.alisson.gemas.Principal;
import br.alisson.gemas.utils.JSONChatClickEventType;
import br.alisson.gemas.utils.JSONChatColor;
import br.alisson.gemas.utils.JSONChatExtra;
import br.alisson.gemas.utils.JSONChatHoverEventType;
import br.alisson.gemas.utils.JSONChatMessage;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {
    @EventHandler
    public void aoClicar(InventoryClickEvent e) {
        if (e.getInventory().getTitle().equalsIgnoreCase("MobCoins - Loja")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }

            Player p;
            if (e.getRawSlot() == 40) {
                p = (Player)e.getWhoClicked();
                p.closeInventory();
                JSONChatMessage texto = new JSONChatMessage(" §b", (JSONChatColor)null, (List)null);
                JSONChatExtra loja = new JSONChatExtra("\n §eClique §e§lAQUI §epara entrar na loja online.\n");
                loja.setHoverEvent(JSONChatHoverEventType.SHOW_TEXT, "§eClique para abrir o link.");
                loja.setClickEvent(JSONChatClickEventType.OPEN_URL, "discord.gg");
                texto.addExtra(loja);
                texto.sendToPlayer(p);
            }

            if (e.getRawSlot() == 10) {
                p = (Player)e.getWhoClicked();
                if (Principal.getPlugin().getPlayerMobCoin(p.getName()).getMobCoin() < 2000) {
                    p.sendMessage("§cVocê não possui mobcoins suficiente.");
                    return;
                }

                Principal.getPlugin().getPlayerMobCoin(p.getName()).withdrawMobCoin(2000);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect " + p.getName() + " strength 120 3");
                p.sendTitle("§aParabéns!", "§aItem adquirido com sucesso!");
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            }

            if (e.getRawSlot() == 11) {
                p = (Player)e.getWhoClicked();
                if (Principal.getPlugin().getPlayerMobCoin(p.getName()).getMobCoin() < 2000) {
                    p.sendMessage("§cVocê não possui mobcoins suficiente.");
                    return;
                }

                Principal.getPlugin().getPlayerMobCoin(p.getName()).withdrawMobCoin(2000);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "givelivros aspectocongelante " + p.getName() + " 1");
                p.sendTitle("§aParabéns!", "§aItem adquirido com sucesso!");
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            }

            if (e.getRawSlot() == 12) {
                p = (Player)e.getWhoClicked();
                if (Principal.getPlugin().getPlayerMobCoin(p.getName()).getMobCoin() < 14000) {
                    p.sendMessage("§cVocê não possui mobcoins suficiente.");
                    return;
                }

                Principal.getPlugin().getPlayerMobCoin(p.getName()).withdrawMobCoin(14000);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "darkit espadamob " + p.getName());
                p.sendTitle("§aParabéns!", "§aItem adquirido com sucesso!");
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            }

            if (e.getRawSlot() == 13) {
                p = (Player)e.getWhoClicked();
                if (Principal.getPlugin().getPlayerMobCoin(p.getName()).getMobCoin() < 20000) {
                    p.sendMessage("§cVocê não possui mobcoins suficiente.");
                    return;
                }

                Principal.getPlugin().getPlayerMobCoin(p.getName()).withdrawMobCoin(20000);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "darkit espadarag " + p.getName());
                p.sendTitle("§aParabéns!", "§aItem adquirido com sucesso!");
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            }

            if (e.getRawSlot() == 14) {
                p = (Player)e.getWhoClicked();
                if (Principal.getPlugin().getPlayerMobCoin(p.getName()).getMobCoin() < 2000) {
                    p.sendMessage("§cVocê não possui mobcoins suficiente.");
                    return;
                }

                Principal.getPlugin().getPlayerMobCoin(p.getName()).withdrawMobCoin(2000);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "givelivros campodeforça " + p.getName() + " 1");
                p.sendTitle("§aParabéns!", "§aItem adquirido com sucesso!");
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            }

            if (e.getRawSlot() == 15) {
                p = (Player)e.getWhoClicked();
                if (Principal.getPlugin().getPlayerMobCoin(p.getName()).getMobCoin() < 2000) {
                    p.sendMessage("§cVocê não possui mobcoins suficiente.");
                    return;
                }

                Principal.getPlugin().getPlayerMobCoin(p.getName()).withdrawMobCoin(2000);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "givelivros aspectodivino " + p.getName() + " 1");
                p.sendTitle("§aParabéns!", "§aItem adquirido com sucesso!");
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            }

            if (e.getRawSlot() == 16) {
                p = (Player)e.getWhoClicked();
                if (Principal.getPlugin().getPlayerMobCoin(p.getName()).getMobCoin() < 4500) {
                    p.sendMessage("§cVocê não possui mobcoins suficiente.");
                    return;
                }

                Principal.getPlugin().getPlayerMobCoin(p.getName()).withdrawMobCoin(4500);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "giveitens hydra " + p.getName() + " 1");
                p.sendTitle("§aParabéns!", "§aItem adquirido com sucesso!");
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            }

            if (e.getRawSlot() == 19) {
                p = (Player)e.getWhoClicked();
                if (Principal.getPlugin().getPlayerMobCoin(p.getName()).getMobCoin() < 4500) {
                    p.sendMessage("§cVocê não possui mobcoins suficiente.");
                    return;
                }

                Principal.getPlugin().getPlayerMobCoin(p.getName()).withdrawMobCoin(4500);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "giveitens aspectonoturno " + p.getName() + " 1");
                p.sendTitle("§aParabéns!", "§aItem adquirido com sucesso!");
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            }

            if (e.getRawSlot() == 20) {
                p = (Player)e.getWhoClicked();
                if (Principal.getPlugin().getPlayerMobCoin(p.getName()).getMobCoin() < 4500) {
                    p.sendMessage("§cVocê não possui mobcoins suficiente.");
                    return;
                }

                Principal.getPlugin().getPlayerMobCoin(p.getName()).withdrawMobCoin(4500);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "giveitens salvação " + p.getName() + " 1");
                p.sendTitle("§aParabéns!", "§aItem adquirido com sucesso!");
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            }

            if (e.getRawSlot() == 21) {
                p = (Player)e.getWhoClicked();
                if (Principal.getPlugin().getPlayerMobCoin(p.getName()).getMobCoin() < 4500) {
                    p.sendMessage("§cVocê não possui mobcoins suficiente.");
                    return;
                }

                Principal.getPlugin().getPlayerMobCoin(p.getName()).withdrawMobCoin(4500);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "giveitens olhodivino " + p.getName() + " 1");
                p.sendTitle("§aParabéns!", "§aItem adquirido com sucesso!");
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            }

            if (e.getRawSlot() == 22) {
                p = (Player)e.getWhoClicked();
                if (Principal.getPlugin().getPlayerMobCoin(p.getName()).getMobCoin() < 4500) {
                    p.sendMessage("§cVocê não possui mobcoins suficiente.");
                    return;
                }

                Principal.getPlugin().getPlayerMobCoin(p.getName()).withdrawMobCoin(4500);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "giveitens supersoco " + p.getName() + " 1");
                p.sendTitle("§a", "§aItem adquirido com sucesso!");
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
            }
        }

    }
}