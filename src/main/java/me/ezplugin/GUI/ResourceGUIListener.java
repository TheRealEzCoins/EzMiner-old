package me.ezplugin.GUI;

import me.ezplugin.Enums.Ores;
import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.GUI.GUIS.ResourcesGUI;
import me.ezplugin.GUI.GUIS.SelectorGUI;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ResourceSetup;
import org.bukkit.Material;
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
            }   else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(GuiUtils.nameSetup(Ores.Orichalchite))) {
                ResourceSetup.ResourceListener(player, e, Ores.Orichalchite);
            } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(GuiUtils.nameSetup(Ores.Gemstone_1))) {
                ResourceSetup.ResourceListener(player, e, Ores.Gemstone_1);
            } else {
                GuiUtils.MiscSetup(e, ForgeGUI.FORGEGUI(player));
            }
        }
    }
}
