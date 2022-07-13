package me.ezplugin.GUI.GUIS;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Resources;
import me.ezplugin.Items.Items.PickaxeItems;
import me.ezplugin.Utils.Files.StatUtils;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.text.ParseException;

public class CheatGUI {
    public static Inventory CheatGUI() {

        Inventory CheatGUI = Bukkit.createInventory(null, 54, "§cCheatGUI");
        GuiUtils.fillBorder(CheatGUI);


        for(ForgeItems items : ForgeItems.values()) {
            CheatGUI.setItem(CheatGUI.firstEmpty(), ItemUtils.customItemUsingStack(
                    items.getOuput().getItemStack(),
                    items.getOuput().getName()
            ));
        }



        CheatGUI.setItem(
                49,
                GuiUtils.menuClose());


        CheatGUI.setItem(
                48,
                GuiUtils.menuReturn());




        return CheatGUI;
    }
}
