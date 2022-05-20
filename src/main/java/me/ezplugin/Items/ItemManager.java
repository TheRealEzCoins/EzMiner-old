package me.ezplugin.Items;

import org.bukkit.Material;
import org.bukkit.event.block.BlockPlaceEvent;

public class ItemManager {

    public static void init() {
        ItemSetup();

    }

    public static ItemCreator Orichalchite;
    public static ItemCreator Gemstone;
    public static ItemCreator Orichalchite_Pickaxe;
    public static ItemCreator Obsidian_Pickaxe;


    private static void ItemSetup() {
        Orichalchite_Pickaxe = new ItemCreator(Material.DIAMOND_PICKAXE)
                .setName("§9Orichalchite Pickaxe")
                .setTier(1)
                .setUnbreakable(true);
        // -------------------------------------------- //
        Obsidian_Pickaxe = new ItemCreator(Material.GOLDEN_PICKAXE)
                .setName("§8Obsidian Pickaxe")
                .setFuel(1000)
                .setTier(2)
                .setUnbreakable(true);
        // -------------------------------------------- //
        Orichalchite = new ItemCreator(Material.CYAN_DYE)
                .setName("§9Orichalchite Ore")
                .setOre();
        // -------------------------------------------- //
        Gemstone = new ItemCreator(Material.AMETHYST_CLUSTER)
                .setName("§bGemstone")
                .setOre()
                .setUnplacable(true)
                .setRarity(1);
        // -------------------------------------------- //
        // -------------------------------------------- //

    }







}