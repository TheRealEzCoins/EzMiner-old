package me.ezplugin.GUI;

import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.GUI.GUIS.SelectorGUI;
import me.ezplugin.GUI.GUIS.ResourcesGUI;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class ForgeGUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§8Forge")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getType().equals(Material.LAVA_BUCKET)) {
                player.openInventory(SelectorGUI.SelectorGUI());
                player.playSound(player.getLocation(), Sound.BLOCK_IRON_TRAPDOOR_OPEN, 1f, -5f);
            } else if (e.getCurrentItem() != null && e.getCurrentItem().getType().equals(Material.ENDER_CHEST)) {
                player.openInventory(ResourcesGUI.ResourcesGUI(player));
                player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_LEATHER, 1f, -5f);
            }
        }
    }
}