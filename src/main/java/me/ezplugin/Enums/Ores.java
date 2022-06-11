package me.ezplugin.Enums;

import me.ezplugin.Items.ItemCreator;
import me.ezplugin.Items.ItemManager;
import org.bukkit.Material;

public enum Ores {
    Orichalchite(Type.ORE, ItemManager.Orichalchite, Material.IRON_ORE, 1, 1),
    Gemstone(Type.GEM, ItemManager.Gemstone, Material.GREEN_STAINED_GLASS, 2, 5),
    Refined_Gemstone(Type.GEM, ItemManager.Refined_Gemstone, null, 2, 10),
    Polished_Gemstone(Type.GEM, ItemManager.Polished_Gemstone, null, 2, 15),
    Perfect_Gemstone(Type.GEM, ItemManager.Perfect_Gemstone, null, 2, 25);




    private ItemCreator itemCreator;
    private Material block;
    private int Tier;
    private int Level;
    private Type type;


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
