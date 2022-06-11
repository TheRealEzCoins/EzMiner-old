package me.ezplugin.GUI.GUIS;

import me.ezplugin.Utils.GuiUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.ezplugin.Utils.ItemUtils.customItemName;

public class SelectorGUI extends GuiUtils {


    public static Inventory SelectorGUI() {
        Inventory inventory = Bukkit.createInventory(null, 54, "§8Selector");

        GuiUtils.fillEmpty(inventory);

        inventory.setItem(20, customItemName(Material.DIAMOND, "§aRefining", "", "§eU can refine ore here"));
        inventory.setItem(24, customItemName(Material.DIAMOND_PICKAXE, "§aPickaxes", "" ,"§eU can make pickaxes here."));
        inventory.setItem(49, GuiUtils.menuClose());
        inventory.setItem(48, GuiUtils.menuReturn());


        return inventory;
    }
}