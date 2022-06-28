package me.ezplugin.Enums;

import me.ezplugin.Items.ItemCreator;
import me.ezplugin.Items.Items.MaterialItems;

public enum ShopItems {

    Tier_1_Handle(Type.MATERIAL, MaterialItems.TIER_1_HANDLE, 300, 1),
    Tier_2_Handle(Type.MATERIAL, MaterialItems.TIER_2_HANDLE, 750, 25),
    Tier_3_Handle(Type.MATERIAL, MaterialItems.TIER_3_HANDLE, 2500, 50),
    Tier_4_Handle(Type.MATERIAL, MaterialItems.TIER_4_HANDLE, 5000, 75),
    FUEL(Type.FUEL, MaterialItems.OIL_BARREL, 250, 10);




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