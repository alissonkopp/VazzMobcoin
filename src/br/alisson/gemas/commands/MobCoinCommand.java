package br.alisson.gemas.commands;

import br.alisson.gemas.Principal;
import br.alisson.gemas.utils.Helper;
import br.alisson.gemas.utils.PlayerMobCoin;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class MobCoinCommand implements CommandExecutor {
    private Principal plugin;
    NumberFormat df = NumberFormat.getNumberInstance(new Locale("pt", "BR"));

    public MobCoinCommand(Principal plugin) {
        this.plugin = plugin;
        plugin.getCommand("mobcoin").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("mobcoin")) {
            Player p;
            PlayerMobCoin pc;
            if (args.length == 0) {
                p = (Player)sender;
                pc = this.plugin.getPlayerMobCoin(p.getName());
                p.sendMessage("§aSeu saldo atual de mobcoins é: §f" + this.df.format((long)pc.getMobCoin()));
                return true;
            }

            if (args[0].equalsIgnoreCase("loja")) {
                p = (Player)sender;
                Inventory inv = Bukkit.createInventory((InventoryHolder)null, 45, "MobCoins - Loja");
                ItemStack item = new ItemStack(Material.GOLD_BLOCK);
                ItemMeta itemmeta = item.getItemMeta();
                itemmeta.setDisplayName("§eAdquira MobCoins");
                itemmeta.setLore(Arrays.asList("§fSaldo atual: §a" + Principal.getPlugin().getPlayerMobCoin(p.getName()).getMobCoin(), "", "§f§lComo funciona?", "§7Com MobCoins você pode adquirir diversos", "§7livros com encantamentos customizados", "", "§f§lComo consigo?", "§7Para conseguir mobcoins você precisa matar mobs", "§7ou comprar em nossa loja online. Acesse já", "§f# §7e garanta seu pacote."));
                item.setItemMeta(itemmeta);
                ItemStack a1 = new ItemStack(Material.POTION);
                ItemMeta am1 = a1.getItemMeta();
                a1.setAmount(1);
                am1.setDisplayName("§cPoção de Força III");
                am1.setLore(Arrays.asList("§7Poção: §fForça III", "", "§f§lFunção:", "§7É adicionado em seu jogador o efeito de §cForça III", "§7O efeito dura §f120 §7segundos.", " ", "§f§lComo utillizar?", "§aBasta clicar com o botão direito do item!", "§aIdeal para farmar §eMobCoins§7.", " ", "§7Custo: §f2.000 mobcoins.", "§aClique para adquirir este item."));
                a1.setItemMeta(am1);
                ItemStack a2 = new ItemStack(Material.BOOK);
                ItemMeta am2 = a2.getItemMeta();
                a2.setAmount(1);
                am2.setDisplayName("§aLivro de Aspecto Congelante");
                am2.setLore(Arrays.asList("§7Encantamento: §fAspecto Congelante", "", "§f§lFunção:", "§7Ao hitar um jogador haverá uma chance de §f15%", "§7de um arena de gelo ser criada.", " ", "§f§lComo utilizar?", "§aBasta clicar com o botão direito do item!", " ", "§7Custo: §f2.000 mobcoins.", "§aClique para adquirir este item."));
                a2.setItemMeta(am2);
                ItemStack a3 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta am3 = a3.getItemMeta();
                a3.setAmount(1);
                am3.setDisplayName("§aEspada de Mobs");
                am3.setLore(Arrays.asList("§7Encantamento:", " - §fLooting VIII", " - §fSharpness X", " - §fUnbreaking X", "", "§f§lFunção:", "§7Ao matar algum mob com esta §bEspada", "§7Você terá em torno de §f170% §7extra drops.", " ", "§7Custo: §f14.000 mobcoins.", "§aClique para adquirir este item."));
                a3.setItemMeta(am3);
                ItemStack a4 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta am4 = a4.getItemMeta();
                a4.setAmount(1);
                am4.setDisplayName("§BEspada de Ragnarok");
                am4.setLore(Arrays.asList("§7Encantamento:", " - §fLooting X", " - §fSharpness X", " - §fUnbreaking X", "§f§lFunção:", "§7Ao matar algum mob com esta &BEspada", "§7Você terá  em torno de §e200%§7 extra drops.", " ", "§7Custo: §f20.000 mobcoins.", "§aClique para adquirir este item."));
                a4.setItemMeta(am4);
                ItemStack a5 = new ItemStack(Material.BOOK);
                ItemMeta am5 = a5.getItemMeta();
                a5.setAmount(1);
                am5.setDisplayName("§aLivro de Campo de Força");
                am5.setLore(Arrays.asList("§7Encantamento: §fCampo de Força", "", "§f§lFunção:", "§7Ao ser hitado haverá uma chance de §f30% §7do dano", "§7ser anulado.", " ", "§f§lComo utilizar?", "§aBasta clicar com o botão direito do item!", " ", "§7Custo: §f2.000 mobcoins.", "§aClique para adquirir este item."));
                a5.setItemMeta(am5);
                ItemStack a6 = new ItemStack(Material.BOOK);
                ItemMeta am6 = a6.getItemMeta();
                a6.setAmount(1);
                am6.setDisplayName("§aLivro de Aspecto Divino");
                am6.setLore(Arrays.asList("§7Encantamento: §fAspecto Divino", "", "§f§lFunção:", "§7O dano de queda será anulado.", " ", "§f§lComo utilizar?", "§aBasta clicar com o botão direito do item!", " ", "§7Custo: §f2.000 mobcoins.", "§aClique para adquirir este item."));
                a6.setItemMeta(am6);
                ItemStack a7 = new ItemStack(Material.SKULL_ITEM);
                ItemMeta am7 = a7.getItemMeta();
                a7.setAmount(1);
                am7.setDisplayName("§aCabeça de Hydra");
                am7.setLore(Arrays.asList("§7Ao utilizar a Cabeça de Hydra você receberá regeneração", "§f4 §7por §f180 §7, velocidade §f3 §7por §f180", "§7segundos e força §f3 §7por §f180 §7segundos.", " ", "§f§lComo utilizar?", "§7§aBasta clicar com o botão direito!", " ", "§7Custo: §f4.500 mobcoins.", "§aClique para adquirir este item."));
                a7.setItemMeta(am7);
                ItemStack a8 = new ItemStack(Material.ENDER_PEARL);
                ItemMeta am8 = a8.getItemMeta();
                a8.setAmount(1);
                am8.setDisplayName("§aAspecto Noturno");
                am8.setLore(Arrays.asList("§7Ao utilizar o Aspecto Noturno todos os jogadores", "§7que estiverem dentro de uma distância de §f16", "§7de uma distância  de §f16 §7blocos irão receber:", "§7redução de velocidade §f3 §7por §f6 §7segundos e", "§7redução de visão §f3 §7por §6 §7segundos.", " ", "§f§lComo utilizar?", "§7§aBasta clicar com o botão direito!", " ", "§7Custo: §f4.500 mobcoins.", "§aClique para adquirir este item."));
                a8.setItemMeta(am8);
                ItemStack a9 = new ItemStack(Material.FEATHER);
                ItemMeta am9 = a9.getItemMeta();
                a9.setAmount(1);
                am9.setDisplayName("§aA Salvação");
                am9.setLore(Arrays.asList("§7Ao utilizar a Salvação os jogadores dentro de", "§7uma área de §f8 §7blocos serão arremessados", "§7numa distância de §f16 §7blocos.", " ", "§f§lComo utilizar?", "§7§aBasta clicar com o botão direito!", " ", "§7Custo: §f4.500 mobcoins.", "§aClique para adquirir este item."));
                a9.setItemMeta(am9);
                ItemStack a10 = new ItemStack(Material.EYE_OF_ENDER);
                ItemMeta am10 = a10.getItemMeta();
                a10.setAmount(1);
                am10.setDisplayName("§aOlho Divino");
                am10.setLore(Arrays.asList("§7Ao utilizar o Olho Divino você poderá ver", "§7entre qualquer bloco, e passar sobre eles.", "§7Duração do efeito: §f10 segundos§7.", " ", "§f§lComo utilizar?", "§7§aBasta clicar com o botão direito!", " ", "§7Custo: §f4.500 mobcoins.", "§aClique para adquirir este item."));
                a10.setItemMeta(am10);
                ItemStack a11 = new ItemStack(Material.BLAZE_POWDER);
                ItemMeta am11 = a11.getItemMeta();
                a11.setAmount(1);
                am11.setDisplayName("§aSuper Soco");
                am11.setLore(Arrays.asList("§7Ao utilizar o Super Soco o seu próximo", "§7ataque causará §f35% §7a mais de dano.", " ", "§f§lComo utilizar?", "§7§aBasta clicar com o botão direito!", " ", "§7Custo: §f4.500 mobcoins.", "§aClique para adquirir este item."));
                a11.setItemMeta(am11);
                inv.setItem(40, item);
                inv.setItem(10, a1);
                inv.setItem(11, a2);
                inv.setItem(12, a3);
                inv.setItem(13, a4);
                inv.setItem(14, a5);
                inv.setItem(15, a6);
                inv.setItem(16, a7);
                inv.setItem(19, a8);
                inv.setItem(20, a9);
                inv.setItem(21, a10);
                inv.setItem(22, a11);
                p.openInventory(inv);
            }

            OfflinePlayer p3;
            if (args.length == 1) {
                p3 = Bukkit.getOfflinePlayer(args[0]);
                if (!args[0].equalsIgnoreCase(p3.getName())) {
                    sender.sendMessage("§cUtilize /mobcoins <jogador>.");
                    return true;
                }

                if (args[0].equalsIgnoreCase("loja")) {
                    return true;
                }

                if (!this.plugin.getSql().hasAccount(args[0])) {
                    sender.sendMessage("§cEste usuário não existe.");
                    return true;
                }

                pc = this.plugin.getPlayerMobCoin(p3.getName());
                NumberFormat df = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
                sender.sendMessage(PermissionsEx.getUser(p3.getName()).getPrefix().substring(0, 2).replace("&", "§") + p3.getName() + " §epossui: §f" + df.format((long)pc.getMobCoin()) + " mobcoins.");
                return true;
            }

            if (args.length != 3) {
                sender.sendMessage("§eUtilize /mobcoin <adicionar>/<remover>/<definir> <jogador> <quantia>.");
                return true;
            }

            p3 = Bukkit.getOfflinePlayer(args[1]);
            pc = this.plugin.getPlayerMobCoin(p3.getName());
            int cash;
            if (!args[0].equalsIgnoreCase("adicionar") && !args[0].equalsIgnoreCase("give") && !args[0].equalsIgnoreCase("add")) {
                if (!args[0].equalsIgnoreCase("remover") && !args[0].equalsIgnoreCase("take") && !args[0].equalsIgnoreCase("remove")) {
                    if (args[0].equalsIgnoreCase("definir") || args[0].equalsIgnoreCase("set") || args[0].equalsIgnoreCase("define")) {
                        if (!sender.hasPermission("mobcoins.set")) {
                            sender.sendMessage("§cVocê precisa do grupo §bGerente§c ou superior para executar este comando.");
                            return true;
                        }

                        if (Helper.isInteger(args[2])) {
                            cash = Integer.valueOf(args[2]);
                            pc.setMobCoin(cash);
                            sender.sendMessage("§eVocê definiu o mobcoins do " + p3.getName() + " para " + cash + ".");
                            this.plugin.getSql().setMobCoin(p3.getName(), pc.getMobCoin());
                            return true;
                        }
                    }
                } else {
                    if (!sender.hasPermission("mobcoins.take")) {
                        sender.sendMessage("§cVocê precisa do grupo Gerente ou superior para executar este comando.");
                        return true;
                    }

                    if (Helper.isInteger(args[2])) {
                        cash = Integer.valueOf(args[2]);
                        pc.withdrawMobCoin(cash);
                        sender.sendMessage("§eVocê removeu " + cash + " mobcoins de " + PermissionsEx.getUser(p3.getName()).getPrefix().substring(0, 2).replace("&", "§") + p3.getName() + ".");
                        this.plugin.getSql().setMobCoin(p3.getName(), pc.getMobCoin());
                        return true;
                    }
                }
            } else {
                if (!sender.hasPermission("mobcoins.add")) {
                    sender.sendMessage("§cVocê precisa do grupo Gerente ou superior para executar este comando.");
                    return true;
                }

                if (Helper.isInteger(args[2])) {
                    cash = Integer.valueOf(args[2]);
                    pc.depositMobCoin(cash);
                    sender.sendMessage("§eVocê adicionou " + cash + " mobcoins para " + PermissionsEx.getUser(p3.getName()).getPrefix().substring(0, 2).replace("&", "§") + p3.getName() + ".");
                    this.plugin.getSql().setMobCoin(p3.getName(), pc.getMobCoin());
                    return true;
                }
            }
        }

        return false;
    }
}