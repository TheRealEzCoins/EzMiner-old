package me.ezplugin.Enums;

import me.ezplugin.Items.ItemCreator;
import me.ezplugin.Items.ItemManager;
import org.bukkit.Material;

public enum Ores {
    Nacrine(Type.ORE, ItemManager.Nacrine, Material.COAL_ORE, 1, 1),
    Zaplium(Type.ORE, ItemManager.Zaplium, Material.GOLD_ORE, 2, 30),
    Slaginite(Type.ORE, ItemManager.Slaginite, Material.LAPIS_ORE, 3, 45),
    Gryrium(Type.ORE, ItemManager.Gryrium, Material.DEEPSLATE_IRON_ORE, 3, 60),
    Kreisium(Type.ORE, ItemManager.Kreisium, Material.DEEPSLATE_REDSTONE_ORE, 4, 80),
    Volcanium(Type.ORE, ItemManager.Volcanium, Material.DEEPSLATE_GOLD_ORE, 4, 90),
    Flotine(Type.ORE, ItemManager.Flotine, Material.DEEPSLATE_EMERALD_ORE, 5, 100),


    /** Gems */
    Gemstone(Type.GEM, ItemManager.Gemstone, Material.GREEN_STAINED_GLASS, 2, 5),
    Refined_Gemstone(Type.GEM, ItemManager.Refined_Gemstone, null, 2, 10),
    Polished_Gemstone(Type.GEM, ItemManager.Polished_Gemstone, null, 2, 15),
    Perfect_Gemstone(Type.GEM, ItemManager.Perfect_Gemstone, null, 2, 25);




    private final ItemCreator itemCreator;
    private final Material block;
    private final int Tier;
    private final int Level;
    private final Type type;


    Ores(Type type, ItemCreator itemCreator, Material block, int Tier, int Level) {
        this.itemCreator = itemCreator;
        this.block = block;
        this.Tier = Tier;
        this.Level = Level;
        this.type = type;

    }

    public ItemCreator getItem() {
        return this.itemCreator;
    }

    public Material getBlock() {
        return this.block;
    }

    public int getTier() {
        return this.Tier;
    }

    public int getLevel() {
        return this.Level;
    }

    public Type getType() {
        return this.type;
    }

}
