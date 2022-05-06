package me.ezplugin.GUI.GUIS;

import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SelectorGUI {
    private static final ItemStack blackglass = Utils.customItemName(Material.BLACK_STAINED_GLASS_PANE, " ");

    private static final int[] black_border = new int[] {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            21, 22, 23, 25, 26, 27, 28, 29, 30, 31,
            32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
            42, 43, 44, 45, 46, 47, 50, 51, 52, 53 };

    public static Inventory SelectorGUI() {
        Inventory inventory = Bukkit.createInventory(null, 54, "Casting");

        inventory.setItem(20, Utils.customItemName(Material.DIAMOND, "§aRefining", "", "§eU can refine ore here"));
        inventory.setItem(24, Utils.customItemName(Material.DIAMOND_PICKAXE, "§aPickaxes", "" ,"§eU can make pickaxes here."));
        inventory.setItem(49, Utils.customItemName(Material.BARRIER, "§cClose", "", "§8Closes the menu."));
        inventory.setItem(48, Utils.customItemName(Material.ARROW, "§bGo back!"));

        for (int slot : black_border)
            inventory.setItem(slot, blackglass);
        return inventory;
    }
}