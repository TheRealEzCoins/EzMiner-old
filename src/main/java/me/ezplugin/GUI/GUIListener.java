package me.ezplugin.GUI;

import me.ezplugin.GUI.GUIS.PickaxeGUI;
import me.ezplugin.GUI.GUIS.StatsGUI;
import me.ezplugin.Items.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;


public class GUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Forge")) {
            e.setCancelled(true);


            if(e.getCurrentItem() == null){
            } else if(e.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)){
                player.openInventory(PickaxeGUI.PickaxeGUI(player));
            } else if(e.getCurrentItem().getType().equals(Material.PAPER)) {
                player.openInventory(StatsGUI.StatsGUI(player));
            }
        }
    }
}
