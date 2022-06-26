package me.ezplugin.GUI;

import me.ezplugin.Enums.ShopItems;
import me.ezplugin.Enums.Type;
import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.GUI.GUIS.PickaxeGUI;
import me.ezplugin.GUI.GUIS.RefiningGUI;
import me.ezplugin.GUI.GUIS.UpgradeGUI;
import me.ezplugin.Items.Items.MaterialItems;
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
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ShopItems.FUEL.getItem().getName())) {
                    if (StatUtils.getHashLevel(player) >= ShopItems.FUEL.getLevel()) {
                        if (StatUtils.getHashFragments(player) >= ShopItems.FUEL.getCost()) {
                            StatUtils.removeFragments(player, ShopItems.FUEL.getCost());
                            player.getInventory().addItem(MaterialItems.OIL_BARREL.getItemStack());
                        } else {
                            player.sendMessage("§cYou do not have enough Fragments!");
                        }
                    }
                }
                GuiUtils.MiscSetup(e, ForgeGUI.FORGEGUI(player));
                for(ShopItems items : ShopItems.values()) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(items.getItem().getName())) {
                        if(items.getType().equals(Type.Material)) {
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
}
