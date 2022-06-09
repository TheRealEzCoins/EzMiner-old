package me.ezplugin.Enums;

import me.ezplugin.Items.ItemCreator;
import me.ezplugin.Items.ItemManager;

import java.util.Arrays;

public enum ForgeItems {
    Obsidian_Pickaxe(Type.TOOL, ItemManager.Obsidian_Pickaxe, 15, 30, 15, 14),
    Orichalchite_Pickaxe(Type.ORE, ItemManager.Orichalchite_Pickaxe, 1, 15, 128),
    Gemstone_2(Type.ORE, ItemManager.Refined_Gemstone_1, 5, 10, 16);

    private ItemCreator output;
    private Type type;
    private int Level;
    private int Time;
    private int[] Amount;

    ForgeItems(Type type, ItemCreator output, int Level, int Time, int... Amount) {
        this.output = output;
        this.Level = Level;
        this.Time = Time;
        this.Amount = Amount;
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

    public int[] getAmount() {
        return this.Amount;
    }

    public Type getType() {
        return this.type;
    }

    public String getAmountInteger() {
        String str = Arrays.toString(getAmount()).replaceAll(",|\\]|\\[", "");
        return str;
    }

}
