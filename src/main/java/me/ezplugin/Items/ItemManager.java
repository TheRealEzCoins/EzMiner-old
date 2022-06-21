package me.ezplugin.Items;

import dev.dbassett.skullcreator.SkullCreator;
import me.ezplugin.Enums.Heads;
import me.ezplugin.Enums.Rarity;
import me.ezplugin.Enums.Type;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;

public class ItemManager {

    public static void init() {
        ItemSetup();

    }

    public static ItemCreator Gemstone;
    public static ItemCreator Refined_Gemstone;
    public static ItemCreator Polished_Gemstone;
    public static ItemCreator Perfect_Gemstone;
    public static ItemCreator Orichalchite_Pickaxe;
    public static ItemCreator Obsidian_Pickaxe;
    public static ItemCreator OIL_BARREL;
    public static ItemCreator GEMSTONE_POT;
    public static ItemCreator FortuneUpgrade;
    public static ItemCreator Zaplium;
    public static ItemCreator Slaginite;
    public static ItemCreator Gryrium;
    public static ItemCreator Kreisium;
    public static ItemCreator Volcanium;
    public static ItemCreator Nacrine;
    public static ItemCreator Flotine;


    private static void ItemSetup() {
        Orichalchite_Pickaxe = new ItemCreator(Material.WOODEN_PICKAXE)
                .setName("§9Orichalchite Pickaxe")
                .setPickaxe()
                .setTier(1)
                .addEnchantment(Enchantment.DIG_SPEED, 1)
                .setFortune(0)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Obsidian_Pickaxe = new ItemCreator(Material.DIAMOND_PICKAXE)
                .setName("§8Obsidian Pickaxe")
                .setPickaxe()
                .setTier(2)
                .setFortune(0)
                .setFuel(1000)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Nacrine = new ItemCreator(Material.BLACK_DYE)
                .setName("§8Nacrine Ore")
                .setRarity(Rarity.COMMON, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Zaplium = new ItemCreator(Material.YELLOW_DYE)
                .setName("§eZaplium Ore")
                .setRarity(Rarity.UNCOMMON, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Slaginite = new ItemCreator(Material.WHITE_DYE)
                .setName("§fSlaginite Ore")
                .setRarity(Rarity.RARE, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Gryrium = new ItemCreator(Material.GRAY_DYE)
                .setName("§7Gryrium Ore")
                .setRarity(Rarity.RARE, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Kreisium = new ItemCreator(Material.RED_DYE)
                .setName("§cKreisium Ore")
                .setRarity(Rarity.EPIC, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Volcanium = new ItemCreator(Material.ORANGE_DYE)
                .setName("§6Volcanium Ore")
                .setRarity(Rarity.EPIC, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Flotine = new ItemCreator(Material.LIME_DYE)
                .setName("§aFlotine Ore")
                .setRarity(Rarity.LEGENDARY, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Gemstone = new ItemCreator(SkullCreator.itemFromUrl(Heads.Gemstone.getURL()))
                .setName("§bGemstone")
                .setOre()
                .setUnplacable(true)
                .setRarity(Rarity.UNCOMMON, Type.GEM);
        // -------------------------------------------- //
        Refined_Gemstone = new ItemCreator(SkullCreator.itemFromUrl(Heads.Refined_Gemstone.getURL()))
                .setName("§bRefined Gemstone")
                .setOre()
                .setUnplacable(true)
                .setRarity(Rarity.RARE, Type.GEM);
        // -------------------------------------------- //
        Polished_Gemstone = new ItemCreator(SkullCreator.itemFromUrl(Heads.Polished_Gemstone.getURL()))
                .setName("§bPolished Gemstone")
                .setOre()
                .setUnplacable(true)
                .setRarity(Rarity.EPIC, Type.GEM);
        // -------------------------------------------- //
        Perfect_Gemstone = new ItemCreator(SkullCreator.itemFromUrl(Heads.Perfect_Gemstone.getURL()))
                .setName("§bPerfect Gemstone")
                .setOre()
                .setUnplacable(true)
                .setRarity(Rarity.LEGENDARY, Type.GEM);
        // -------------------------------------------- //
        OIL_BARREL = new ItemCreator(Material.LAVA_BUCKET)
                .setName("§2Oil Bucket")
                .setUnplacable(true)
                .HideItemFlags()
                .setAsFuel(1000)
                .setRarity(Rarity.UNCOMMON, Type.FUEL);
        // -------------------------------------------- //
        GEMSTONE_POT = new ItemCreator(SkullCreator.itemFromUrl(Heads.Gemstone_Pot.getURL()))
                .setName("§bGemstones");
        // -------------------------------------------- //
        FortuneUpgrade = new ItemCreator(SkullCreator.itemFromUrl(Heads.Fortune.getURL()))
                .setName("§eFortune Boost")
                .addLore("")
                .addLore("§6Gives your pickaxe a 10☘ Fortune boost!")
                .setRarity(Rarity.RARE, Type.UPGRADES);
    }







}