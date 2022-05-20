package me.ezplugin.GUI;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ReFuelGUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("ReFuel")) {
            if (e.getCurrentItem() != null)
                if (e.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE)) {
                    e.setCancelled(true);
                }
        }
    }
}
