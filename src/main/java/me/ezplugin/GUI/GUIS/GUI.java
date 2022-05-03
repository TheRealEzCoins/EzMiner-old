package me.ezplugin.GUI.GUIS;

import me.ezplugin.Items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.ezplugin.Utils.Utils.*;

public class GUI {

    private static final ItemStack blackglass = customItemName(Material.BLACK_STAINED_GLASS_PANE, " ");

    private static final int[] black_border = {
            0,  1,  2,  3,  4,  5,  6,  7,  8,
            9, /*i*/ 11, /*i*/ 13 /*i*/,15,16, 17,
            18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28,29,30,31,32,33,34,  35,
            36, 37, 38, 39, 40, 41, 42, 43, 44};

    public static Inventory FORGEGUI() {

        Inventory FORGEGUI = Bukkit.createInventory(null, 45, "Forge");


        FORGEGUI.setItem(10, customItemName(Material.DIAMOND, "§8Resources", "", "§b§8Craft basic resources here."));
        FORGEGUI.setItem(12, customItemName(Material.DIAMOND_PICKAXE, "§8Pickaxes", "", "§b§8Craft pickaxes here."));
        FORGEGUI.setItem(14, customItemName(Material.PAPER, "§8Stats", "", "§b§8Craft pickaxes here."));

        for(int slot : black_border){
            FORGEGUI.setItem(slot, blackglass);
        }

        return FORGEGUI;
    }
}
