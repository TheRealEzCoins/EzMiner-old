package me.ezplugin.Utils;

import me.ezplugin.Enums.Ores;
import me.ezplugin.Enums.Type;
import me.ezplugin.EzMiner;
import me.ezplugin.GUI.GUIS.GemsGUI;
import me.ezplugin.GUI.GUIS.ResourcesGUI;
import me.ezplugin.Utils.Stats.StatUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static me.ezplugin.Utils.ItemUtils.customItemUsingStack;;

public class ResourceSetup {

    public static ItemStack ResourceItem(Ores ores, Player player) {
        int amount = StatUtils.getResources(player, ores);

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


    /**
     * It loops through all the ores, checks if the player has the required level to unlock the ore, and if so, adds the
     * ore to the inventory
     *
     * @param player The player who is opening the inventory
     * @param inventory The inventory you want to add the items to.
     */
    public static void ResourceCreation(Player player , Inventory inventory) {
        for(Ores ores : Ores.values()) {
            if (ores.getType().equals(Type.ORE)) {
                if (StatUtils.getHashLevel(player) >= ores.getLevel()) {
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
    }

    /**
     * It checks if the player has the required level to unlock the item, if they do, it adds the item to the inventory, if
     * they don't, it adds a placeholder item
     *
     * @param player The player who is viewing the inventory
     * @param inventory The inventory you want to add the items to.
     */
    public static void GemCreation(Player player , Inventory inventory) {
        for(Ores ores : Ores.values()) {
            if (ores.getType().equals(Type.GEM)) {
                if (StatUtils.getHashLevel(player) >= ores.getLevel()) {
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
    }


    public static void ResourceGUISetup(InventoryClickEvent e, Player player) {
        for(Ores ores : Ores.values()) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(GuiUtils.nameSetup(ores))) {
                ResourceSetup.ResourceListener(player, e, ores);
            }
        }
    }


    /**
     * It's a function that allows you to add and remove items from your inventory and the database
     *
     * @param player The player who is interacting with the inventory
     * @param e InventoryClickEvent
     * @param ore The ore you want to use.
     */
    public static void ResourceListener(Player player, InventoryClickEvent e, Ores ore) {
        if(e.isRightClick() && !(e.isShiftClick())) {
            if(!(StatUtils.getResources(player, ore) <= 0)) {
                if(player.getInventory().firstEmpty() != -1) {
                    ore.getItem().getItemStack().setAmount(1);
                    player.getInventory().addItem(ore.getItem().getItemStack());
                    int getAmount = StatUtils.getResources(player, ore);
                    StatUtils.setResources(player, ore, getAmount - 1);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 5f);
                    player.sendMessage("§c-1 " + ore.getItem().getName());
                    if(ore.getType().equals(Type.ORE)) {
                        player.openInventory(ResourcesGUI.ResourcesGUI(player));
                    } else {
                        player.openInventory(GemsGUI.GemGUI(player));
                    }
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
                int getAmount = StatUtils.getResources(player, ore);
                StatUtils.setResources(player, ore, getAmount + 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 5f);
                player.sendMessage("§c+1 " + ore.getItem().getName());
                if(ore.getType().equals(Type.ORE)) {
                    player.openInventory(ResourcesGUI.ResourcesGUI(player));
                } else {
                    player.openInventory(GemsGUI.GemGUI(player));
                }

            } else {
                player.sendMessage("§cYou do not have enough of that resource in your inventory!");
                Utils.FailedSound(player);
            }
        } if(e.isShiftClick() && e.isRightClick()) {
            if (!(StatUtils.getResources(player, ore) < 64)) {
                if(player.getInventory().firstEmpty() != -1) {
                    ore.getItem().getItemStack().setAmount(64);
                    player.getInventory().addItem(ore.getItem().getItemStack());
                    ore.getItem().getItemStack().setAmount(1);
                    int getAmount = StatUtils.getResources(player, ore);
                    StatUtils.setResources(player, ore, getAmount - 64);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 5f);
                    player.sendMessage("§c-64 " + ore.getItem().getName());
                    if(ore.getType().equals(Type.ORE)) {
                        player.openInventory(ResourcesGUI.ResourcesGUI(player));
                    } else {
                        player.openInventory(GemsGUI.GemGUI(player));
                    }
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

                int getAmount = StatUtils.getResources(player, ore);
                StatUtils.setResources(player, ore, getAmount + amount);
                player.sendMessage("§c+" + amount + " " + ore.getItem().getName());
                if(ore.getType().equals(Type.ORE)) {
                    player.openInventory(ResourcesGUI.ResourcesGUI(player));
                } else {
                    player.openInventory(GemsGUI.GemGUI(player));
                }

            } else {
                player.sendMessage("§cYou do not have enough of that resource!");
                Utils.FailedSound(player);
            }
        }
    }
}
