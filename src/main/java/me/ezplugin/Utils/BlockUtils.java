package me.ezplugin.Utils;

import me.ezplugin.EzMiner;
import me.ezplugin.Items.ItemCreator;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockUtils extends Utils {

    public static void BlockSetup(BlockBreakEvent block, Integer LevelReq, Material ore, Integer Hardness , ItemCreator drop , Player player, Integer ExpAmount, Long RespawnTimer) {
        if (Utils.isEmpty(player)) {
            PersistentDataContainer pick = Utils.getMainHandData(player);
            Boolean CheckTier = pick.has(new NamespacedKey(EzMiner.getPlugin(), "Tier"), PersistentDataType.INTEGER);
            if (block.getBlock().getType() == ore && player.getWorld().getName().equals("world")) {
                if (CheckTier) {
                    int Tier = pick.get(new NamespacedKey(EzMiner.getPlugin(), "Tier"), PersistentDataType.INTEGER);
                    if (Tier >= Hardness) {
                        int CurrentLVL = getLevel(player);
                        if (CurrentLVL >= LevelReq) {
                            int CurrentXP = getXP(player);
                            ItemStack MainHand = player.getInventory().getItemInMainHand();
                            Location BlockLocation = block.getBlock().getLocation();
                            if (pick.has(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER)) {
                                FuelHandler.FuelConsume(player, block);
                            }


                            // Handles Fortune
                            if (MainHand.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                                int min = 1;
                                int max = 3;
                                int Rnd = (int) (Math.random() * (max - min + 1) + min);
                                int getFortune = MainHand.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                                for (int output = Rnd; output < getFortune + 3; output++) {
                                    player.getInventory().addItem(drop.getItemStack());
                                }
                            }
                            if (!(MainHand.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS))) {
                                player.getInventory().addItem(drop.getItemStack());
                            }

                            // Handles basic block breaking events
                            block.setDropItems(false);
                            BlockLocation.getWorld().spawnParticle(Particle.CRIT, BlockLocation.add(0, 1, 0), 10);
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                            block.setCancelled(true);
                            block.getBlock().setType(Material.BEDROCK);
                            Utils.setscore(player, CurrentLVL, CurrentXP + ExpAmount);


                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    block.getBlock().setType(ore);
                                }
                            }.runTaskLater(EzMiner.getPlugin(), RespawnTimer);

                            if (CurrentXP >= Utils.getRatio * CurrentLVL) {
                                int totalLevel = CurrentLVL + 1;
                                setLevel(player, CurrentLVL + 1);
                                setXP(player, CurrentXP - (CurrentLVL * getRatio));
                                player.sendMessage("§bLeveling...");
                                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
                                player.sendMessage("§a§lLevel up!\n§6You are now level: " + totalLevel);
                                Utils.setscore(player, CurrentLVL + 1, CurrentXP - (CurrentLVL * Utils.getRatio));
                            } else {
                                int totalXP = CurrentXP + ExpAmount;
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("" + ChatColor.LIGHT_PURPLE + totalXP + " §9/ " + ChatColor.LIGHT_PURPLE + CurrentLVL * Utils.getRatio + ""));
                                setXP(player, CurrentXP + ExpAmount);
                            }
                        } else {
                            player.sendMessage("§cYou need to be §eLevel " + LevelReq + " §cto mine this.");
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
                            block.setCancelled(true);
                        }
                    } else {
                        player.sendMessage("§cYour pickaxe must be §eTier " + Hardness + " §cto mine this.");
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F);
                        block.setCancelled(true);
                    }
                }
            }

        } else {
            return;
        }
    }
}
