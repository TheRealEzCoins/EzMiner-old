package me.ezplugin.GUI.GUIS;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Utils.Files.StatUtils;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ItemUtils;
import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.ezplugin.Utils.ItemUtils.customItemName;

public class ForgeGUI extends GuiUtils {

    private static final ItemStack furnace = customItemName(Material.FURNACE, "§aForge Items");
    private static final ItemStack red_glass = customItemName(Material.RED_STAINED_GLASS_PANE, " ");

    private static final int[] furnaces = new int[] {
            11, 12, 13, 14, 15 };

    private static final int[] red_border = new int[] {
            20, 21, 22, 23, 24
    };


    public static Inventory FORGEGUI(Player player) {

        Inventory FORGEGUI = Bukkit.createInventory(null, 54, "§8Forge");

        GuiUtils.fillEmpty(FORGEGUI);


        FORGEGUI.setItem(39,
                customItemName(
                        Material.ENDER_CHEST,
                        "§aResources"));

        FORGEGUI.setItem(
                40,
                GuiUtils.getStatsAsSkull(player));


        if(StatUtils.newHasTimer(1, player, StatUtils.getItemInSlot(1, player))) {
            FORGEGUI.setItem(11, customItemName(Material.BARRIER, "Test"));
        }

        for(int slot : furnaces){
            FORGEGUI.setItem(slot, furnace);
        }

        for(int slot : red_border){
            FORGEGUI.setItem(slot, red_glass);
        }

        return FORGEGUI;
    }
}
