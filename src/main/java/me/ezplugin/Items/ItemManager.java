package me.ezplugin.Items;

import dev.dbassett.skullcreator.SkullCreator;
import me.ezplugin.Enums.Heads;
import me.ezplugin.Enums.Rarity;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class ItemManager {

    public static void init() {
        ItemSetup();

    }

    public static ItemCreator Orichalchite;
    public static ItemCreator Gemstone;
    public static ItemCreator Refined_Gemstone;
    public static ItemCreator Polished_Gemstone;
    public static ItemCreator Perfect_Gemstone;
    public static ItemCreator Orichalchite_Pickaxe;
    public static ItemCreator Obsidian_Pickaxe;
    public static ItemCreator OIL_BARREL;
    public static ItemCreator GEMSTONE_POT;


    private static void ItemSetup() {
        Orichalchite_Pickaxe = new ItemCreator(Material.WOODEN_PICKAXE)
                .setName("§9Orichalchite Pickaxe")
                .setPickaxe()
                .setTier(1)
                .addEnchantment(Enchantment.DIG_SPEED, 1)
                .addFortune(150)
                .getFortune()
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Obsidian_Pickaxe = new ItemCreator(Material.DIAMOND_PICKAXE)
                .setName("§8Obsidian Pickaxe")
                .setPickaxe()
                .setTier(2)
                .getFortune()
                .setFuel(1000)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Orichalchite = new ItemCreator(Material.CYAN_DYE)
                .setName("§9Orichalchite Ore")
                .setRarity(Rarity.COMMON, "ORE")
                .setOre();
        // -------------------------------------------- //
        Gemstone = new ItemCreator(SkullCreator.itemFromUrl(Heads.Gemstone.getURL()))
                .setName("§bGemstone")
                .setOre()
                .setUnplacable(true)
                .setRarity(Rarity.UNCOMMON, "GEMSTONE");
        // -------------------------------------------- //
        Refined_Gemstone = new ItemCreator(SkullCreator.itemFromUrl(Heads.Refined_Gemstone.getURL()))
                .setName("§bRefined Gemstone")
                .setOre()
                .setUnplacable(true)
                .setRarity(Rarity.RARE, "GEMSTONE");
        // -------------------------------------------- //
        Polished_Gemstone = new ItemCreator(SkullCreator.itemFromUrl(Heads.Polished_Gemstone.getURL()))
                .setName("§bPolished Gemstone")
                .setOre()
                .setUnplacable(true)
                .setRarity(Rarity.EPIC, "GEMSTONE");
        // -------------------------------------------- //
        Perfect_Gemstone = new ItemCreator(SkullCreator.itemFromUrl(Heads.Perfect_Gemstone.getURL()))
                .setName("§bPerfect Gemstone")
                .setOre()
                .setUnplacable(true)
                .setRarity(Rarity.LEGENDARY, "GEMSTONE");
        // -------------------------------------------- //
        OIL_BARREL = new ItemCreator(Material.LAVA_BUCKET)
                .setName("§2Oil Bucket")
                .setUnplacable(true)
                .HideItemFlags()
                .setAsFuel(1000)
                .setRarity(Rarity.UNCOMMON, "FUEL");
        // -------------------------------------------- //
        GEMSTONE_POT = new ItemCreator(SkullCreator.itemFromUrl(Heads.Gemstone_Pot.getURL()))
                .setName("§bGemstones");

    }







}