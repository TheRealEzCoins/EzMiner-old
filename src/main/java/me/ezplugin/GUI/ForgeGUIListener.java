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
            if (e.getCurrentItem() == null) {

            } else if(e.getRawSlot() == 39) {
                player.openInventory(ResourcesGUI.ResourcesGUI(player));
                player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 1f, -5f);

            } else if (e.getRawSlot() == 24) {
                player.openInventory(PickaxeGUI.PickaxeGUI(player));
                player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 1f, 5f);

            }  else if (e.getRawSlot() == 20) {
                player.openInventory(RefiningGUI.RefiningGUI(player));
                player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 1f, 5f);

            } else if(e.getRawSlot() == 22) {
                player.openInventory(UpgradeGUI.UpgradeGUI(player));
                player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1f, -5f);

            } else if(e.getRawSlot() == 41) {
                player.openInventory(ShopGUI.ShopGUI(player));
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 1f, 5f);
            }
        }
    }
}