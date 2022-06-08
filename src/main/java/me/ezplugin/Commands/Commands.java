package me.ezplugin.Commands;

import me.ezplugin.Enums.Ores;
import me.ezplugin.EzMiner;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.Utils.Utils;
import me.ezplugin.World.WorldCreation;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Commands implements CommandExecutor {

    static FileConfiguration config = EzMiner.plugin.getConfig();


    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;
        PersistentDataContainer data = player.getPersistentDataContainer();
                if (!(sender instanceof Player)) {
            sender.sendMessage("No");
            return true;
        } if(cmd.getName().equalsIgnoreCase("EzMiner")) {
                    if(args.length == 0) {
                            player.sendMessage("§6§l----------------------------------------------------");
                            player.sendMessage("          §b§lEzMiner ~ By EzCoins         ");
                            player.sendMessage(" ");
                            player.sendMessage("§e§l/EzMiner Forge : §fOpens the forge menu.");
                            player.sendMessage(" ");
                            player.sendMessage("§e§l/EzMiner Stats : §fCheck your current stats.");
                            player.sendMessage(" ");
                            player.sendMessage("§e§l/EzMiner Miner : §fTeleports you to the mining world.");
                            player.sendMessage(" ");
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
                                    int XP = Utils.getXP(player);
                                    int LEVEL = Utils.getLevel(player);
                                    player.sendMessage("§b" + Target.getName() + "'s stats:" + "\n§cLevel: " + LEVEL + "\n§cXP: " + XP);
                                } else {
                                    player.sendMessage("§cThat is not a valid player.");
                                }
                            }
                        } else if(args[0].equalsIgnoreCase("Reset")) {
                            if (player.hasPermission("EzMiner.Reset")) {
                                data.set(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER, 0);
                                data.set(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER, 1);
                                player.sendMessage("§aReset xp!");
                            }
                        } else if(args[0].equalsIgnoreCase("Set")) {
                            if (args.length != 4) {
                                player.sendMessage("§cCorrect usage /set <Player> <XP> <LEVEL>");
                            } else {
                                Player Target = Bukkit.getPlayer(args[1]);
                                if (Target != null) {
                                    int XP = Integer.parseInt(args[2]);
                                    int LEVEL = Integer.parseInt(args[3]);
                                    if (args[1] != null && args[2] != null) {
                                        PersistentDataContainer var = Target.getPersistentDataContainer();
                                        var.set(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER, XP);
                                        var.set(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER, LEVEL);
                                        player.sendMessage("§bPlayer: " + Target.getName() + "\n§cIs now level: " + LEVEL + "\nAnd has: " + XP + " XP");
                                    } else {
                                        player.sendMessage("§cPlease use a number to set the XP and LEVEL");
                                    }
                                } else {
                                    player.sendMessage("§cThat is not a valid player!");
                                }
                            }
                        } else if(args[0].equalsIgnoreCase("ResetAll")) {
                            data.set(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER, 0);
                            data.set(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER, 1);
                            data.set(new NamespacedKey(EzMiner.getPlugin(), Ores.Gemstone_1.name()), PersistentDataType.INTEGER, 0);
                            data.set(new NamespacedKey(EzMiner.getPlugin(), Ores.Orichalchite.name()), PersistentDataType.INTEGER, 0);
                        } else if(args[0].equalsIgnoreCase("Miner")) {
                            player.teleport(Bukkit.getWorld("MineWorld").getSpawnLocation());
                        } else if(args[0].equalsIgnoreCase("AdminWorld")) {
                            player.teleport(Bukkit.getWorld("MiningWorld_Main").getSpawnLocation());
                        }

                    }

        }

            return true;
        }
    }
