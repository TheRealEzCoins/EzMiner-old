package me.ezplugin.Items.Items;

import dev.dbassett.skullcreator.SkullCreator;
import me.ezplugin.Enums.Heads;
import me.ezplugin.Enums.Rarity;
import me.ezplugin.Enums.Type;
import me.ezplugin.Items.ItemCreator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class OreItems {

    public static void init() {
        ItemSetup();

    }

    public static ItemCreator Zaplium;
    public static ItemCreator Uprum;
    public static ItemCreator Slaginite;
    public static ItemCreator Gryrium;
    public static ItemCreator Kreisium;
    public static ItemCreator Volcanium;
    public static ItemCreator Nacrine;
    public static ItemCreator Flotine;


    private static void ItemSetup() {
        // -------------------------------------------- //
        Nacrine = new ItemCreator(SkullCreator.itemFromUrl(Heads.Nacrine.getURL()))
                .setName("§8Nacrine Ore")
                .setRarity(Rarity.COMMON, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Uprum = new ItemCreator(SkullCreator.itemFromUrl(Heads.Uprum.getURL()))
                .setName("§4Uprum Ore")
                .setRarity(Rarity.COMMON, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Zaplium = new ItemCreator(SkullCreator.itemFromUrl(Heads.Zaplium.getURL()))
                .setName("§eZaplium Ore")
                .setRarity(Rarity.UNCOMMON, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Slaginite = new ItemCreator(SkullCreator.itemFromUrl(Heads.Slaginite.getURL()))
                .setName("§fSlaginite Ore")
                .setRarity(Rarity.RARE, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Gryrium = new ItemCreator(SkullCreator.itemFromUrl(Heads.Gryrium.getURL()))
                .setName("§7Gryrium Ore")
                .setRarity(Rarity.RARE, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Kreisium = new ItemCreator(SkullCreator.itemFromUrl(Heads.Kreisium.getURL()))
                .setName("§cKreisium Ore")
                .setRarity(Rarity.EPIC, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Volcanium = new ItemCreator(SkullCreator.itemFromUrl(Heads.Volcanium.getURL()))
                .setName("§6Volcanium Ore")
                .setRarity(Rarity.EPIC, Type.ORE)
                .setOre();
        // -------------------------------------------- //
        Flotine = new ItemCreator(SkullCreator.itemFromUrl(Heads.Flotine.getURL()))
                .setName("§aFlotine Ore")
                .setRarity(Rarity.LEGENDARY, Type.ORE)
                .setOre();


    }







}