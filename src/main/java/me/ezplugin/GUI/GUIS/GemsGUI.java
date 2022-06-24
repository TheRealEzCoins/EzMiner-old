package me.ezplugin.GUI.GUIS;

import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ItemUtils;
import me.ezplugin.Utils.ResourceSetup;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GemsGUI {
    public static Inventory GemGUI(Player player) {
        Inventory GemGUI = Bukkit.createInventory(null, 54, "§bGems");
        GuiUtils.fillResources(GemGUI);
        ResourceSetup.GemCreation(player, GemGUI);

        GemGUI.setItem(
                49,
                GuiUtils.menuClose());
        GemGUI.setItem(
                48,
                GuiUtils.menuReturn());

        GemGUI.setItem(13,
                ItemUtils.customItemName(Material.LIME_STAINED_GLASS_PANE, ""));


        return GemGUI;
    }
}
