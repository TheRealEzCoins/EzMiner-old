package me.ezplugin.Utils;

import dev.dbassett.skullcreator.SkullCreator;
import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Heads;
import me.ezplugin.Enums.Resources;
import me.ezplugin.Enums.ShopItems;
import me.ezplugin.GUI.GUIS.GemsGUI;
import me.ezplugin.GUI.GUIS.MaterialGUI;
import me.ezplugin.GUI.GUIS.ResourcesGUI;
import me.ezplugin.Utils.Files.StatUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import static me.ezplugin.Utils.ItemUtils.customItemName;
import static me.ezplugin.Utils.ItemUtils.customItemUsingStack;

public class GuiUtils  {

    protected static ItemStack FILLER_GLASS = makeItem(Material.BLACK_STAINED_GLASS_PANE, " ", 1, 15);

    public static ItemStack getStatsAsSkull(Player player ) {
        int getLevel = StatUtils.getHashLevel(player);
        int getXP = StatUtils.getHashXP(player);
        final long xpLeft = 25 * Math.round((500 + getLevel * Math.log(Math.pow(25, getLevel))) / 25);
        final double v = xpLeft - getXP;
        int Fragments = StatUtils.getHashFragments(player);
        return customItemUsingStack(
                Utils.getPlayerSkull(player),
                "§9" + player.getName() + "'s stats." ,
                "§7Current Level: §9" + getLevel,
                "§7Current xp: §9" + getXP + " §7/ §9" + xpLeft,
                "§7Xp to next level: §9" + v,
                "§7Fragments: §9" + Fragments);
    }

    public static ItemStack getItemAsShop(ShopItems items) {
        return customItemUsingStack(
                items.getItem().getItemStack(),
                items.getItem().getName(),
                "§7Level requirement: §c" + items.getLevel(),
                "",
                "§7Price: §c" + items.getCost() + "§7 Fragments"
        );
    }

    public static ItemStack makeItem(Material material, String displayName, int amount, int durability, String... lore){
        ItemStack item = new ItemStack(material, amount, (short) durability);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;
    }

    protected static ItemStack unlockableitem(int Level) {
      return customItemName(
              Material.BARRIER,
              "§7Locked!",
              "", "§8Unlocks at Level " + Level);
    }

    public static void unlockable(Inventory inventory, int level) {
        inventory.setItem(
                inventory.firstEmpty(),
                unlockableitem(level));
    }

    public static ItemStack menuClose() {
        return customItemName(
                Material.BARRIER,
                "§cClose",
                "",
                "§8Closes the menu.");
    }

    public static ItemStack menuReturn() {
        return customItemName(
                Material.ARROW,
                "§bGo Back!",
                "",
                "§8Goes back to the previous menu!");
    }


    public static ItemStack createItem(ForgeItems forgeItems, Resources Resource_1, int Amount) {
        return customItemUsingStack(
                forgeItems.getOuput().getItemStack(),
                forgeItems.getOuput().getName(),
                "",
                "§eItems required",
                ChatColor.GRAY + Resource_1.getItem().getName() + " §7x" + Amount,
                "",
                "§8Duration: §b" + Utils.TimeSetup(forgeItems.getTime()));
    }

    public static void SetupItem(Player player , Inventory inventory, ForgeItems forgeItems, Resources Resource_1, int Amount) {
        if (StatUtils.getHashLevel(player) >= forgeItems.getLevel()) {
            inventory.setItem(
                    inventory.firstEmpty(),
                    createItem(forgeItems, Resource_1, Amount));
        } else {
            inventory.setItem(inventory.firstEmpty(), GuiUtils.unlockableitem(forgeItems.getLevel()));
        }
    }



    public static ItemStack Crafting(ForgeItems forgeItems, Player player) throws ParseException {
        Date forgeDate = Utils.formatter.parse(StatUtils.getTimer(player, forgeItems));

        long Time =  forgeDate.getTime() - Utils.getTime().getTime();
        long diffSeconds = Time / 1000 % 60;
        long diffMinutes = Time / (60 * 1000) % 60;
        long diffHours = Time / (60 * 60 * 1000);
        return customItemUsingStack(
                forgeItems.getOuput().getItemStack(),
                forgeItems.getOuput().getName(),
                "",
                "§fTime remaining: §c" + diffHours + ":" + diffMinutes + ":" + diffSeconds
        );
    }

    public static ItemStack createItem_2(ForgeItems forgeItems, Resources Resource_1, int Amount_1, Resources Resource_2, int Amount_2) {

        return customItemUsingStack(
                forgeItems.getOuput().getItemStack(),
                forgeItems.getOuput().getName(),
                "",
                "§eItems required",
                ChatColor.GRAY + Resource_1.getItem().getName() + " §7x" + Amount_1,
                ChatColor.GRAY + Resource_2.getItem().getName() + " §7x" + Amount_2,
                "",
                "§8Duration: §b" + Utils.TimeSetup(forgeItems.getTime()));
    }

    public static ItemStack createItemMaterial_2(ForgeItems forgeItems, Resources Resource_1, int Amount_1, ShopItems Resource_2, int Amount_2) {

        return customItemUsingStack(
                forgeItems.getOuput().getItemStack(),
                forgeItems.getOuput().getName(),
                "",
                "§eItems required",
                ChatColor.GRAY + Resource_1.getItem().getName() + " §7x" + Amount_1,
                ChatColor.GRAY + Resource_2.getItem().getName() + " §7x" + Amount_2,
                "",
                "§8Duration: §b" + Utils.TimeSetup(forgeItems.getTime()));
    }

    public static void SetupItem_2(Player player , Inventory inventory, ForgeItems forgeItems, Resources Resource_1, int Amount_1, Resources Resources_2, int Amount_2) {
        if (StatUtils.getHashLevel(player) >= forgeItems.getLevel()) {
            inventory.setItem(
                    inventory.firstEmpty(),
                    createItem_2(forgeItems, Resource_1, Amount_1, Resources_2, Amount_2));
        } else {
            inventory.setItem(inventory.firstEmpty(), GuiUtils.unlockableitem(forgeItems.getLevel()));
        }
    }

    public static void SetupItemMaterial_2(Player player , Inventory inventory, ForgeItems forgeItems, Resources Resource_1, int Amount_1, ShopItems Resource_2, int Amount_2) {
        if (StatUtils.getHashLevel(player) >= forgeItems.getLevel()) {
            inventory.setItem(
                    inventory.firstEmpty(),
                    createItemMaterial_2(forgeItems, Resource_1, Amount_1, Resource_2, Amount_2));
        } else {
            inventory.setItem(inventory.firstEmpty(), GuiUtils.unlockableitem(forgeItems.getLevel()));
        }
    }

    public static void fillBorder(Inventory inventory) {
        ItemStack item = FILLER_GLASS;
        int size = inventory.getSize();
        int rows = (size + 1) / 9;

        // Fill top
        for (int i = 0; i < 9; i++) {
            inventory.setItem(i, item);
        }

        // Fill bottom
        for (int i = size - 9; i < size; i++) {
            inventory.setItem(i, item);
        }

        // Fill sides
        for (int i = 2; i <= rows - 1; i++) {
            int[] slots = new int[]{i * 9 - 1, (i - 1) * 9};
            inventory.setItem(slots[0], item);
            inventory.setItem(slots[1], item);
        }
    }

    public static void fillEmpty(Inventory inventory) {
        ItemStack item = FILLER_GLASS;
        int size = inventory.getSize();

        for(int slot = 0; slot < size; slot++){
            inventory.setItem(slot, item);
        }
    }

    public static void fillResources(Inventory inventory) {
        ItemStack item = FILLER_GLASS;
        ItemStack red_glass = customItemName(Material.RED_STAINED_GLASS_PANE, " ");
        fillBorder(inventory);
        int[] rest = new int[] {10, 11, 15, 16};
        int[] other = new int[] {12, 13, 14};
        for(int slot : rest) {
            inventory.setItem(slot, item);
        }

        for(int slot : other) {
            inventory.setItem(slot, red_glass);
        }

        inventory.setItem(
                3, ItemUtils.customItemUsingStack(SkullCreator.itemFromUrl(Heads.Ores.getURL()), "§cResources")
        );

        inventory.setItem(
                4,
                ItemUtils.customItemUsingStack(SkullCreator.itemFromUrl(Heads.Gemstone_Pot.getURL()), "§bGemstone Pot")

        );

        inventory.setItem(5,
                ItemUtils.customItemUsingStack(SkullCreator.itemFromUrl(Heads.Materials.getURL()), "§8Materials")
        );

    }



    public static String nameSetup(Resources ore) {
        return ore.getItem().getName() + " ";
    }

    public static String nameSetupShop(ShopItems items) {
        return items.getItem().getName() + " ";
    }

    public static void MiscSetup(InventoryClickEvent e, Inventory inventory) {
        Player player = (Player) e.getWhoClicked();
        if (e.getCurrentItem().getType().equals(Material.ARROW)) {
            player.openInventory(inventory);
            player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 1f, 5f);
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cClose")) {
            player.closeInventory();
            player.playSound(player.getLocation(), Sound.BLOCK_CHEST_CLOSE, 1f, -1f);
        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Locked!")) {
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, -10f);
            player.sendMessage("§cYou need to be a higher level to access this!");
        }
    }

    public static void ResourceListener(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if(e.getSlot() == 3) {
            player.openInventory(ResourcesGUI.ResourcesGUI(player));
            player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 1f, -5f);
        } else if (e.getSlot() == 4) {
            player.openInventory(GemsGUI.GemGUI(player));
            player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_LEATHER, 1f, -5f);
        } else if (e.getSlot() == 5) {
            player.openInventory(MaterialGUI.MaterialGUI(player));
        }
    }

}
