package me.ezplugin.GUI;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.GUI.GUIS.RefiningGUI;
import me.ezplugin.GUI.GUIS.SelectorGUI;
import me.ezplugin.Utils.*;
import me.ezplugin.Utils.Files.StatUtils;
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
            } else if (e.getSlot() == 10) {
                ForgeUtils.SingleCraft(player, ForgeItems.Refined_Gem, Ores.Gemstone, 128);
            } else if(e.getSlot() == 11) {
                ForgeUtils.SingleCraft(player, ForgeItems.Polished_Gem, Ores.Refined_Gemstone, 128);
            } else if(e.getSlot() == 12) {
                ForgeUtils.SingleCraft(player, ForgeItems.Perfect_Gem, Ores.Polished_Gemstone, 128);


























            }  else {
                GuiUtils.MiscSetup(e, SelectorGUI.SelectorGUI());
            }
        }
    }
}