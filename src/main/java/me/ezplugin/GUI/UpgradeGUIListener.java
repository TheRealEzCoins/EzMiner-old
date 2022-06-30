package me.ezplugin.GUI;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Resources;
import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.Utils.ForgeUtils;
import me.ezplugin.Utils.GuiUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.text.ParseException;

public class UpgradeGUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase("§8Upgrades")) {
            e.setCancelled(true);
            if(e.getCurrentItem() == null) {
            } else if (e.getRawSlot() == 10 /* FortuneUpgrade */) {
                ForgeUtils.SingleCraft(player, ForgeItems.FortuneUpgrade, Resources.Perfect_Gemstone, 2);

            }
            else {
            GuiUtils.MiscSetup(e, ForgeGUI.FORGEGUI(player));
        }
        }
    }
}
