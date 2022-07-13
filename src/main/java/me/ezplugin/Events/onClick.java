package me.ezplugin.Events;

import me.ezplugin.Utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class onClick implements Listener {
    @EventHandler
    public final void onCraftingTable(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(Utils.isEmpty(player)) {
            if(player.getInventory().getItemInMainHand().getType().equals(Material.CRAFTING_TABLE)) {
                if (event.getAction().isRightClick()) {
                player.openWorkbench(player.getLocation(), false);
                }
            }
        }
    }
}
