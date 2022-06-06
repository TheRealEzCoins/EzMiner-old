package me.ezplugin.GUI.GUIS;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.EzMiner;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class RefiningGUI extends GuiUtils {


    public static Inventory RefiningGUI(Player player) {

        Inventory RefiningGUI = Bukkit.createInventory(null, 54, "§8Refining");
        GuiUtils.fillBorder(RefiningGUI);


        if(getLevel(player) >= 1) {
            RefiningGUI.setItem(
                    10,
                    GuiUtils.createItem(ItemManager.Refined_Gemstone_1, Ores.Gemstone_1, ForgeItems.Gemstone_2));

            RefiningGUI.setItem(
                    49,
                    GuiUtils.menuClose());


            RefiningGUI.setItem(
                    48,
                    GuiUtils.menuReturn());
        }




        return RefiningGUI;
    }
}