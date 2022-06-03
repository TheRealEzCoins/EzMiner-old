package me.ezplugin.Commands;

import com.jeff_media.morepersistentdatatypes.DataType;
import jdk.javadoc.internal.doclint.HtmlTag;
import me.ezplugin.EzMiner;
import me.ezplugin.GUI.GUIS.StatsGUI;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BlockDataMeta;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;


public class Commands implements CommandExecutor {

    static FileConfiguration config = EzMiner.plugin.getConfig();


    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;
        PersistentDataContainer data = player.getPersistentDataContainer();
                if (!(sender instanceof Player)) {
            sender.sendMessage("No");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("Forge") && sender instanceof Player) {
            player.openInventory(ForgeGUI.FORGEGUI(player));
        }

        if (cmd.getName().equalsIgnoreCase("Pickaxe")) {
            if(player.hasPermission("EzMiner.Pickaxe")) {
                player.getInventory().addItem(ItemManager.Orichalchite_Pickaxe.getItemStack());
                player.getInventory().addItem(ItemManager.Obsidian_Pickaxe.getItemStack());
            }
        }

        if (cmd.getName().equalsIgnoreCase("CheckXP")) {
            if(args.length < 1) {
                player.sendMessage("§b" + player.getName() + "'s stats:" + "\n§cLevel: " + Utils.getLevel(player) + "\n§cXP: " + Utils.getXP(player));
            } else {
            Player Target = Bukkit.getPlayer(args[0]);
                if(Target != null) {
                    PersistentDataContainer TargetData = Target.getPersistentDataContainer();
                    int XP = Utils.getXP(player);
                    int LEVEL = Utils.getLevel(player);
                    player.sendMessage("§b" + Target.getName() + "'s stats:" + "\n§cLevel: " + LEVEL + "\n§cXP: " + XP);
                } else {
                    player.sendMessage("§cThat is not a valid player.");
                }
            }
        }

        if (cmd.getName().equalsIgnoreCase("ResetXP")) {
            if(player.hasPermission("EzMiner.ResetXP")) {
                data.set(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER, 0);
                data.set(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER, 1);
                player.sendMessage("§aReset xp!");
            }
        }

        if(cmd.getName().equalsIgnoreCase("Date")) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            player.sendMessage(format.format(date));
        }

        if (cmd.getName().equalsIgnoreCase("CreateBlock")) {
            if(player.hasPermission("EzMiner.CreateBlock")) {
                Block getTargetBlock = player.getTargetBlockExact(5);
                assert getTargetBlock != null;
                getTargetBlock.setMetadata("CustomBlock", new MetadataValue() {
                    @Nullable
                    @Override
                    public Object value() {
                        return null;
                    }

                    @Override
                    public int asInt() {
                        return 0;
                    }

                    @Override
                    public float asFloat() {
                        return 0;
                    }

                    @Override
                    public double asDouble() {
                        return 0;
                    }

                    @Override
                    public long asLong() {
                        return 0;
                    }

                    @Override
                    public short asShort() {
                        return 0;
                    }

                    @Override
                    public byte asByte() {
                        return 0;
                    }

                    @Override
                    public boolean asBoolean() {
                        return false;
                    }

                    @NotNull
                    @Override
                    public String asString() {
                        return null;
                    }

                    @Nullable
                    @Override
                    public Plugin getOwningPlugin() {
                        return EzMiner.getPlugin();
                    }

                    @Override
                    public void invalidate() {

                    }

                });
                player.sendMessage("Block set!.");
            }
        } if (cmd.getName().equalsIgnoreCase("BreakBlock")) {
            Block getBlock = player.getTargetBlockExact(5);
            assert getBlock != null;
            getBlock.removeMetadata("CustomBlock", EzMiner.getPlugin());
            getBlock.setType(Material.AIR);
        }

        if(cmd.getName().equalsIgnoreCase("SetXP")) {
            if(args.length != 3) {
                player.sendMessage("§cCorrect usage /setXP <Player> <XP> <LEVEL>");
            }  else {
                Player Target = Bukkit.getPlayer(args[0]);
                if (Target != null) {
                    int XP = Integer.parseInt(args[1]);
                    int LEVEL = Integer.parseInt(args[2]);
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

        } if (cmd.getName().equalsIgnoreCase("Stats")) {
            player.openInventory(StatsGUI.StatsGUI(player));
        }

            return true;
        }
    }
