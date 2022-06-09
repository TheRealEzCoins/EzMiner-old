package me.ezplugin.GUI.GUIS;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ResourceSetup;
import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.ezplugin.Utils.Utils.getLevel;

public class ResourcesGUI extends GuiUtils {


    public static Inventory ResourcesGUI(Player player) {

        Inventory ResourcesGUI = Bukkit.createInventory(null, 54, "§8Resources");
        GuiUtils.fillBorder(ResourcesGUI);

        ResourceSetup.ResourceCreation(player, ResourcesGUI);


        ResourcesGUI.setItem(
                49,
                GuiUtils.menuClose());


        ResourcesGUI.setItem(
                48,
                GuiUtils.menuReturn());

        return ResourcesGUI;
    }
}
