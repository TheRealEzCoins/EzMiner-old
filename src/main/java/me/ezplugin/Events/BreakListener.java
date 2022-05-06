package me.ezplugin.Events;

import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent block) {
        Player player = block.getPlayer();
        Utils.BlockSetup(block, 1, Material.IRON_ORE, 1,  ItemManager.Orichalchite, player, 100, 50L);
    }
}



