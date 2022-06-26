package me.ezplugin.GUI.GUIS;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Resources;
import me.ezplugin.Enums.ShopItems;
import me.ezplugin.Utils.Files.StatUtils;
import me.ezplugin.Utils.GuiUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.text.ParseException;


public class PickaxeGUI extends GuiUtils {

    public static Inventory PickaxeGUI(Player player) throws ParseException {

        Inventory PickaxeGUI = Bukkit.createInventory(null, 54, "§8Pickaxe Forge");
        GuiUtils.fillBorder(PickaxeGUI);


        GuiUtils.setupItemWithTime(player, PickaxeGUI, ForgeItems.Nacrine_Pickaxe, Resources.Nacrine, 400, ShopItems.Tier_1_Handle, 1);
        GuiUtils.setupItemWithTime(player, PickaxeGUI, ForgeItems.Uprum_Pickaxe, Resources.Uprum, 250, ShopItems.Tier_1_Handle, 1);
        GuiUtils.setupItemWithTime(player, PickaxeGUI, ForgeItems.Zaplium_Pickaxe, Resources.Zaplium, 400, ShopItems.Tier_2_Handle, 1);
        GuiUtils.setupItemWithTime(player, PickaxeGUI, ForgeItems.Slaginite_Pickaxe, Resources.Slaginite, 500, ShopItems.Tier_3_Handle, 1);
        GuiUtils.setupItemWithTime(player, PickaxeGUI, ForgeItems.Gryrium_Pickaxe, Resources.Gryrium, 600, ShopItems.Tier_3_Handle, 1);
        GuiUtils.setupItemWithTime(player, PickaxeGUI, ForgeItems.Kreisium_Pickaxe, Resources.Kreisium, 750, ShopItems.Tier_4_Handle, 1);
        GuiUtils.setupItemWithTime(player, PickaxeGUI, ForgeItems.Volcanium_Pickaxe, Resources.Volcanium, 350, ShopItems.Tier_4_Handle, 2);




        PickaxeGUI.setItem(
                49,
                GuiUtils.menuClose());


        PickaxeGUI.setItem(
                48,
                GuiUtils.menuReturn());




        return PickaxeGUI;
    }
}