package me.ezplugin.GUI.GUIS;

import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ResourceSetup;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GemsGUI {
    public static Inventory GemGUI(Player player) {
        Inventory GemGUI = Bukkit.createInventory(null, 54, "§bGems");
        GuiUtils.fillBorder(GemGUI);
        ResourceSetup.GemCreation(player, GemGUI);

        GemGUI.setItem(
                18,
                GuiUtils.menuReturn());

        return GemGUI;
    }
}
