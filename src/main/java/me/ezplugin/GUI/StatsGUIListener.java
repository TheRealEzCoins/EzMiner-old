package me.ezplugin.GUI;

import me.ezplugin.GUI.GUIS.StatsGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class StatsGUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Stats")) {
            e.setCancelled(true);


            if(e.getCurrentItem() == null){
            } else if(e.getCurrentItem().getType().equals(Material.PAPER)) {
                player.openInventory(StatsGUI.StatsGUI(player));
            }
        }
    }
}