package me.ezplugin.GUI;

import me.ezplugin.GUI.GUIS.GUI;
import me.ezplugin.GUI.GUIS.PickaxeGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SelectorGUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Casting")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null)
                if (e.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)) {
                    player.openInventory(PickaxeGUI.PickaxeGUI(player));
                } else if (e.getCurrentItem().getType().equals(Material.ARROW)) {
                    player.openInventory(GUI.FORGEGUI());
                } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
                    player.closeInventory();
                }
        }
    }
}
