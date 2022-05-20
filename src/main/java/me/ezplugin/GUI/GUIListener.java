package me.ezplugin.GUI;

import me.ezplugin.GUI.GUIS.GUI;
import me.ezplugin.GUI.GUIS.ReFuel;
import me.ezplugin.GUI.GUIS.SelectorGUI;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;


public class GUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Forge")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getType().equals(Material.LAVA_BUCKET)) {
                player.openInventory(SelectorGUI.SelectorGUI());
                player.playSound(player.getLocation(), Sound.BLOCK_IRON_TRAPDOOR_OPEN, 1f, -5f);
            } if (e.getCurrentItem() != null && e.getCurrentItem().getType().equals(Material.COOKIE)) {
                ItemStack item = GUI.FORGEGUI(player).getItem(1);
            }
        }
    }
}
