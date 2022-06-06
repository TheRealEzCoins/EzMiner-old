package me.ezplugin.GUI.GUIS;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.GuiUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class PickaxeGUI extends GuiUtils {

    private static final ItemStack blackglass = customItemName(Material.BLACK_STAINED_GLASS_PANE, " ");

    private static final int[] black_border = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            17, 18, 26, 27, 35, 36, 44, 46, 47, 50,
            51, 52, 53};

    public static Inventory PickaxeGUI(Player player) {

        Inventory PickaxeGUI = Bukkit.createInventory(null, 54, "§8Pickaxe Forge");


        Integer Level = getLevel(player);

        if(Level >= 1) {
            PickaxeGUI.setItem(
                    10,
                    GuiUtils.createItem(ItemManager.Orichalchite_Pickaxe, Ores.Orichalchite, ForgeItems.Orichalchite_Pickaxe));

            PickaxeGUI.setItem(
                    45,
                    GuiUtils.getStatsAsSkull(player));

            PickaxeGUI.setItem(
                    11,
                    GuiUtils.unlockable(5));

            PickaxeGUI.setItem(
                    49,
                    GuiUtils.menuClose());


            PickaxeGUI.setItem(
                    48,
                    GuiUtils.menuReturn());
        }


        if(Level >= 5) {
            PickaxeGUI.setItem(
                    11,
                    GuiUtils.createItem_2(ItemManager.Obsidian_Pickaxe, Ores.Gemstone_1, Ores.Orichalchite, ForgeItems.Obsidian_Pickaxe));

        }



        for(int slot : black_border){
            PickaxeGUI.setItem(slot, blackglass);
        }

        return PickaxeGUI;
    }
}