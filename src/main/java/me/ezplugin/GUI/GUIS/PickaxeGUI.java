package me.ezplugin.GUI.GUIS;

import me.ezplugin.EzMiner;
import me.ezplugin.Items.ItemManager;
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
                    customItemName(
                            Material.DIAMOND_PICKAXE,
                            "§9Orichalchite Pickaxe",
                            "",
                            "§eItems required",
                            "§9Orichalchite §7x16",
                            "",
                            "§8Duration: §b30s"));

            PickaxeGUI.setItem(
                    45,
                    customItemName(
                            Material.PAPER,
                            ChatColor.GOLD +
                                    player.getName() + "'s stats",
                            "",
                            "§eCurrent Level: " + (player.getPersistentDataContainer().get(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER)),
                            "§eCurrent xp: " + xp + " §e/ " + (Level * 500),
                            "§exp to next level: " + xpLeft));

            PickaxeGUI.setItem(
                    11,
                    customItemName(
                            Material.BARRIER,
                            "§7Locked!",
                            "", "§8Unlocks at Level 5"));

            PickaxeGUI.setItem(
                    49,
                    customItemName(
                            Material.BARRIER,
                            "§cClose",
                            "",
                            "§8Closes the menu."));


            PickaxeGUI.setItem(
                    48,
                    customItemName(
                            Material.ARROW,
                            "§bGo Back!",
                            "",
                            "§8Goes back to the selection menu!."));
        }


        if(Level >= 5) {
            PickaxeGUI.setItem(
                    11,
                    customItemName(
                            Material.GOLDEN_PICKAXE,
                            "§8Obsidian Pickaxe",
                            "",
                            "§eItems required",
                            "§8Obsidian §7x16",
                            "",
                            "§8Duration: §b30s"));

        }



        for(int slot : black_border){
            PickaxeGUI.setItem(slot, blackglass);
        }

        return PickaxeGUI;
    }
}