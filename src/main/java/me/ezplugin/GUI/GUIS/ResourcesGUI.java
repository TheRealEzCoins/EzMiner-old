package me.ezplugin.GUI.GUIS;

import dev.dbassett.skullcreator.SkullCreator;
import me.ezplugin.Enums.Heads;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ItemUtils;
import me.ezplugin.Utils.ResourceSetup;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ResourcesGUI extends GuiUtils {


    public static Inventory ResourcesGUI(Player player) {

        Inventory ResourcesGUI = Bukkit.createInventory(null, 54, "§8Resources");
        GuiUtils.fillResources(ResourcesGUI);

        ResourceSetup.ResourceCreation(player, ResourcesGUI);


        ResourcesGUI.setItem(12,
                ItemUtils.customItemName(Material.LIME_STAINED_GLASS_PANE, ""));



        ResourcesGUI.setItem(
                49,
                GuiUtils.menuClose());
        ResourcesGUI.setItem(
                48,
                GuiUtils.menuReturn());



        return ResourcesGUI;
    }

}
