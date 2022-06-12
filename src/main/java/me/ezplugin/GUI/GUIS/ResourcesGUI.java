package me.ezplugin.GUI.GUIS;

import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ItemUtils;
import me.ezplugin.Utils.ResourceSetup;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

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

        ResourcesGUI.setItem(
                45,
                ItemUtils.customItemUsingStack(ItemManager.GEMSTONE_POT.getItemStack(), "§bGemstone Pot")

        );

        return ResourcesGUI;
    }

}
