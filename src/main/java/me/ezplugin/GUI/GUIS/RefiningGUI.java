package me.ezplugin.GUI.GUIS;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Resources;
import me.ezplugin.Utils.Files.StatUtils;
import me.ezplugin.Utils.GuiUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.text.ParseException;

public class RefiningGUI extends GuiUtils {



    public static Inventory RefiningGUI(Player player) throws ParseException {

        Inventory RefiningGUI = Bukkit.createInventory(null, 54, "§8Refining");
        GuiUtils.fillBorder(RefiningGUI);


        if(StatUtils.hasTimer(player, ForgeItems.Refined_Gem)) {
            RefiningGUI.setItem(10, GuiUtils.Crafting(ForgeItems.Refined_Gem, player));
            player.updateInventory();
        } else {
            GuiUtils.SetupItem(player, RefiningGUI, ForgeItems.Refined_Gem, Resources.Gemstone, 128);
            player.updateInventory();
        }

        if(StatUtils.hasTimer(player, ForgeItems.Polished_Gem)) {
            RefiningGUI.setItem(11, GuiUtils.Crafting(ForgeItems.Polished_Gem, player));
            player.updateInventory();
        } else {
            GuiUtils.SetupItem(player, RefiningGUI, ForgeItems.Polished_Gem, Resources.Refined_Gemstone, 128);
            player.updateInventory();
        }

        if(StatUtils.hasTimer(player, ForgeItems.Perfect_Gem)) {
            RefiningGUI.setItem(11, GuiUtils.Crafting(ForgeItems.Perfect_Gem, player));
            player.updateInventory();
        } else {
            GuiUtils.SetupItem(player, RefiningGUI, ForgeItems.Perfect_Gem, Resources.Polished_Gemstone, 128);
            player.updateInventory();
        }



            RefiningGUI.setItem(
                    49,
                    GuiUtils.menuClose());


            RefiningGUI.setItem(
                    48,
                    GuiUtils.menuReturn());




        return RefiningGUI;
    }
}