package me.ezplugin.GUI;

import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.GUI.GUIS.GemsGUI;
import me.ezplugin.GUI.GUIS.ResourcesGUI;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ItemUtils;
import me.ezplugin.Utils.ResourceSetup;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ResourceGUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase("§8Resources")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
            } else if(e.getCurrentItem().isSimilar(ItemUtils.customItemUsingStack(ItemManager.GEMSTONE_POT.getItemStack(), "§bGemstone Pot"))) {
                player.openInventory(GemsGUI.GemGUI(player));
                player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_LEATHER, 1f, -5f);
            } else {
                ResourceSetup.ResourceGUISetup(e, player);
                GuiUtils.MiscSetup(e, ForgeGUI.FORGEGUI(player));
            }
        }
    }
}
