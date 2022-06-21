package me.ezplugin.GUI;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.GUI.GUIS.SelectorGUI;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.Utils;
import me.ezplugin.Utils.ForgeUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.text.ParseException;


public class PickaxeGUIListener implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent e) throws ParseException {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§8Pickaxe Forge")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
            } else if (e.getSlot() == 10) {

            } else if (e.getSlot() == 11) {
            }
            else {
                GuiUtils.MiscSetup(e, SelectorGUI.SelectorGUI());
            }
        }
    }
}