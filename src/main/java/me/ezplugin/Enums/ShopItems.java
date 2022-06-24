package me.ezplugin.Enums;

import me.ezplugin.Items.ItemCreator;
import me.ezplugin.Items.Items.MaterialItems;
import org.bukkit.Material;

public enum ShopItems {

    Tier_1_Handle(Type.Material, MaterialItems.TIER_1_HANDLE, 500, 1),
    Tier_2_Handle(Type.Material, MaterialItems.TIER_2_HANDLE, 1750, 30),
    FUEL(Type.Material, MaterialItems.OIL_BARREL, 250, 30);




    private final ItemCreator itemCreator;
    private final int Level;
    private final Type type;
    private final int Cost;

    ShopItems(Type type, ItemCreator item, int Cost, int Level) {
        this.type = type;
        this.itemCreator = item;
        this.Cost = Cost;
        this.Level = Level;
    }

    public ItemCreator getItem() {
        return this.itemCreator;
    }

    public Type getType() {
        return this.type;
    }

    public int getCost() {
        return this.Cost;
    }

    public int getLevel() {
        return this.Level;
    }
}