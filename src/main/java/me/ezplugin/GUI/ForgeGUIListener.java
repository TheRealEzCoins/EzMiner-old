package me.ezplugin.GUI;

import me.ezplugin.GUI.GUIS.*;
import me.ezplugin.Utils.Files.StatUtils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.text.ParseException;


public class ForgeGUIListener implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent e) throws ParseException {
        Player player = (Player)e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§8Forge")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getType().equals(Material.ENDER_CHEST)) {
                player.openInventory(ResourcesGUI.ResourcesGUI(player));
                player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 1f, -5f);

            } if (e.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)) {
                player.openInventory(PickaxeGUI.PickaxeGUI(player));
                player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 1f, 5f);

            }  else if (e.getCurrentItem().getType().equals(Material.DIAMOND)) {
                player.openInventory(RefiningGUI.RefiningGUI(player));
                player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 1f, 5f);

            } else if(e.getCurrentItem().getType().equals(Material.ENCHANTED_BOOK)) {
                player.openInventory(UpgradeGUI.UpgradeGUI(player));
                player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1f, -5f);

            } else if(e.getSlot() == 41) {
                player.openInventory(ShopGUI.ShopGUI(player));
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 1f, 5f);
            }
        }
    }
}