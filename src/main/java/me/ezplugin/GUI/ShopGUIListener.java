package me.ezplugin.GUI;

import me.ezplugin.Enums.ShopItems;
import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.GUI.GUIS.PickaxeGUI;
import me.ezplugin.GUI.GUIS.RefiningGUI;
import me.ezplugin.GUI.GUIS.UpgradeGUI;
import me.ezplugin.Utils.Files.StatUtils;
import me.ezplugin.Utils.GuiUtils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.text.ParseException;

public class ShopGUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§8Shop")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                GuiUtils.MiscSetup(e, ForgeGUI.FORGEGUI(player));
                for(ShopItems items : ShopItems.values()) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(items.getItem().getName())) {
                        if (StatUtils.getHashLevel(player) >= items.getLevel()) {
                            if (StatUtils.getHashFragments(player) >= items.getCost()) {
                                StatUtils.removeFragments(player, items.getCost());
                                StatUtils.setMaterials(player, items, StatUtils.getMaterials(player, items) + 1);
                            } else {
                                player.sendMessage("§cYou do not have enough Fragments!");
                            }
                        }
                    }
                }
            }
        }
    }
}
