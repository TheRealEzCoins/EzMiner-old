package me.ezplugin.GUI.GUIS;

import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.ezplugin.Utils.Utils.*;

public class ForgeGUI {

    private static final ItemStack blackglass = customItemName(Material.BLACK_STAINED_GLASS_PANE, " ");
    private static final ItemStack red_glass = customItemName(Material.RED_STAINED_GLASS_PANE, " ");

    private static final int[] black_border = new int[] {
            9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23,
            24, 25, 26, 27, 28, 29, 30, 31,
            32, 33, 34, 35, 36, 37, 38, 39,
             41, 42, 43, 44, 45, 46, 47,
            48, 49, 50, 51, 52, 53 };

    private static final int[] red_border = new int[] {
            0, 1, 2, 3, 4, 5, 6, 7, 8,
            9, /* --------------- */ 17,
            18, /* --------------- */ 26,
            27, /* --------------- */ 35,
            36, /* --------------- */ 44,
            45, 46, 47, 48, 49, 50, 51, 52, 53
    };


    public static Inventory FORGEGUI(Player player) {

        int Level = Utils.getCurrentStats(player, "LEVEL");
        int exp = Utils.getCurrentStats(player, "XP");
        Inventory FORGEGUI = Bukkit.createInventory(null, 54, "Forge");

        FORGEGUI.setItem(20,
                Utils.customItemName(
                        Material.LAVA_BUCKET,
                        "§bForge items here."));

        FORGEGUI.setItem(40,
                Utils.customItemName(
                        Material.LAVA_BUCKET,
                        "§bForge items here."));

        FORGEGUI.setItem(
                40,
                GuiUtils.getStatsAsSkull(player));

        for(int slot : black_border){
            FORGEGUI.setItem(slot, blackglass);
        }

        for(int slot : red_border){
            FORGEGUI.setItem(slot, red_glass);
        }

        return FORGEGUI;
    }
}
