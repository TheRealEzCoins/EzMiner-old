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
    public static ItemCreator Uprum_Pickaxe;
    public static ItemCreator Zaplium_Pickaxe;
    public static ItemCreator Slaginite_Pickaxe;

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
                .addEnchantment(Enchantment.DIG_SPEED, 3)
                .setFortune(0)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Uprum_Pickaxe = new ItemCreator(Material.STONE_PICKAXE)
                .setName("§4Uprum Pickaxe")
                .setPickaxe()
                .setTier(2)
                .addEnchantment(Enchantment.DIG_SPEED, 10)
                .setFortune(0)
                .setFuel(100)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Zaplium_Pickaxe = new ItemCreator(Material.STONE_PICKAXE)
                .setName("§eZaplium Pickaxe")
                .setPickaxe()
                .setTier(3)
                .setFortune(150)
                .addEnchantment(Enchantment.DIG_SPEED, 3)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Slaginite_Pickaxe = new ItemCreator(Material.IRON_PICKAXE)
                .setName("§9Slaginite Pickaxe")
                .setPickaxe()
                .setTier(3)
                .setFortune(200)
                .addEnchantment(Enchantment.DIG_SPEED, 1)
                .HideItemFlags()
                .setUnbreakable(true);

    }
}
