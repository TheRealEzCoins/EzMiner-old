package me.ezplugin.Utils;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
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
import java.util.concurrent.TimeUnit;

import static me.ezplugin.Utils.ItemUtils.customItemName;
import static me.ezplugin.Utils.ItemUtils.customItemUsingStack;

public class GuiUtils  {

    protected static ItemStack FILLER_GLASS = makeItem(Material.BLACK_STAINED_GLASS_PANE, " ", 1, 15);

    public static ItemStack getStatsAsSkull(Player player ) {
        int getLevel = StatUtils.getHashLevel(player);
        int getXP = StatUtils.getHashXP(player);
        int xpLeft = (getLevel * 500 - getXP);
        return customItemUsingStack(
                Utils.getPlayerSkull(player),
                "",
                "§7Current Level: §9" + getLevel,
                "§7Current xp: §9" + getXP + " §7/ §9" + (getLevel * 500),
                "§7Xp to next level: §9" + xpLeft);
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


    public static ItemStack createItem(ForgeItems forgeItems, Ores Resource_1) {
        int Value = Integer.parseInt(forgeItems.getAmountInteger().split(" ")[0]);
        return customItemUsingStack(
                forgeItems.getOuput().getItemStack(),
                forgeItems.getOuput().getName(),
                "",
                "§eItems required",
                ChatColor.GRAY + Resource_1.getItem().getName() + " §7x" + Value,
                "",
                "§8Duration: §b" + Utils.TimeSetup(forgeItems.getTime()));
    }

    public static void SetupItem(Player player , Inventory inventory, ForgeItems forgeItems, Ores Resource_1) {
        if (StatUtils.getHashLevel(player) >= forgeItems.getLevel()) {
            inventory.setItem(
                    inventory.firstEmpty(),
                    createItem(forgeItems, Resource_1));
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

    public static ItemStack createItem_2(ForgeItems forgeItems, Ores Resource_1, Ores Resource_2) {
        int Value = Integer.parseInt(forgeItems.getAmountInteger().split(" ")[0]);
        int Value2 = Integer.parseInt(forgeItems.getAmountInteger().split(" ")[1]);

        return customItemUsingStack(
                forgeItems.getOuput().getItemStack(),
                forgeItems.getOuput().getName(),
                "",
                "§eItems required",
                ChatColor.GRAY + Resource_1.getItem().getName() + " §7x" + Value,
                ChatColor.GRAY + Resource_2.getItem().getName() + " §7x" + Value2,
                "",
                "§8Duration: §b" + Utils.TimeSetup(forgeItems.getTime()));
    }

    public static void SetupItem_2(Player player , Inventory inventory, ForgeItems forgeItems, Ores Resource_1, Ores Resource_2) {
        if (StatUtils.getHashLevel(player) >= forgeItems.getLevel()) {
            inventory.setItem(
                    inventory.firstEmpty(),
                    createItem_2(forgeItems, Resource_1, Resource_2));
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



    public static String nameSetup(Ores ore) {
        return ore.getItem().getName() + " ";
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
            player.sendMessage("§cYou need to be a higher level to forge this!");
        }
    }

}
