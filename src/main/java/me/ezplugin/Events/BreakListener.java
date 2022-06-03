package me.ezplugin.Events;

import me.ezplugin.Enums.Ores;
import me.ezplugin.Utils.BlockUtils;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


public class BreakListener extends BlockUtils implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent block) {
        Player player = block.getPlayer();
        if(block.getBlock().getType().equals(Material.BEDROCK) && (!(player.getGameMode().equals(GameMode.CREATIVE)))) {
            block.setCancelled(true);
        } else {
            BlockUtils.BlockSetup(block, player, Ores.Gems, 500L, 500);
            BlockUtils.BlockSetup(block, player, Ores.Orichalchite, 100L, 100);
        }
    }
}



