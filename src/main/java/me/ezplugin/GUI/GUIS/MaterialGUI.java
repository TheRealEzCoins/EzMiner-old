package me.ezplugin.GUI.GUIS;

import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ItemUtils;
import me.ezplugin.Utils.ResourceSetup;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MaterialGUI {
    public static Inventory MaterialGUI(Player player) {

        Inventory MaterialGUI = Bukkit.createInventory(null, 54, "§8Materials");
        GuiUtils.fillResources(MaterialGUI);

        ResourceSetup.MaterialCreation(player, MaterialGUI);


        MaterialGUI.setItem(14,
                ItemUtils.customItemName(Material.LIME_STAINED_GLASS_PANE, ""));



        MaterialGUI.setItem(
                49,
                GuiUtils.menuClose());
        MaterialGUI.setItem(
                48,
                GuiUtils.menuReturn());



        return MaterialGUI;
    }
}
