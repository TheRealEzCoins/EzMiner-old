package me.ezplugin.GUI.GUIS;

import me.ezplugin.EzMiner;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.logging.Level;

import static me.ezplugin.Utils.Utils.*;
import static me.ezplugin.Utils.Utils.customItemName;

public class PickaxeGUI {

    private static final ItemStack blackglass = customItemName(Material.BLACK_STAINED_GLASS_PANE, " ");

    private static final int[] black_border = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            17, 18, 26, 27, 35, 36, 44, 46, 47, 50,
            51, 52, 53};

    public static Inventory PickaxeGUI(Player player) {

        Inventory PickaxeGUI = Bukkit.createInventory(null, 54, "Pickaxe Forge");


        Integer xp = (player.getPersistentDataContainer().get(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER));
        Integer Level = (player.getPersistentDataContainer().get(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER));
        int xpLeft = (Level * 500 - xp);

        if(Level >= 1) {
            PickaxeGUI.setItem(
                    10,
                    GuiUtils.createCustomItem(ItemManager.Orichalchite_Pickaxe, ItemManager.Orichalchite, 16, "30s"));

            PickaxeGUI.setItem(
                    45,
                    GuiUtils.getStatsAsSkull(player));

            PickaxeGUI.setItem(
                    11,
                    GuiUtils.unlockable(5));

            PickaxeGUI.setItem(
                    49,
                    GuiUtils.menuClose());


            PickaxeGUI.setItem(
                    48,
                    GuiUtils.menuReturn());
        }


        if(Level >= 5) {
            PickaxeGUI.setItem(
                    11,
                    GuiUtils.createItem(ItemManager.Obsidian_Pickaxe, Material.OBSIDIAN, 16, "30s"));

        }



        for(int slot : black_border){
            PickaxeGUI.setItem(slot, blackglass);
        }

        return PickaxeGUI;
    }
}