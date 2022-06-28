package me.ezplugin.Enums;

import me.ezplugin.Items.ItemCreator;
import me.ezplugin.Items.Items.GemItems;
import me.ezplugin.Items.Items.MaterialItems;
import me.ezplugin.Items.Items.OreItems;
import me.ezplugin.Items.Items.PickaxeItems;

public enum ForgeItems {
    /** Pickaxe crafting (Forge) */
    Nacrine_Pickaxe(Type.TOOL, PickaxeItems.Nacrine_Pickaxe, 1, 7200),
    Uprum_Pickaxe(Type.TOOL, PickaxeItems.Uprum_Pickaxe, 10, 3600),
    Zaplium_Pickaxe(Type.TOOL, PickaxeItems.Zaplium_Pickaxe, 25, 7200),
    Lebriutium_Pickaxe(Type.TOOL, PickaxeItems.Lebriutium_Pickaxe, 35, 7200),
    Slaginite_Pickaxe(Type.TOOL, PickaxeItems.Slaginite_Pickaxe, 50, 7200),
    Gryrium_Pickaxe(Type.TOOL, PickaxeItems.Gryrium_Pickaxe, 60, 14400),
    Kreisium_Pickaxe(Type.TOOL, PickaxeItems.Kreisium_Pickaxe, 75, 14400),
    Volcanium_Pickaxe(Type.TOOL, PickaxeItems.Volcanium_Pickaxe, 90, 14400),
    Flotine_Pickaxe(Type.TOOL, PickaxeItems.Flotine_Pickaxe, 100, 28800),


    /** Gemstone crafting (Forge) */
    Refined_Gem(Type.ORE, GemItems.Refined_Gemstone, 10, 60),
    Polished_Gem(Type.ORE, GemItems.Polished_Gemstone, 15, 60),
    Perfect_Gem(Type.ORE, GemItems.Perfect_Gemstone, 20, 60),

    /** Upgrade crafting (Forge) */
    FortuneUpgrade(Type.UPGRADE, MaterialItems.FortuneUpgrade, 25, 600);

    private final ItemCreator output;
    private final Type type;
    private final int Level;
    private final int Time;

    ForgeItems(Type type, ItemCreator output, int Level, int Time) {
        this.output = output;
        this.Level = Level;
        this.Time = Time;
        this.type = type;

    }

    public ItemCreator getOuput() {
        return this.output;
    }

    public int getLevel() {
        return this.Level;
    }

    public int getTime() {
        return this.Time;
    }

    public Type getType() {
        return this.type;
    }


}
