package me.ezplugin.GUI.GUIS;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Resources;
import me.ezplugin.Utils.Files.StatUtils;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.text.ParseException;

public class UpgradeGUI {
    public static Inventory UpgradeGUI(Player player) throws ParseException {

        Inventory UpgradeGUI = Bukkit.createInventory(null, 54, "§8Upgrades");
        GuiUtils.fillBorder(UpgradeGUI);

        if(StatUtils.hasTimer(player, ForgeItems.FortuneUpgrade)) {
            UpgradeGUI.setItem(10, GuiUtils.Crafting(ForgeItems.FortuneUpgrade, player));
            player.updateInventory();
        } else {
            GuiUtils.SetupItem(player, UpgradeGUI, ForgeItems.FortuneUpgrade, Resources.Perfect_Gemstone, 2);
            player.updateInventory();
        }



        UpgradeGUI.setItem(
                49,
                GuiUtils.menuClose());


        UpgradeGUI.setItem(
                48,
                GuiUtils.menuReturn());


        return UpgradeGUI;



    }

    public static ChestGui item() {

        ChestGui gui = new ChestGui(6, "§8Upgrades");

        OutlinePane pane = new OutlinePane(0, 0, 9, 5);

        GuiItem guiItem = new GuiItem(ItemUtils.customItemName(Material.STICK, "Euhf"));

        pane.addItem(guiItem);

        gui.addPane(pane);


        return gui;
    }





}
