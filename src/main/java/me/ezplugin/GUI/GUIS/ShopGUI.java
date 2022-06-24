package me.ezplugin.GUI.GUIS;

import me.ezplugin.Enums.ShopItems;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ResourceSetup;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class ShopGUI extends GuiUtils {
    public static Inventory ShopGUI(Player player) {
        Inventory ShopGUI = Bukkit.createInventory(null, 54, "§8Shop");

        GuiUtils.fillBorder(ShopGUI);

        for(ShopItems items : ShopItems.values()) {
            ShopGUI.setItem(ShopGUI.firstEmpty(), GuiUtils.getItemAsShop(items));
        }

        ShopGUI.setItem(
                49,
                GuiUtils.menuClose());


        ShopGUI.setItem(
                48,
                GuiUtils.menuReturn());


        return ShopGUI;
    }
}
