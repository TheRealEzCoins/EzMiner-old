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
    public static ItemCreator Gryrium_Pickaxe;
    public static ItemCreator Kreisium_Pickaxe;
    public static ItemCreator Volcanium_Pickaxe;
    public static ItemCreator Flotine_Pickaxe;

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
                .setName("§4Uprum Drill")
                .setPickaxe()
                .setTier(2)
                .addEnchantment(Enchantment.DIG_SPEED, 4)
                .setFortune(50)
                .setFuel(1000)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Zaplium_Pickaxe = new ItemCreator(Material.STONE_PICKAXE)
                .setName("§eZaplium Pickaxe")
                .setPickaxe()
                .setTier(3)
                .setFortune(125)
                .addEnchantment(Enchantment.DIG_SPEED, 3)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Slaginite_Pickaxe = new ItemCreator(Material.IRON_PICKAXE)
                .setName("§9Slaginite Pickaxe")
                .setPickaxe()
                .setTier(3)
                .setFortune(150)
                .addEnchantment(Enchantment.DIG_SPEED, 1)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Gryrium_Pickaxe = new ItemCreator(Material.IRON_PICKAXE)
                .setName("§7Gryrium Pickaxe")
                .setPickaxe()
                .setTier(4)
                .setFortune(175)
                .addEnchantment(Enchantment.DIG_SPEED, 3)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Kreisium_Pickaxe = new ItemCreator(Material.DIAMOND_PICKAXE)
                .setName("§cKreisium Pickaxe")
                .setPickaxe()
                .setTier(4)
                .setFortune(200)
                .addEnchantment(Enchantment.DIG_SPEED, 1)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Volcanium_Pickaxe = new ItemCreator(Material.DIAMOND_PICKAXE)
                .setName("§6Volcanium Pickaxe")
                .setPickaxe()
                .setTier(5)
                .setFortune(225)
                .addEnchantment(Enchantment.DIG_SPEED, 3)
                .HideItemFlags()
                .setUnbreakable(true);
        // -------------------------------------------- //
        Flotine_Pickaxe = new ItemCreator(Material.GOLDEN_PICKAXE)
                .setName("§7Gryrium Pickaxe")
                .setPickaxe()
                .setTier(6)
                .setFortune(250)
                .addEnchantment(Enchantment.DIG_SPEED, 2)
                .HideItemFlags()
                .setUnbreakable(true);

    }
}
