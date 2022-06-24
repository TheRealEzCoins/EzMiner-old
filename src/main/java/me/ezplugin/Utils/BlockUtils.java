package me.ezplugin.Utils;

import com.jeff_media.morepersistentdatatypes.DataType;
import me.ezplugin.Enums.Resources;
import me.ezplugin.EzMiner;
import me.ezplugin.Utils.Files.StatUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.persistence.PersistentDataType;


public class BlockUtils {
    /**
     * It handles the block break event.
     *
     * @param block The block that was broken.
     * @param player The player who broke the block
     * @param ores The Ores enum that you want to use.
     * @param ExpAmount The amount of experience the player will receive for mining the block.
     */
    public static void BlockSetup(BlockBreakEvent block, Player player, Resources ores, int ExpAmount) {

        Block getBlock = block.getBlock();
        if(getBlock.getType().equals(ores.getBlock())) {
            if (Utils.isEmpty(player)) {
                if (Utils.getMainHandData(player).has(new NamespacedKey(EzMiner.getPlugin(), "Pickaxe"), DataType.BOOLEAN)) {
                    if (FuelHandler.getFuel(player)) {
                        FuelHandler.FuelConsume(player, block);
                        if (StatUtils.getHashLevel(player) >= ores.getLevel()) {
                            if (Utils.getMainHandData(player).has(new NamespacedKey(EzMiner.getPlugin(), "Tier"), PersistentDataType.INTEGER)) {
                                if (Utils.getTier(player) >= ores.getTier()) {


                                    StatUtils.getResources(player, ores);
                                    Utils.HandleFortune(player, ores);
                                    block.setDropItems(false);
                                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);

                                    Utils.HandleXP(player, ExpAmount);

                                    Utils.HandleFragment(player, ores.getTier());


                                } else {
                                    player.sendMessage("§cYour pickaxe must be §eTier " + ores.getTier() + " §cto mine this.");
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F);
                                    block.setCancelled(true);
                                }
                            } else {
                                player.sendMessage("§cYou need to hold an appropriate pickaxe to mine this!");
                                block.setCancelled(true);
                            }
                        } else {
                            player.sendMessage("§cYou need to be §eLevel " + ores.getLevel() + " §cto mine this.");
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
                            block.setCancelled(true);
                        }
                    }
                }
            }
        }

    }

}
