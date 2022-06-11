package me.ezplugin.GUI.GUIS;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.Utils.GuiUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class RefiningGUI extends GuiUtils {


    public static Inventory RefiningGUI(Player player) {

        Inventory RefiningGUI = Bukkit.createInventory(null, 54, "§8Refining");
        GuiUtils.fillBorder(RefiningGUI);

        GuiUtils.SetupItem(player, RefiningGUI, ForgeItems.Refined_Gem, Ores.Gemstone);
        GuiUtils.SetupItem(player, RefiningGUI, ForgeItems.Polished_Gem, Ores.Refined_Gemstone);
        GuiUtils.SetupItem(player, RefiningGUI, ForgeItems.Perfect_Gem, Ores.Polished_Gemstone);

            RefiningGUI.setItem(
                    49,
                    GuiUtils.menuClose());


            RefiningGUI.setItem(
                    48,
                    GuiUtils.menuReturn());




        return RefiningGUI;
    }
}