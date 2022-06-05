package me.ezplugin.Enums;

import me.ezplugin.Items.ItemCreator;
import me.ezplugin.Items.ItemManager;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum ForgeItems {
    Gemstone_2(ItemManager.Refined_Gemstone_1, 5, 10,new ItemStack[]{new ItemStack(Material.HONEY_BOTTLE, 6), new ItemStack(Material.GREEN_STAINED_GLASS, 3)});

    private ItemCreator output;
    private int Level;
    private int Time;
    private ItemStack[] Recipe;

    ForgeItems(ItemCreator output, int Level, int Time ,ItemStack[] recipe) {
        this.output = output;
        this.Level = Level;
        this.Time = Time;
        this.Recipe = recipe;

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

    public ItemStack[] getRecipe() {
        return this.Recipe;
    }

}
