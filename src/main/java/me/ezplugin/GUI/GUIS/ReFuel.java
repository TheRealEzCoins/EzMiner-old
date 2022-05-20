package me.ezplugin.GUI.GUIS;

import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ReFuel {
    private static final ItemStack blackglass = Utils.customItemName(Material.BLACK_STAINED_GLASS_PANE, " ");

    private static final int[] black_border = new int[] {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
            32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
            42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53 };

    public static Inventory ReFuel() {
        Inventory ReFuelGUI = Bukkit.createInventory(null, 54, "ReFuel");

        ReFuelGUI.setItem(20, Utils.customItemName(Material.DIAMOND, "§aRefining", "", "§eU can refine ore here"));

        for (int slot : black_border)
            ReFuelGUI.setItem(slot, blackglass);
        return ReFuelGUI;
    }
}