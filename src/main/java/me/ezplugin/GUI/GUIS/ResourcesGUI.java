package me.ezplugin.GUI.GUIS;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ResourcesGUI extends GuiUtils {


    public static Inventory ResourcesGUI(Player player) {

        Inventory ResourcesGUI = Bukkit.createInventory(null, 54, "Resources");
        GuiUtils.fillBorder(ResourcesGUI);


        if(getLevel(player) >= 1) {
            ResourcesGUI.setItem(
                    10,
                    GuiUtils.ResourceCreation(Ores.Orichalchite, player));

            ResourcesGUI.setItem(
                    11,
                    GuiUtils.ResourceCreation(Ores.Gemstone_1, player)
            );

            ResourcesGUI.setItem(
                    49,
                    GuiUtils.menuClose());


            ResourcesGUI.setItem(
                    48,
                    GuiUtils.menuReturn());
        }

        return ResourcesGUI;
    }
}
