package me.ezplugin.Enums;

import me.ezplugin.Items.ItemCreator;
import me.ezplugin.Items.ItemManager;
import org.bukkit.Material;

public enum Ores {
    Orichalchite(ItemManager.Orichalchite, Material.IRON_ORE, 1, 1),
    Gemstone_1(ItemManager.Gemstone, Material.GREEN_STAINED_GLASS, 2, 15);


    private ItemCreator itemCreator;
    private Material block;
    private int Tier;
    private int Level;

    Ores(ItemCreator itemCreator, Material block, int Tier, int Level) {
        this.itemCreator = itemCreator;
        this.block = block;
        this.Tier = Tier;
        this.Level = Level;

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

}
