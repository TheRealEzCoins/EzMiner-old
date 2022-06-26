package me.ezplugin.Items.Items;

import dev.dbassett.skullcreator.SkullCreator;
import me.ezplugin.Enums.ArmorSets;
import me.ezplugin.Enums.Heads;
import me.ezplugin.Enums.Rarity;
import me.ezplugin.Enums.Type;
import me.ezplugin.Items.ItemCreator;
import org.bukkit.Color;
import org.bukkit.Material;

public class ArmorItems {
    public static void init() {
        ItemSetup();

    }

    public static ItemCreator Uprum_Helmet;
    public static ItemCreator Uprum_Chestplate;
    public static ItemCreator Uprum_Leggings;
    public static ItemCreator Uprum_Boots;

    private static void ItemSetup() {
        Uprum_Helmet = new ItemCreator(SkullCreator.itemFromUrl(Heads.Uprum_Helm.getURL()))
                .setName("§4Uprum Helmet")
                .setUnplacable(true)
                .HideItemFlags()
                .setCustomArmor(ArmorSets.UPRUM_ARMOR, 25)
                .setUnbreakable(true)
                .setRarity(Rarity.RARE, Type.ARMOR);

        Uprum_Chestplate = new ItemCreator(Material.LEATHER_CHESTPLATE)
                .setName("§4Uprum Chestplate")
                .HideItemFlags()
                .setCustomArmor(ArmorSets.UPRUM_ARMOR, 25)
                .setUnbreakable(true)
                .dyeArmor(Color.fromRGB(240, 200, 108))
                .setRarity(Rarity.RARE, Type.ARMOR);

        Uprum_Leggings = new ItemCreator(Material.LEATHER_LEGGINGS)
                .setName("§4Uprum Leggings")
                .HideItemFlags()
                .setCustomArmor(ArmorSets.UPRUM_ARMOR, 25)
                .setUnbreakable(true)
                .dyeArmor(Color.fromRGB(240, 200, 108))
                .setRarity(Rarity.RARE, Type.ARMOR);

        Uprum_Boots = new ItemCreator(Material.LEATHER_BOOTS)
                .setName("§4Uprum Boots")
                .HideItemFlags()
                .setCustomArmor(ArmorSets.UPRUM_ARMOR, 25)
                .setUnbreakable(true)
                .dyeArmor(Color.fromRGB(240, 200, 108))
                .setRarity(Rarity.RARE, Type.ARMOR);




    }
}
