package me.ezplugin.Events;

import me.ezplugin.Utils.Files.StatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class CloseInventory implements Listener {
    @EventHandler
    public final void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
    }
}
