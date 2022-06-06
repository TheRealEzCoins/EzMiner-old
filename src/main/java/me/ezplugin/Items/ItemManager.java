package me.ezplugin.Items;

import me.ezplugin.Enums.Rarity;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class ItemManager {

    public static void init() {
        ItemSetup();

    }

    public static ItemCreator Orichalchite;
    public static ItemCreator Gemstone;
    public static ItemCreator Refined_Gemstone_1;
    public static ItemCreator Orichalchite_Pickaxe;
    public static ItemCreator Obsidian_Pickaxe;
    public static ItemCreator OIL_BARREL;


    private static void ItemSetup() {
        Orichalchite_Pickaxe = new ItemCreator(Material.WOODEN_PICKAXE)
                .setName("§9Orichalchite Pickaxe")
                .setTier(1)
                .addEnchantment(Enchantment.DIG_SPEED, 1)
                .getDigSpeed()
                .getFortune()
                .setPickaxe()
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Obsidian_Pickaxe = new ItemCreator(Material.DIAMOND_PICKAXE)
                .setName("§8Obsidian Pickaxe")
                .setFuel(1000)
                .setTier(2)
                .getDigSpeed()
                .getFortune()
                .setPickaxe()
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Orichalchite = new ItemCreator(Material.CYAN_DYE)
                .setName("§9Orichalchite Ore")
                .setRarity(Rarity.COMMON, "ORE")
                .setOre();
        // -------------------------------------------- //
        Gemstone = new ItemCreator(Material.SMALL_AMETHYST_BUD)
                .setName("§bGemstone")
                .setOre()
                .setUnplacable(true)
                .setRarity(Rarity.UNCOMMON, "GEMSTONE");
        // -------------------------------------------- //
        Refined_Gemstone_1 = new ItemCreator(Material.MEDIUM_AMETHYST_BUD)
                .setName("§bRefined Gemstone")
                .setOre()
                .setUnplacable(true)
                .setRarity(Rarity.RARE, "GEMSTONE");
        // -------------------------------------------- //
        OIL_BARREL = new ItemCreator(Material.LAVA_BUCKET)
                .setName("§2Oil Bucket")
                .setUnplacable(true)
                .HideItemFlags()
                .setAsFuel(1000)
                .setRarity(Rarity.UNCOMMON, "FUEL");

    }







}