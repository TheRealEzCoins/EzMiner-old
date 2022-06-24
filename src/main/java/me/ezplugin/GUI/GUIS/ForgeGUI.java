package me.ezplugin.GUI.GUIS;

import dev.dbassett.skullcreator.SkullCreator;
import me.ezplugin.Enums.Heads;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ItemUtils;
import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.ezplugin.Utils.ItemUtils.customItemName;
import static me.ezplugin.Utils.ItemUtils.customItemUsingStack;

public class ForgeGUI extends GuiUtils {




    public static Inventory FORGEGUI(Player player) {

        Inventory FORGEGUI = Bukkit.createInventory(null, 54, "§8Forge");

        GuiUtils.fillEmpty(FORGEGUI);

        FORGEGUI.setItem(20, customItemName(Material.DIAMOND, "§aRefining", "", "§eYou can refine ore here."));
        FORGEGUI.setItem(22, customItemName(Material.ENCHANTED_BOOK, "§aUpgrades", "", "§eYou can forge upgrades here."));
        FORGEGUI.setItem(24, customItemName(Material.DIAMOND_PICKAXE, "§aPickaxes", "" ,"§eYou can make pickaxes here."));


        FORGEGUI.setItem(39,
                customItemName(
                        Material.ENDER_CHEST,
                        "§aResources"));

        FORGEGUI.setItem(
                40,
                GuiUtils.getStatsAsSkull(player));

        FORGEGUI.setItem(41, customItemUsingStack(SkullCreator.itemFromUrl(Heads.Shop.getURL()), "§6Shop"));



        return FORGEGUI;
    }
}
