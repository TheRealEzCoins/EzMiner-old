package me.ezplugin.GUI.GUIS;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.Utils.GuiUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.text.ParseException;


public class PickaxeGUI extends GuiUtils {

    public static Inventory PickaxeGUI(Player player) throws ParseException {

        Inventory PickaxeGUI = Bukkit.createInventory(null, 54, "§8Pickaxe Forge");
        GuiUtils.fillBorder(PickaxeGUI);

        //GuiUtils.SetupItem(player, PickaxeGUI, ForgeItems.Orichalchite_Pickaxe, Ores.Orichalchite, 16);
        //GuiUtils.SetupItem_2(player, PickaxeGUI, ForgeItems.Obsidian_Pickaxe, Ores.Refined_Gemstone, 15, Ores.Orichalchite, 16);

        PickaxeGUI.setItem(
                49,
                GuiUtils.menuClose());


        PickaxeGUI.setItem(
                48,
                GuiUtils.menuReturn());




        return PickaxeGUI;
    }
}