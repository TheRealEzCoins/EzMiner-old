package me.ezplugin.Items.Items;

import dev.dbassett.skullcreator.SkullCreator;
import me.ezplugin.Enums.Heads;
import me.ezplugin.Enums.Rarity;
import me.ezplugin.Enums.Type;
import me.ezplugin.Items.ItemCreator;
import org.bukkit.Material;

public class MaterialItems {
    public static void init() {
        ItemSetup();

    }

    public static ItemCreator OIL_BARREL;
    public static ItemCreator FortuneUpgrade;
    public static ItemCreator TIER_1_HANDLE;
    public static ItemCreator TIER_2_HANDLE;
    public static ItemCreator TIER_3_HANDLE;
    public static ItemCreator TIER_4_HANDLE;

    private static void ItemSetup() {
        OIL_BARREL = new ItemCreator(Material.LAVA_BUCKET)
                .setName("§8Fuel Bucket")
                .setUnplacable(true)
                .HideItemFlags()
                .setAsFuel(1000)
                .setRarity(Rarity.UNCOMMON, Type.FUEL);

        FortuneUpgrade = new ItemCreator(SkullCreator.itemFromUrl(Heads.Fortune.getURL()))
                .setName("§eFortune Boost")
                .addLore("")
                .addFortuneUpgrade(50)
                .setRarity(Rarity.RARE, Type.UPGRADE);


        TIER_1_HANDLE = new ItemCreator(Material.STICK)
                .setName("§6T1 Pickaxe Handle")
                .addLore("§7Tier 1 Handle")
                .setRarity(Rarity.UNCOMMON, Type.Material);

        TIER_2_HANDLE = new ItemCreator(Material.STICK)
                .setName("§cT2 Pickaxe Handle")
                .addLore("§7Tier 2 Handle")
                .setRarity(Rarity.RARE, Type.Material);
        TIER_3_HANDLE = new ItemCreator(Material.STICK)
                .setName("§bT3 Pickaxe Handle")
                .addLore("§7Tier 3 Handle")
                .setRarity(Rarity.EPIC, Type.Material);

        TIER_4_HANDLE = new ItemCreator(Material.STICK)
                .setName("§4§lT4 Pickaxe Handle")
                .addLore("§7Tier 4 Handle")
                .setRarity(Rarity.LEGENDARY, Type.Material);



    }
}
