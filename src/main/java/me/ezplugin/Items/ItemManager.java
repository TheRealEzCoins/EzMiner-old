package me.ezplugin.Items;

import lombok.Getter;
import me.ezplugin.EzMiner;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

public class ItemManager {

    public static ItemStack Orichalchite;

    public static ItemStack Gemstone;
    public static ItemStack OrichalchitePickaxe;
    public static ItemStack ObsidianPickaxe;
    public static ItemCreator CustomItem;



    public static void init() {
        Orichalchite();
        Gemstone();
        OrichalchitePickaxe();
        ObsidianPickaxe();
        TestPickaxe();

    }


    private static void Orichalchite() {
        ItemStack orichItem = new ItemStack(Material.CYAN_DYE);
        ItemMeta orich = orichItem.getItemMeta();
        PersistentDataContainer data = orich.getPersistentDataContainer();
        data.set(new NamespacedKey(EzMiner.getPlugin(), "Ore"), PersistentDataType.STRING, orich.getDisplayName());
        orich.setDisplayName("§9Orichalchite");
        orichItem.setItemMeta(orich);
        Orichalchite = orichItem;
    }

    private static void Gemstone() {
        ItemStack GemstoneItem = new ItemStack(Material.REDSTONE);
        ItemMeta GemstoneMeta = GemstoneItem.getItemMeta();
        GemstoneMeta.setDisplayName("§bGemstone");
        GemstoneItem.setItemMeta(GemstoneMeta);
        Gemstone = GemstoneItem;

    }



    private static void OrichalchitePickaxe() {
        ItemStack orichPickaxeItem = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta orichPickaxe = orichPickaxeItem.getItemMeta();
        PersistentDataContainer data = orichPickaxe.getPersistentDataContainer();
        data.set(new NamespacedKey(EzMiner.getPlugin(), "Tier"), PersistentDataType.INTEGER, 1);
        orichPickaxe.setDisplayName("§9Orichalchite Pickaxe");
        orichPickaxe.setUnbreakable(true);
        orichPickaxeItem.setItemMeta(orichPickaxe);
        OrichalchitePickaxe = orichPickaxeItem;
    }

    private static void ObsidianPickaxe() {
        ItemStack Obsidianpickaxe = new ItemStack(Material.GOLDEN_PICKAXE, 1);
        ItemMeta itemMeta = Obsidianpickaxe.getItemMeta();
        PersistentDataContainer data = itemMeta.getPersistentDataContainer();
        data.set(new NamespacedKey(EzMiner.getPlugin(), "Tier"), PersistentDataType.INTEGER, 2);
        data.set(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER, 1000);
        int CurrentFuel = data.get(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER);
        int CurrentTier = data.get(new NamespacedKey(EzMiner.getPlugin(), "Tier"), PersistentDataType.INTEGER);

        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§fFuel: " + "§b" + CurrentFuel);
        lore.add("");
        lore.add("§8Tier: " + "§b" + CurrentTier);
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§8Obsidian Pickaxe");
        itemMeta.setUnbreakable(true);
        Obsidianpickaxe.setItemMeta(itemMeta);
        ObsidianPickaxe = Obsidianpickaxe;
    }


    private static void TestPickaxe() {
        ItemCreator TestPickaxe = new ItemCreator(Material.DAMAGED_ANVIL);

        TestPickaxe.setName("Test Pickaxe");

        TestPickaxe.setFuel(1000);
        TestPickaxe.setTier(3);
        TestPickaxe.RegisterLore();

        TestPickaxe.setUnbreakable(true);
        CustomItem = TestPickaxe;
    }




}