package me.ezplugin.Events;

import com.jeff_media.morepersistentdatatypes.DataType;
import me.ezplugin.Enums.Ores;
import me.ezplugin.Utils.BlockUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.persistence.PersistentDataContainer;


public class BreakListener extends BlockUtils implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent block) {
        Player player = block.getPlayer();
        World world = player.getWorld();
        Block BrokenBlock = block.getBlock();
        if(world.equals(Bukkit.getWorld("MineWorld"))) {
            if (block.getBlock().getType().equals(Material.BEDROCK) && (!(player.getGameMode().equals(GameMode.CREATIVE)))) {
                block.setCancelled(true);
            } else {
                BlockSetup(block, player, Ores.Gemstone_1, 500L, 500);
                BlockSetup(block, player, Ores.Orichalchite, 100L, 100);
            }
        }
    }
}



