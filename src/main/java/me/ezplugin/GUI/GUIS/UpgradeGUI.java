package me.ezplugin.GUI.GUIS;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.Utils.GuiUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class UpgradeGUI extends GuiUtils {
    public static Inventory UpgradeGUI(Player player) {

        Inventory UpgradeGUI = Bukkit.createInventory(null, 54, "§8Upgrades");
        GuiUtils.fillBorder(UpgradeGUI);

        GuiUtils.SetupItem(player, UpgradeGUI, ForgeItems.FortuneUpgrade, Ores.Perfect_Gemstone);



        UpgradeGUI.setItem(
                49,
                GuiUtils.menuClose());


        UpgradeGUI.setItem(
                48,
                GuiUtils.menuReturn());


        return UpgradeGUI;
    }

}
