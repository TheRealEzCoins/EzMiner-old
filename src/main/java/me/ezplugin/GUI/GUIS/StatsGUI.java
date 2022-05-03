package me.ezplugin.GUI.GUIS;

import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.ezplugin.Utils.Utils.altcolor;
import static me.ezplugin.Utils.Utils.customItemName;

public class StatsGUI {

    private static final String PickName1 = altcolor("&9Orichalchite Pickaxe");
    private static final ItemStack blackglass = customItemName(Material.BLACK_STAINED_GLASS_PANE, " ");

    private static final int[] black_border = {
            0,  1,  2,  3,  4,  5,  6,  7,  8,
            9,  /*i*/                       17,
            18, /*i*/                       26,
            27, /*i*/                       35,
            36, /*i*/                       44,
            /*Back*/ 46, 47, 48 /*Close*/, 50, 51, 52, 53};

    public static Inventory StatsGUI(Player player) {

        Inventory PickaxeGUI = Bukkit.createInventory(null, 54, "Stats");


        PickaxeGUI.setItem(20, customItemName(Material.PLAYER_HEAD, PickName1, String.valueOf(Utils.getCurrentStats(player, "LEVEL"))));


        for(int slot : black_border){
            PickaxeGUI.setItem(slot, blackglass);
        }

        return PickaxeGUI;
    }
}