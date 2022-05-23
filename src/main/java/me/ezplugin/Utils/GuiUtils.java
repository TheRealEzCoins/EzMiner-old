package me.ezplugin.Utils;

import me.ezplugin.Items.ItemCreator;
import me.ezplugin.Items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Locale;

import static me.ezplugin.Utils.Utils.customItemName;

public class GuiUtils {

    public static ItemStack getStatsAsSkull(Player player ) {
        int getLevel = Utils.getCurrentStats(player, "LEVEL");
        int getXP = Utils.getCurrentStats(player, "XP");
        int xpLeft = (getLevel * 500 - getXP);
        return Utils.customItemUsingStack(
                Utils.getPlayerSkull(player),
                "",
                "§7Current Level: §9" + getLevel,
                "§7Current xp: §9" + getXP + " §7/ §9" + (getLevel * 500),
                "§7Xp to next level: §9" + xpLeft);
    }

    public static ItemStack unlockable(int Level) {
      return customItemName(
              Material.BARRIER,
              "§7Locked!",
              "", "§8Unlocks at Level " + Level);
    }

    public static ItemStack menuClose() {
        return customItemName(
                Material.BARRIER,
                "§cClose",
                "",
                "§8Closes the menu.");
    }

    public static ItemStack menuReturn() {
        return customItemName(
                Material.ARROW,
                "§bGo Back!",
                "",
                "§8Goes back to the selection menu!.");
    }

    public static ItemStack createCustomItem(ItemCreator itemCreator, ItemCreator material, int amount, String time) {
        return customItemName(
                itemCreator.getType(),
                itemCreator.getName(),
                "",
                "§eItems required",
                ChatColor.GRAY + material.getName().toLowerCase(Locale.ROOT).substring(0, 1).toUpperCase(Locale.ROOT) + material.getName().substring(1) + " §7x" + amount,
                "",
                "§8Duration: §b" + time);
    }

    public static ItemStack createItem(ItemCreator itemCreator, Material material, int amount, String time) {
        return customItemName(
                itemCreator.getType(),
                itemCreator.getName(),
                "",
                "§eItems required",
                ChatColor.GRAY + material.name().toLowerCase(Locale.ROOT).substring(0, 1).toUpperCase(Locale.ROOT) + material.name().substring(1).toLowerCase(Locale.ROOT) + " §7x" + amount,
                "",
                "§8Duration: §b" + time);
    }
}
