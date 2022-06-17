package me.ezplugin.GUI;

import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.GUI.GUIS.PickaxeGUI;
import me.ezplugin.GUI.GUIS.RefiningGUI;
import me.ezplugin.GUI.GUIS.UpgradeGUI;
import me.ezplugin.Utils.GuiUtils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SelectorGUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§8Selector")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null)
                if (e.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)) {
                    player.openInventory(PickaxeGUI.PickaxeGUI(player));
                    player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 1f, 5f);
                }  else if (e.getCurrentItem().getType().equals(Material.DIAMOND)) {
                    player.openInventory(RefiningGUI.RefiningGUI(player));
                    player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 1f, 5f);
                } else if(e.getCurrentItem().getType().equals(Material.ENCHANTED_BOOK)) {
                    player.openInventory(UpgradeGUI.UpgradeGUI(player));
                    player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1f, -5f);
                } else {
                    GuiUtils.MiscSetup(e, ForgeGUI.FORGEGUI(player));
                }
        }
    }
}
