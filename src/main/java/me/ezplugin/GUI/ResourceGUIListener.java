package me.ezplugin.GUI;

import me.ezplugin.Enums.Ores;
import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.GUI.GUIS.ResourcesGUI;
import me.ezplugin.GUI.GUIS.SelectorGUI;
import me.ezplugin.Utils.GuiUtils;
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

        if (e.getView().getTitle().equalsIgnoreCase("Resources")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
            } else if (e.getCurrentItem().getType().equals(Material.ARROW)) {
                player.openInventory(ForgeGUI.FORGEGUI(player));

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cClose")) {
                player.closeInventory();
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Locked!")) {
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, -10f);
            }  else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(GuiUtils.nameSetup(Ores.Orichalchite))) {
                GuiUtils.ResourceListener(player, e, Ores.Orichalchite);
            } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(GuiUtils.nameSetup(Ores.Gemstone_1))) {
                GuiUtils.ResourceListener(player, e, Ores.Gemstone_1);
            }
        }
    }
}
