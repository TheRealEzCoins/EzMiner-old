package me.ezplugin.GUI;

import me.ezplugin.EzMiner;
import me.ezplugin.GUI.GUIS.GUI;
import me.ezplugin.GUI.GUIS.PickaxeGUI;
import me.ezplugin.GUI.GUIS.SelectorGUI;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.Utils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.text.ParseException;


public class PickaxeGUIListener implements Listener {

        @EventHandler
        public void onOpen (InventoryOpenEvent openEvent) throws ParseException {

            Utils.ForgeTimeSetup(openEvent, ItemManager.Orichalchite_Pickaxe, "OrichTime");
            Utils.ForgeTimeSetup(openEvent, ItemManager.Obsidian_Pickaxe, "ObsidianTime");
        }

    @EventHandler
    public void onClick(InventoryClickEvent e) throws ParseException {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Pickaxe Forge")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
            } else if (e.getCurrentItem().getType().equals(ItemManager.Orichalchite_Pickaxe.getType())) {
                Utils.CustomForgeSetup(
                        player,
                        1,
                        ItemManager.Orichalchite_Pickaxe,
                        ItemManager.Orichalchite,
                        16,
                        60,
                        "OrichTime");

            } else if (e.getCurrentItem().getType().equals(ItemManager.Obsidian_Pickaxe.getType())) {
                Utils.ForgeSetup(
                        player,
                        5,
                        ItemManager.Obsidian_Pickaxe,
                        Material.OBSIDIAN,
                        16,
                        60,
                        "ObsidianTime");
            } else if (e.getCurrentItem().getType().equals(Material.ARROW)) {
                player.openInventory(SelectorGUI.SelectorGUI());

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cClose")) {
                player.closeInventory();
            } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Locked!")) {
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, -10f);
            }
        }
    }
}
