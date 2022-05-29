package me.ezplugin.GUI.GUIS;

import me.ezplugin.EzMiner;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.ezplugin.Utils.ItemUtils.customItemName;

public class StatsGUI {

    private static final ItemStack blackglass = customItemName(Material.BLACK_STAINED_GLASS_PANE, " ");

    private static final int[] black_border = new int[] {
            0, 1, 2, 3, 4, 5, 6, 7, 8,
            9, /* --------------- */ 17,
            18, 19, 20, 21, 22, 23, 24, 25, 26
             };


    public static Inventory StatsGUI(Player player) {

        Inventory StatsGUI = Bukkit.createInventory(null, 27, "Stats");

        StatsGUI.setItem(10, GuiUtils.getStatsAsSkull(player));

        if (EzMiner.isEzForagingInstalled()) {
            StatsGUI.setItem(11, ItemUtils.customItemName(
                    Material.DIAMOND_AXE,
                    "e",
                    ""
            ));
        }

        for(int slot : black_border){
            StatsGUI.setItem(slot, blackglass);
        }


        return StatsGUI;
    }
}

