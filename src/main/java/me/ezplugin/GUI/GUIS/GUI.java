package me.ezplugin.GUI.GUIS;

import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.ezplugin.Utils.Utils.*;

public class GUI {

    private static final ItemStack blackglass = customItemName(Material.BLACK_STAINED_GLASS_PANE, " ");
    private static final ItemStack Redglass = Utils.customItemName(Material.RED_STAINED_GLASS_PANE, " ");

    private static final int[] black_border = new int[] {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 16, 17, 18, 19, 25, 26, 27, 28, 34,
            35, 36, 37, 43, 44, 45, 46, 47, 48, 49,
            50, 51, 52, 53 };

    private static final int[] red_glass = new int[] {
            20, 21, 22, 23, 24, 29, 30, 31, 32, 33,
            38, 39, 40, 41, 42 };

    public static Inventory FORGEGUI() {

        Inventory FORGEGUI = Bukkit.createInventory(null, 54, "Forge");

        FORGEGUI.setItem(11, Utils.customItemName(Material.FURNACE, "§bForge items here."));
        FORGEGUI.setItem(12, Utils.customItemName(Material.FURNACE, "§bForge items here."));
        FORGEGUI.setItem(13, Utils.customItemName(Material.FURNACE, "§bForge items here."));
        FORGEGUI.setItem(14, Utils.customItemName(Material.FURNACE, "§bForge items here."));
        FORGEGUI.setItem(15, Utils.customItemName(Material.FURNACE, "§bForge items here."));

        for(int slot : black_border){
            FORGEGUI.setItem(slot, blackglass);
        }
        for (int slot : red_glass)
            FORGEGUI.setItem(slot, Redglass);

        return FORGEGUI;
    }
}
