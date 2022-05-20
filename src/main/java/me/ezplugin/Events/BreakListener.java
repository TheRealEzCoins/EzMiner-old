package me.ezplugin.Events;

import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


public class BreakListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent block) {
        Player player = block.getPlayer();
        if(block.getBlock().getType().equals(Material.BEDROCK) && (!(player.getGameMode().equals(GameMode.CREATIVE)))) {
            block.setCancelled(true);
        } else {
            Utils.BlockSetup(block, 1, Material.IRON_ORE, 1, ItemManager.Orichalchite, player, 100, 50L);
            Utils.BlockSetup(block, 15, Material.GREEN_STAINED_GLASS, 2, ItemManager.Gemstone, player, 250, 500L);
        }
    }
}



