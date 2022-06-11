package me.ezplugin.Commands;

import me.ezplugin.Enums.Ores;
import me.ezplugin.EzMiner;
import me.ezplugin.GUI.GUIS.GemsGUI;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.Utils.Stats.StatUtils;
import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;




public class Commands implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;
        PersistentDataContainer data = player.getPersistentDataContainer();
                if (!(sender instanceof Player)) {
            sender.sendMessage("No");
            return true;
        } if(cmd.getName().equalsIgnoreCase("EzMiner")) {
                    if(args.length == 0) {
                            player.openInventory(ForgeGUI.FORGEGUI(player));

                    } else {
                        if(args[0].equalsIgnoreCase("Forge")) {
                            player.openInventory(ForgeGUI.FORGEGUI(player));
                        } else if(args[0].equalsIgnoreCase("Pickaxe")) {
                            if (player.hasPermission("EzMiner.Pickaxe")) {
                                player.getInventory().addItem(ItemManager.Orichalchite_Pickaxe.getItemStack());
                                player.getInventory().addItem(ItemManager.Obsidian_Pickaxe.getItemStack());
                                player.getInventory().addItem(ItemManager.OIL_BARREL.getItemStack());
                            }
                        } else if(args[0].equalsIgnoreCase("Stats")) {
                            if (args.length < 2) {
                                player.sendMessage("§b" + player.getName() + "'s stats:" + "\n§cLevel: " + Utils.getLevel(player) + "\n§cXP: " + Utils.getXP(player));
                            } else {
                                Player Target = Bukkit.getPlayer(args[1]);
                                if (Target != null) {
                                    int XP = StatUtils.getHashXP(player);
                                    int LEVEL = StatUtils.getHashLevel(player);
                                    player.sendMessage("§b" + Target.getName() + "'s stats:" + "\n§cLevel: " + LEVEL + "\n§cXP: " + XP);
                                } else {
                                    player.sendMessage("§cThat is not a valid player.");
                                }
                            }
                        } else if(args[0].equalsIgnoreCase("Reset")) {
                            if (player.hasPermission("EzMiner.Reset")) {
                                StatUtils.setHashXP(player, 0);
                                StatUtils.setHashLevel(player, 1);
                                player.sendMessage("§aReset xp!");
                            }
                        } else if(args[0].equalsIgnoreCase("Set")) {
                            if(player.hasPermission("EzMiner.Set")) {
                                if (args.length != 4) {
                                    player.sendMessage("§cCorrect usage /set <Player> <XP> <LEVEL>");
                                } else {
                                    Player Target = Bukkit.getPlayer(args[1]);
                                    if (Target != null) {
                                        int XP = Integer.parseInt(args[2]);
                                        int LEVEL = Integer.parseInt(args[3]);
                                        if (args[1] != null && args[2] != null) {
                                            StatUtils.setHashXP(player, XP);
                                            StatUtils.setHashLevel(player, LEVEL);
                                            player.sendMessage("§bPlayer: " + Target.getName() + "\n§cIs now level: " + LEVEL + "\nAnd has: " + XP + " XP");
                                        } else {
                                            player.sendMessage("§cPlease use a number to set the XP and LEVEL");
                                        }
                                    } else {
                                        player.sendMessage("§cThat is not a valid player!");
                                    }
                                }
                            }
                        } else if(args[0].equalsIgnoreCase("ResetAll")) {
                            if(player.hasPermission("EzMiner.ResetAll")) {
                                StatUtils.setHashXP(player, 0);
                                StatUtils.setHashLevel(player, 1);
                                for(Ores ores : Ores.values()) {
                                    StatUtils.setResources(player, ores, 0);
                                }
                            }
                        } else if(args[0].equalsIgnoreCase("Miner")) {
                            player.teleport(Bukkit.getWorld("MineWorld").getSpawnLocation());
                        } else if(args[0].equalsIgnoreCase("AdminWorld")) {
                            if(player.hasPermission("EzMiner.AdminWorld")) {
                                player.teleport(Bukkit.getWorld("MiningWorld_Main").getSpawnLocation());
                            }
                        } else if(args[0].equalsIgnoreCase("Help")) {
                            player.sendMessage("§6§l----------------------------------------------------");
                            player.sendMessage("          §b§lEzMiner ~ By EzCoins         ");
                            player.sendMessage(" ");
                            player.sendMessage("§e§l/EzMiner Forge : §fOpens the forge menu.");
                            player.sendMessage(" ");
                            player.sendMessage("§e§l/EzMiner Stats : §fCheck your current stats.");
                            player.sendMessage(" ");
                            player.sendMessage("§e§l/EzMiner Miner : §fTeleports you to the mining world.");
                            player.sendMessage(" ");
                            player.sendMessage("§6§l---------------------------------------------------");
                            if(player.hasPermission("EzMiner.*")) {
                                player.sendMessage("§6§l---------------------------------------------------");
                                player.sendMessage("              §c§lAdmin Commands           ");
                                player.sendMessage(" ");
                                player.sendMessage("§c§l/EzMiner Reset : §fResets your stats.");
                                player.sendMessage(" ");
                                player.sendMessage("§c§l/EzMiner Set : §fSet your stats to your own liking.");
                                player.sendMessage(" ");
                                player.sendMessage("§c§l/EzMiner ResetAll : §fResets everything.");
                                player.sendMessage(" ");
                                player.sendMessage("§c§l/EzMiner AdminWorld : §fTeleports you to the admin world.");
                                player.sendMessage("§6§l---------------------------------------------------");
                            }
                        } else if(args[0].equalsIgnoreCase("test")) {
                            player.openInventory(GemsGUI.GemGUI(player));
                        }

                    }

        }

            return true;
        }
    }
