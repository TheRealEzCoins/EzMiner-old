package me.ezplugin.Utils;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.EzMiner;
import me.ezplugin.GUI.GUIS.ResourcesGUI;
import me.ezplugin.Items.ItemCreator;
import me.ezplugin.Items.ItemManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static me.ezplugin.Utils.ItemUtils.customItemName;
import static me.ezplugin.Utils.ItemUtils.customItemUsingStack;
import static me.ezplugin.Utils.Utils.setupResources;

public class ResourceSetup {

    public static ItemStack ResourceItem(Ores ores, Player player) {
        PersistentDataContainer data = player.getPersistentDataContainer();
        int amount = data.get(new NamespacedKey(EzMiner.getPlugin(), ores.name()), PersistentDataType.INTEGER);

        return customItemUsingStack(
                ores.getItem().getItemStack(),
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


    public static void ResourceCreation(Player player , Inventory inventory) {
        for(Ores ores : Ores.values()) {
            if(Utils.getLevel(player) >= ores.getLevel()) {
                inventory.setItem(
                        inventory.firstEmpty(),
                        ResourceSetup.ResourceItem(ores, player));
            } else {
                inventory.setItem(
                        inventory.firstEmpty(),
                        GuiUtils.unlockableitem(ores.getLevel())
                );
            }
        }
    }

    public static void ResourceNBTCreator(Player player) {
        for(Ores ores : Ores.values()) {
            PersistentDataContainer data = player.getPersistentDataContainer();
            Boolean hasData = data.has(new NamespacedKey(EzMiner.getPlugin(), ores.name()), PersistentDataType.INTEGER);
            if(!hasData) {
                data.set(new NamespacedKey(EzMiner.getPlugin(), ores.name()), PersistentDataType.INTEGER, 0);
            }
        }
    }

    public static void ResourceGUISetup(InventoryClickEvent e, Player player) {
        for(Ores ores : Ores.values()) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(GuiUtils.nameSetup(ores))) {
                ResourceSetup.ResourceListener(player, e, ores);
            }
        }
    }

    public static void checkResources(Player player, Ores ores) {
        PersistentDataContainer data = player.getPersistentDataContainer();
        if(!(data.has(new NamespacedKey(EzMiner.getPlugin(), ores.name()), PersistentDataType.INTEGER))) {
            setupResources(player, ores, 0);
        }
    }

    public static void ResourceListener(Player player, InventoryClickEvent e, Ores ore) {
        PersistentDataContainer data = player.getPersistentDataContainer();
        if(e.isRightClick() && !(e.isShiftClick())) {
            if(!(Utils.getResources(player, ore) <= 0)) {
                if(player.getInventory().firstEmpty() != -1) {
                    ore.getItem().getItemStack().setAmount(1);
                    player.getInventory().addItem(ore.getItem().getItemStack());
                    int getAmount = Utils.getResources(player, ore);
                    data.set(new NamespacedKey(EzMiner.getPlugin(), ore.name()), PersistentDataType.INTEGER, getAmount - 1);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 5f);
                    player.sendMessage("§c-1 " + ore.getItem().getName());
                    player.openInventory(ResourcesGUI.ResourcesGUI(player));
                } else {
                    player.sendMessage("§cPlease empty your inventory first!");
                }
            } else {
                player.sendMessage("§cYou do not have enough of that resource!");
                Utils.FailedSound(player);
            }
        } if(e.isLeftClick() && !(e.isShiftClick())) {
            if(player.getInventory().containsAtLeast(ore.getItem().getItemStack(), 1)) {
                ore.getItem().getItemStack().setAmount(1);
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
                if(player.getInventory().firstEmpty() != -1) {
                    ore.getItem().getItemStack().setAmount(64);
                    player.getInventory().addItem(ore.getItem().getItemStack());
                    ore.getItem().getItemStack().setAmount(1);
                    int getAmount = Utils.getResources(player, ore);
                    data.set(new NamespacedKey(EzMiner.getPlugin(), ore.name()), PersistentDataType.INTEGER, getAmount - 64);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 5f);
                    player.sendMessage("§c-64 " + ore.getItem().getName());
                    player.openInventory(ResourcesGUI.ResourcesGUI(player));
                } else {
                    player.sendMessage("§cPlease empty your inventory first!");
                }
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
}
