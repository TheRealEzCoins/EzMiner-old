package me.ezplugin.GUI;

import me.ezplugin.EzMiner;
import me.ezplugin.GUI.GUIS.GUI;
import me.ezplugin.GUI.GUIS.PickaxeGUI;
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

            Utils.ForgeTimeSetup(openEvent, ItemManager.OrichalchitePickaxe, "OrichTime");
            Utils.ForgeTimeSetup(openEvent, ItemManager.ObsidianPickaxe, "ObsidianTime");
        }

    @EventHandler
    public void onClick(InventoryClickEvent e) throws ParseException {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Pickaxe Forge")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
            } else if (e.getCurrentItem().getType().equals(ItemManager.OrichalchitePickaxe.getType())) {
                Utils.CustomForgeSetup(
                        player,
                        1,
                        ItemManager.OrichalchitePickaxe,
                        ItemManager.Orichalchite,
                        16,
                        60,
                        "OrichTime");

            } else if (e.getCurrentItem().getType().equals(ItemManager.ObsidianPickaxe.getType())) {
                Utils.ForgeSetup(
                        player,
                        5,
                        ItemManager.ObsidianPickaxe,
                        Material.OBSIDIAN,
                        16,
                        60,
                        "ObsidianTime");
            } else if (e.getCurrentItem().getType().equals(Material.ARROW)) {
                player.openInventory(GUI.FORGEGUI());

            } else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
                player.closeInventory();
            }
        }
    }
}
