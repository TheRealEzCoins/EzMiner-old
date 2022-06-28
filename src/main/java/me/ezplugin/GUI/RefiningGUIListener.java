package me.ezplugin.GUI;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Resources;
import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.Utils.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.text.ParseException;


public class RefiningGUIListener implements Listener {

    // This is the listener for the Refining GUI. It checks if the player has the required level and resources to forge the
    // item. If they do, it will take the resources and start the forge.
    @EventHandler
    public void onClick(InventoryClickEvent e) throws ParseException {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§8Refining")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
            } else if (e.getRawSlot() == 10) {
                ForgeUtils.SingleCraft(player, ForgeItems.Refined_Gem, Resources.Gemstone, 16);
            } else if(e.getRawSlot() == 11) {
                ForgeUtils.SingleCraft(player, ForgeItems.Polished_Gem, Resources.Refined_Gemstone, 2);
            } else if(e.getRawSlot() == 12) {
                ForgeUtils.SingleCraft(player, ForgeItems.Perfect_Gem, Resources.Polished_Gemstone, 2);


























            }  else {
                GuiUtils.MiscSetup(e, ForgeGUI.FORGEGUI(player));
            }
        }
    }
}