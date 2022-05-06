package me.ezplugin.GUI;

import me.ezplugin.GUI.GUIS.PickaxeGUI;
import me.ezplugin.GUI.GUIS.SelectorGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class GUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Forge")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null &&
                    e.getCurrentItem().getType().equals(Material.FURNACE))
                player.openInventory(SelectorGUI.SelectorGUI());
        }
    }
}
