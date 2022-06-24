package me.ezplugin.Items.Items;

import me.ezplugin.Items.ItemCreator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class PickaxeItems {
    public static void init() {
        ItemSetup();

    }

    public static ItemCreator Starter_Pickaxe;
    public static ItemCreator Nacrine_Pickaxe;
    public static ItemCreator Zaplium_Pickaxe;

    private static void ItemSetup() {

        Starter_Pickaxe = new ItemCreator(Material.WOODEN_PICKAXE)
                .setName("§fStarter Pickaxe")
                .setPickaxe()
                .setTier(1)
                .addEnchantment(Enchantment.DURABILITY, 1)
                .setFortune(0)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Nacrine_Pickaxe = new ItemCreator(Material.WOODEN_PICKAXE)
                .setName("§8Nacrine Pickaxe")
                .setPickaxe()
                .setTier(1)
                .addEnchantment(Enchantment.DIG_SPEED, 2)
                .setFortune(0)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Zaplium_Pickaxe = new ItemCreator(Material.STONE_PICKAXE)
                .setName("§eZaplium Pickaxe")
                .setPickaxe()
                .setTier(1)
                .setFortune(100)
                .setFuel(1000)
                .HideItemFlags()
                .setUnbreakable(true);

    }
}
