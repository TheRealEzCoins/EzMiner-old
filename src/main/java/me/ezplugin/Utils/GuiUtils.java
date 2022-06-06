package me.ezplugin.Utils;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.EzMiner;
import me.ezplugin.GUI.GUIS.ResourcesGUI;
import me.ezplugin.GUI.GUIS.SelectorGUI;
import me.ezplugin.Items.ItemCreator;
import me.ezplugin.Items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

import java.util.Arrays;
import java.util.Locale;

public class GuiUtils extends ItemUtils {

    protected static ItemStack FILLER_GLASS = makeItem(Material.BLACK_STAINED_GLASS_PANE, " ", 1, 15);

    public static ItemStack getStatsAsSkull(Player player ) {
        int getLevel = Utils.getLevel(player);
        int getXP = Utils.getXP(player);
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

    public static ItemStack unlockable(int Level) {
      return customItemName(
              Material.BARRIER,
              "§7Locked!",
              "", "§8Unlocks at Level " + Level);
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
                "§8Goes back to the selection menu!.");
    }

    public static ItemStack ResourceCreation(Ores ores, Player player) {
        PersistentDataContainer data = player.getPersistentDataContainer();
        int amount = data.get(new NamespacedKey(EzMiner.getPlugin(), ores.name()), PersistentDataType.INTEGER);
        return customItemName(
                ores.getItem().getType(),
                GuiUtils.nameSetup(ores),
                "§fRequired Level: §c" + ores.getLevel(),
                "§fRequired Tier: §c" + ores.getTier(),
                "",
                "§fAmount: §a" + amount,
                "",
                "§c→ §fLeft-Click to deposit",
                "§c→ §fShift-Left-Click to deposit all",
                "§c→ §fRight-Click to withdraw",
                "§c→ §fShift-Right-Click to withdraw 64");
    }

    public static ItemStack createItem(ItemCreator itemCreator, Ores Resource_1, ForgeItems forgeItems) {
        int Value = Integer.parseInt(forgeItems.getAmountInteger().split(" ")[0]);
        return customItemName(
                itemCreator.getType(),
                itemCreator.getName(),
                "",
                "§eItems required",
                ChatColor.GRAY + Resource_1.getItem().getName() + " §7x" + Value,
                "",
                "§8Duration: §b" + Utils.TimeSetup(forgeItems.getTime()));
    }

    public static ItemStack createItem_2(ItemCreator itemCreator, Ores Resource_1, Ores Resource_2, ForgeItems forgeItems) {
        int Value = Integer.parseInt(forgeItems.getAmountInteger().split(" ")[0]);
        int Value2 = Integer.parseInt(forgeItems.getAmountInteger().split(" ")[1]);

        return customItemName(
                itemCreator.getType(),
                itemCreator.getName(),
                "",
                "§eItems required",
                ChatColor.GRAY + Resource_1.getItem().getName() + " §7x" + Value,
                ChatColor.GRAY + Resource_2.getItem().getName() + " §7x" + Value2,
                "",
                "§8Duration: §b" + Utils.TimeSetup(forgeItems.getTime()));
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

    public static void GUISetup(Player player, InventoryClickEvent e, String GUI_Name, Inventory Previous_GUI) {
        if (e.getView().getTitle().equalsIgnoreCase(GUI_Name)) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
            }  else if (e.getCurrentItem().getType().equals(Material.ARROW)) {
                player.openInventory(Previous_GUI);
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cClose")) {
                player.closeInventory();
            }
        }
    }

    public static void ResourceListener(Player player, InventoryClickEvent e, Ores ore) {
        PersistentDataContainer data = player.getPersistentDataContainer();
        if(e.isRightClick() && !(e.isShiftClick())) {
            if(!(Utils.getResources(player, ore) <= 0)) {
                ore.getItem().getItemStack().setAmount(1);
                player.getInventory().addItem(ore.getItem().getItemStack());
                int getAmount = Utils.getResources(player, ore);
                data.set(new NamespacedKey(EzMiner.getPlugin(), ore.name()), PersistentDataType.INTEGER, getAmount - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 5f);
                player.sendMessage("§c-1 " + ore.getItem().getName());
                player.openInventory(ResourcesGUI.ResourcesGUI(player));
            } else {
                player.sendMessage("§cYou do not have enough of that resource!");
                Utils.FailedSound(player);
            }
        } if(e.isLeftClick() && !(e.isShiftClick())) {
            if(player.getInventory().containsAtLeast(ore.getItem().getItemStack(), 1)) {
                player.getInventory().removeItem(ore.getItem().getItemStack());
                int getAmount = Utils.getResources(player, ore);
                data.set(new NamespacedKey(EzMiner.getPlugin(), ore.name()), PersistentDataType.INTEGER, getAmount + 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 5f);
                player.sendMessage("§c+1 " + ore.getItem().getName());
                player.openInventory(ResourcesGUI.ResourcesGUI(player));

            } else {
                player.sendMessage("§cYou do not have enough of that resource in your inventory!");
                Utils.FailedSound(player);
            }
        } if(e.isShiftClick() && e.isRightClick()) {
            if (!(Utils.getResources(player, ore) < 64)) {
                ore.getItem().getItemStack().setAmount(64);
                player.getInventory().addItem(ore.getItem().getItemStack());
                int getAmount = Utils.getResources(player, ore);
                data.set(new NamespacedKey(EzMiner.getPlugin(), ore.name()), PersistentDataType.INTEGER, getAmount - 64);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 5f);
                player.sendMessage("§c-64 " + ore.getItem().getName());
                player.openInventory(ResourcesGUI.ResourcesGUI(player));
            } else {
                player.sendMessage("§cYou do not have enough of that resource!");
                Utils.FailedSound(player);
            }



        } if(e.isLeftClick() && e.isShiftClick()) {
            if (player.getInventory().containsAtLeast(ore.getItem().getItemStack(), 1)) {
                int amount = 0;
                for (ItemStack item : player.getInventory().getContents()) {
                    if (item != null && item.getType().equals(ore.getItem().getType())) {
                        amount += item.getAmount();
                        if(item.getType() == ore.getItem().getType() && item.getAmount() >= 1) {
                            int newStack = item.getAmount() - item.getAmount();
                            item.setAmount(newStack);
                        }
                    }

                }

                int getAmount = Utils.getResources(player, ore);
                data.set(new NamespacedKey(EzMiner.getPlugin(), ore.name()), PersistentDataType.INTEGER, getAmount + amount);
                player.sendMessage("§c+" + amount + " " + ore.getItem().getName());
                player.openInventory(ResourcesGUI.ResourcesGUI(player));

            } else {
                player.sendMessage("§cYou do not have enough of that resource!");
                Utils.FailedSound(player);
            }
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

    public static int ResourcesGathering(ForgeItems forgeItems, int i) {
        int Value = Integer.parseInt(forgeItems.getAmountInteger().split(" ")[i]);
        return Value;
    }
}
