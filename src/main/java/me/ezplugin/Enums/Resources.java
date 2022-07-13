package me.ezplugin.Enums;

import me.ezplugin.Items.ItemCreator;
import me.ezplugin.Items.Items.GemItems;
import me.ezplugin.Items.Items.OreItems;
import org.bukkit.Material;

public enum Resources {
    Nacrine(Type.ORE, OreItems.Nacrine, Material.COAL_ORE, 1, 1),
    Uprum(Type.ORE, OreItems.Uprum, Material.COPPER_ORE, 1, 10),
    Zaplium(Type.ORE, OreItems.Zaplium, Material.GOLD_ORE, 2, 25),
    Lebriutium(Type.ORE, OreItems.Lebriutium, Material.IRON_ORE, 2, 35),
    Slaginite(Type.ORE, OreItems.Slaginite, Material.LAPIS_ORE, 3, 50),
    Gryrium(Type.ORE, OreItems.Gryrium, Material.DEEPSLATE_IRON_ORE, 3, 60),
    Kreisium(Type.ORE, OreItems.Kreisium, Material.DEEPSLATE_REDSTONE_ORE, 4, 75),
    Volcanium(Type.ORE, OreItems.Volcanium, Material.DEEPSLATE_GOLD_ORE, 4, 90),
    Flotine(Type.ORE, OreItems.Flotine, Material.DEEPSLATE_EMERALD_ORE, 5, 100),



    /** Gems */
    Gemstone(Type.GEM, GemItems.Gemstone, Material.DIAMOND_ORE, 2, 5),
    Refined_Gemstone(Type.GEM, GemItems.Refined_Gemstone, null, 2, 10),
    Polished_Gemstone(Type.GEM, GemItems.Polished_Gemstone, null, 2, 15),
    Perfect_Gemstone(Type.GEM, GemItems.Perfect_Gemstone, null, 2, 25);





    private final ItemCreator itemCreator;
    private final Material block;
    private final int Tier;
    private final int Level;
    private final Type type;


    Resources(Type type, ItemCreator itemCreator, Material block, int Tier, int Level) {
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
