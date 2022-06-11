package me.ezplugin.Utils;

import me.ezplugin.Enums.Ores;
import me.ezplugin.Enums.Stats;
import me.ezplugin.EzMiner;
import me.ezplugin.Utils.Stats.StatUtils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

import static me.ezplugin.Utils.ResourceSetup.checkResources;
import static me.ezplugin.Utils.Utils.*;

public class BlockUtils {
    public static void BlockSetup(BlockBreakEvent block, Player player, Ores ores, Long RespawnTimer, int ExpAmount) {

        Block getBlock = block.getBlock();
        if(getBlock.getType().equals(ores.getBlock())) {
            if (Utils.isEmpty(player)) {
                    if(getLevel(player) >= ores.getLevel()) {
                        if(Utils.getTier(player) >= ores.getTier()) {

                            if (FuelHandler.getFuel(player)) {
                                FuelHandler.FuelConsume(player, block);
                            }

                            checkResources(player, ores);
                            Utils.doFortune(player, ores);
                            block.setDropItems(false);
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                            block.setCancelled(true);
                            block.getBlock().setType(Material.BEDROCK);


                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    block.getBlock().setType(ores.getBlock());
                                }
                            }.runTaskLater(EzMiner.getPlugin(), RespawnTimer);


                            Utils.HandleXP(player, ExpAmount);


                        }else {
                            player.sendMessage("§cYour pickaxe must be §eTier " + ores.getTier() + " §cto mine this.");
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F);
                            block.setCancelled(true);
                        }
                    } else {
                        player.sendMessage("§cYou need to be §eLevel " + ores.getLevel() + " §cto mine this.");
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
                        block.setCancelled(true);
                    }
                }
        } else {
            block.setCancelled(true);
        }

    }

}
