package me.ezplugin.Utils;

import me.ezplugin.EzMiner;
import me.ezplugin.Items.ItemCreator;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class ForgeUtils {

    public static void ForgeSetup(Player player, int LevelReq , ItemCreator Craftable, Material Item1, Integer Amount1, Integer CraftingTime, String key) {

        PersistentDataContainer dataContainer = player.getPersistentDataContainer();
        int Level = dataContainer.get(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER);

        if(dataContainer.has(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING)) {
            player.sendMessage("§cYou're already crafting an item!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
            return;
        }
        if(Level >= LevelReq) {
            if (player.getInventory().contains(Item1, Amount1)) {
                for (ItemStack stack : player.getInventory().getContents()) {
                    if (stack != null) {
                        if (stack.getType() == Item1 && stack.getAmount() >= Amount1) {
                            int newStack = stack.getAmount() - Amount1;
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(Utils.getTime());
                            cal.add(Calendar.SECOND, CraftingTime);
                            String time = Utils.formatter.format(cal.getTime());
                            dataContainer.set(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING, time);

                            stack.setAmount(newStack);
                            player.sendMessage("§7Crafting: \n§8- " + Craftable.getName() + "§b " + Utils.TimeSetup(CraftingTime));
                            Utils.SoundSetup(player, Sound.BLOCK_LAVA_POP, 1, 10);
                            Utils.SoundSetup(player, Sound.BLOCK_FIRE_EXTINGUISH, 1, 10);

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1f, 1f);
                                    player.sendMessage("§aYour item finished crafting!");
                                }
                            }.runTaskLater(EzMiner.getPlugin(), CraftingTime * 20);
                            break;
                        }
                    }
                }


            } else {
                Utils.FailedSound(player);
                player.sendMessage("§cYou are missing the ingredients to make this item!");
            }
        } else {
            Utils.FailedSound(player);
            player.sendMessage("§cYou need to be level " + LevelReq + " to forge this item.");
        }
    }

    public static void CustomForgeSetup(Player player, int LevelReq , ItemCreator Craftable, ItemCreator ore, Integer OreAmount, Integer CraftingTime, String key) throws ParseException {

        PersistentDataContainer dataContainer = player.getPersistentDataContainer();
        PersistentDataContainer ItemContainer = ore.getItemStack().getItemMeta().getPersistentDataContainer();
        int Level = dataContainer.get(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER);

        if(dataContainer.has(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING)) {
            player.sendMessage("§cYou're already crafting an item!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
            return;
        }
        if(Level >= LevelReq) {
            if (player.getInventory().contains(ore.getType(), OreAmount)) {
                if (ItemContainer.has(new NamespacedKey(EzMiner.getPlugin(), "Ore"), PersistentDataType.STRING)) return;
                    for (ItemStack stack : player.getInventory().getContents()) {
                        if (stack != null) return;
                        if (stack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Ore"), PersistentDataType.STRING) == ore.getItemStack().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Ore"), PersistentDataType.STRING) && stack.getAmount() >= OreAmount) {
                            int newStack = stack.getAmount() - OreAmount;
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(Utils.getTime());
                            cal.add(Calendar.SECOND, CraftingTime);
                            String time = Utils.formatter.format(cal.getTime());
                            dataContainer.set(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING, time);

                            stack.setAmount(newStack);
                            player.sendMessage("§7Crafting: \n§8- " + Craftable.getName() + "§b " + Utils.TimeSetup(CraftingTime));
                            Utils.SoundSetup(player, Sound.BLOCK_LAVA_POP, 1, 10);
                            Utils.SoundSetup(player, Sound.BLOCK_FIRE_EXTINGUISH, 1, 10);

                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1f, 1f);
                                        player.sendMessage("§aYour item finished crafting!");
                                    }
                                }.runTaskLater(EzMiner.getPlugin(), CraftingTime * 20);
                                break;
                            }

                    }

            } else {
                Utils.FailedSound(player);
                player.sendMessage("§cYou are missing the ingredients to make this item!");
            }
        } else {
            Utils.FailedSound(player);
            player.sendMessage("§cYou need to be level " + LevelReq + " to forge this item.");
        }
    }



    private static ItemStack customForgeBuilder(ItemStack craftable, String displayName, String forgeLore) {
        ItemStack item = new ItemStack(craftable);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(forgeLore));
        item.setItemMeta(meta);
        return item;
    }
}
