package me.ezplugin.GUI.GUIS;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Resources;
import me.ezplugin.Enums.ShopItems;
import me.ezplugin.Utils.GuiUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class PickaxeGUI extends GuiUtils {

    public static Inventory PickaxeGUI(Player player) {

        Inventory PickaxeGUI = Bukkit.createInventory(null, 54, "§8Pickaxe Forge");
        GuiUtils.fillBorder(PickaxeGUI);

        //GuiUtils.SetupItem(player, PickaxeGUI, ForgeItems.Orichalchite_Pickaxe, Ores.Orichalchite, 16);
        //GuiUtils.SetupItem_2(player, PickaxeGUI, ForgeItems.Obsidian_Pickaxe, Ores.Refined_Gemstone, 15, Ores.Orichalchite, 16);

        GuiUtils.SetupItem_2(player, PickaxeGUI, ForgeItems.Nacrine_Pickaxe, Resources.Nacrine, 500, ShopItems.Tier_1_Handle, 2);

        GuiUtils.SetupItem_2(player, PickaxeGUI, ForgeItems.Zaplium_Pickaxe, Resources.Zaplium, 400, ShopItems.Tier_1_Handle, 2);

        PickaxeGUI.setItem(
                49,
                GuiUtils.menuClose());


        PickaxeGUI.setItem(
                48,
                GuiUtils.menuReturn());




        return PickaxeGUI;
    }
}