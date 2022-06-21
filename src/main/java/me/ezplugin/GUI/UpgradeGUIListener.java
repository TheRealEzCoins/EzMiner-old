package me.ezplugin.GUI;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.GUI.GUIS.SelectorGUI;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.ForgeUtils;
import me.ezplugin.Utils.GuiUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.text.ParseException;

public class UpgradeGUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) throws ParseException {
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase("§8Upgrades")) {
            e.setCancelled(true);
            if(e.getCurrentItem() == null) {
            } else if (e.getSlot() == 10 /* FortuneUpgrade */) {
                ForgeUtils.SingleCraft(player, ForgeItems.FortuneUpgrade, Ores.Perfect_Gemstone, 4);

            }
            else {
            GuiUtils.MiscSetup(e, SelectorGUI.SelectorGUI());
        }
        }
    }
}
