package me.ezplugin.GUI.GUIS;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.gui.type.util.Gui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import dev.dbassett.skullcreator.SkullCreator;
import me.ezplugin.Enums.Heads;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ItemUtils;
import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.text.ParseException;

import static me.ezplugin.Utils.ItemUtils.customItemName;
import static me.ezplugin.Utils.ItemUtils.customItemUsingStack;

public class ForgeGUI {




    public static Inventory FORGEGUI(Player player) {

        Inventory FORGEGUI = Bukkit.createInventory(null, 54, "§8Forge");

        GuiUtils.fillEmpty(FORGEGUI);

        FORGEGUI.setItem(20, customItemName(Material.DIAMOND, "§aRefining", "", "§eYou can refine ore here."));
        FORGEGUI.setItem(22, customItemName(Material.ENCHANTED_BOOK, "§aUpgrades", "", "§eYou can forge upgrades here."));
        FORGEGUI.setItem(24, customItemName(Material.DIAMOND_PICKAXE, "§aPickaxes", "" ,"§eYou can make pickaxes here."));


        FORGEGUI.setItem(39,
                customItemName(
                        Material.ENDER_CHEST,
                        "§aResources"));

        FORGEGUI.setItem(
                40,
                GuiUtils.getStatsAsSkull(player));

        FORGEGUI.setItem(41, customItemUsingStack(SkullCreator.itemFromUrl(Heads.Shop.getURL()), "§6Shop"));



        return FORGEGUI;
    }

    public static Gui forgeGUI(Player player) {

        ItemStack background = ItemUtils.customItemName(Material.BLACK_STAINED_GLASS_PANE, "");

        ChestGui menu = new ChestGui(6, "§8Forge");

        menu.setOnTopClick(event -> event.setCancelled(true));

        OutlinePane pane = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);

        pane.addItem(new GuiItem(background));
        pane.setRepeat(true);

        menu.addPane(pane);

        StaticPane RefineSlot = new StaticPane(2, 2, 1, 1);
        StaticPane UpgradeSlot = new StaticPane(4, 2, 1, 1);
        StaticPane PickaxeSlot = new StaticPane(6, 2, 1, 1);
        StaticPane ResourceSlot = new StaticPane(3, 4, 1, 1);
        StaticPane PlayerSlot = new StaticPane(4, 4, 1, 1);
        StaticPane ShopSlot = new StaticPane(5, 4, 1, 1);

        ItemStack Refine = ItemUtils.customItemName(Material.DIAMOND, "§aRefinery", "", "§7Refine items here!");
        ItemStack Upgrades = ItemUtils.customItemName(Material.ENCHANTED_BOOK, "§aUpgrades", "", "§7You can forge upgrades here!");
        ItemStack Pickaxes = ItemUtils.customItemName(Material.DIAMOND_PICKAXE, "§aPickaxes", "", "§7You can make pickaxes here!");
        ItemStack Resources = ItemUtils.customItemName(Material.ENDER_CHEST, "§aResources");
        ItemStack PlayerItem = GuiUtils.getStatsAsSkull(player);
        ItemStack ShopItem = customItemUsingStack(SkullCreator.itemFromUrl(Heads.Shop.getURL()), "§6Shop");

        RefineSlot.addItem(new GuiItem(Refine, event -> {
            try {
                player.openInventory(RefiningGUI.RefiningGUI(player));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }), 0, 0);

        UpgradeSlot.addItem(new GuiItem(Upgrades, event -> {
            player.openInventory(UpgradeGUI.UpgradeGUI(player));
        }), 0, 0);

        PickaxeSlot.addItem(new GuiItem(Pickaxes, event -> {
            player.openInventory(PickaxeGUI.PickaxeGUI(player));
        }), 0, 0);

        ResourceSlot.addItem(new GuiItem(Resources, event -> {
            player.openInventory(ResourcesGUI.ResourcesGUI(player));
        }), 0, 0);

        PlayerSlot.addItem(new GuiItem(PlayerItem), 0, 0);

        ShopSlot.addItem(new GuiItem(ShopItem, event -> {
            player.openInventory(ShopGUI.ShopGUI(player));
        }), 0, 0);








        menu.addPane(RefineSlot);
        menu.addPane(UpgradeSlot);
        menu.addPane(PickaxeSlot);
        menu.addPane(ResourceSlot);
        menu.addPane(PlayerSlot);
        menu.addPane(ShopSlot);


        return menu;
    }
}
