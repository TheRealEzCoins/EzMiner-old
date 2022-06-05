package me.ezplugin.Utils;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.EzMiner;
import me.ezplugin.Items.ItemCreator;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.ParseException;
import java.util.*;

public class newForgeUtils {
    public static void ForgeSetup(Player player, ForgeItems forgeItems, String key) {

        LinkedHashSet<ItemStack> forgeitemlist = new LinkedHashSet<>();
        ItemStack[] items = forgeItems.getRecipe();
        for (ItemStack stack : items) {
            forgeitemlist.add(stack);
        }

        LinkedHashSet<ItemStack> inventory = new LinkedHashSet<>();
        ItemStack[] inventoryitems = player.getInventory().getContents();
        for(ItemStack stack : inventoryitems) {
            inventory.add(stack);

        }

        PersistentDataContainer dataContainer = player.getPersistentDataContainer();
        int Level = dataContainer.get(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER);

        if(dataContainer.has(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING)) {
            player.sendMessage("§cYou're already crafting an item!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
            return;
        }
        if(Level >= forgeItems.getLevel()) {
                if (inventory.containsAll(forgeitemlist)) {
                    for (ItemStack stack : player.getInventory().getContents()) {
                        if (stack != null) {
                                player.sendMessage("Teee");
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(Utils.getTime());
                                cal.add(Calendar.SECOND, forgeItems.getTime());
                                String time = Utils.formatter.format(cal.getTime());
                                dataContainer.set(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING, time);


                                for (int i = 0; i < forgeItems.getRecipe().length; i++) {
                                        player.getInventory().removeItem(forgeItems.getRecipe());
                                        int Amounts = forgeItems.getRecipe()[i].getAmount();
                                        ItemStack itemname = forgeItems.getRecipe()[i];
                                        player.sendMessage("" + itemname + Amounts);

                                }

                                player.sendMessage("§7Crafting: \n§8- " + forgeItems.getOuput().getName() + "§b " + Utils.TimeSetup(forgeItems.getTime()));
                                Utils.SoundSetup(player, Sound.BLOCK_LAVA_POP, 1, 10);
                                Utils.SoundSetup(player, Sound.BLOCK_FIRE_EXTINGUISH, 1, 10);

                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1f, 1f);
                                        player.sendMessage("§aYour item finished crafting!");
                                    }
                                }.runTaskLater(EzMiner.getPlugin(), (forgeItems.getTime()) * 20L);
                                break;

                        }
                    }


                } else {
                    Utils.FailedSound(player);
                    player.sendMessage("§cYou are missing the ingredients to make this item!");
                }
        }else{
            Utils.FailedSound(player);
            player.sendMessage("§cYou need to be level " + forgeItems.getLevel() + " to forge this item.");
        }
    }

    public static void ForgeTimeSetup(InventoryOpenEvent openEvent, ItemCreator Craftable, String key) throws ParseException {

        if (!openEvent.getView().getTitle().equalsIgnoreCase("Forge"))
            return;

        Player player = (Player) openEvent.getPlayer();
        if(!player.getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING))
            return;
        PersistentDataContainer dataContainer = player.getPersistentDataContainer();
        Date forgedate = Utils.formatter.parse(dataContainer.get(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING));

        if (Utils.getTime().after(forgedate)) {
            player.sendMessage("§a§lWhile you were gone, an item finished crafting!");
            Utils.SoundSetup(player, Sound.ENTITY_ITEM_PICKUP, 1, -10);
            Utils.SoundSetup(player, Sound.ENTITY_PLAYER_LEVELUP, 1, -10);
            dataContainer.remove(new NamespacedKey(EzMiner.getPlugin(), key));
            player.getInventory().addItem(Craftable.getItemStack());
        }
    }



}


