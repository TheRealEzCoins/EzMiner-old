package me.ezplugin.GUI;

import me.ezplugin.Enums.ForgeItems;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CheatGUIListener implements Listener {
    @EventHandler
    final void onItemClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equalsIgnoreCase("§cCheatGUI")) {
            event.setCancelled(true);
            if (event.getCurrentItem() != null) {
                for (ForgeItems items : ForgeItems.values()) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equals(items.getOuput().getName())) {
                        player.getInventory().addItem(items.getOuput().getItemStack());
                    }
                }
            }
        }

    }
}
