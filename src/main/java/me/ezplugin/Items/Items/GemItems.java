package me.ezplugin.Items.Items;

import dev.dbassett.skullcreator.SkullCreator;
import me.ezplugin.Enums.Heads;
import me.ezplugin.Enums.Rarity;
import me.ezplugin.Enums.Type;
import me.ezplugin.Items.ItemCreator;

public class GemItems {
    public static void init() {
        ItemSetup();

    }

    public static ItemCreator Gemstone;
    public static ItemCreator Refined_Gemstone;
    public static ItemCreator Polished_Gemstone;
    public static ItemCreator Perfect_Gemstone;

    private static void ItemSetup() {
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

    }
}
