package me.ezplugin.Enums;

import me.ezplugin.Items.ItemCreator;
import me.ezplugin.Items.ItemManager;

import java.util.Arrays;

public enum ForgeItems {
    /** Pickaxe crafting (Forge) */
    Obsidian_Pickaxe(Type.TOOL, ItemManager.Obsidian_Pickaxe, 15, 30),
    Orichalchite_Pickaxe(Type.TOOL, ItemManager.Orichalchite_Pickaxe, 1, 15),


    /** Gemstone crafting (Forge) */
    Refined_Gem(Type.ORE, ItemManager.Refined_Gemstone, 10, 600),
    Polished_Gem(Type.ORE, ItemManager.Polished_Gemstone, 15, 600),
    Perfect_Gem(Type.ORE, ItemManager.Perfect_Gemstone, 20, 600),

    /** Upgrade crafting (Forge) */
    FortuneUpgrade(Type.UPGRADES, ItemManager.FortuneUpgrade, 25, 300);

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
