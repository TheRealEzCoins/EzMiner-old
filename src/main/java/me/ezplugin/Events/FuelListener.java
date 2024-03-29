package me.ezplugin.Events;

import me.ezplugin.EzMiner;
import me.ezplugin.Utils.Utils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class FuelListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getAction() == InventoryAction.SWAP_WITH_CURSOR) {
            ItemStack currentItem = event.getCurrentItem();
            ItemStack cursorItem = event.getCursor();
            ItemMeta currentItemItemMeta = currentItem.getItemMeta();
            PersistentDataContainer currentItemData = event.getCurrentItem().getItemMeta().getPersistentDataContainer();
            PersistentDataContainer currentCursorData = event.getCursor().getItemMeta().getPersistentDataContainer();
            if(currentItemData.has(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER) && currentCursorData.has(new NamespacedKey(EzMiner.getPlugin(), "reFuel"), PersistentDataType.INTEGER)) {
                PersistentDataContainer itemdata = currentItemItemMeta.getPersistentDataContainer();
                int FuelAmount = itemdata.get(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER);
                event.setCancelled(true);
                if(!(FuelAmount >= 1000)) {
                    int Calculations = 1000;

                    itemdata.set(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER, Calculations);

                    List<String> lore = currentItemItemMeta.getLore();

                    int getIndex = lore.indexOf("§fFuel: " + "§b" + FuelAmount);
                    lore.set(getIndex, "§fFuel: " + "§b" + Calculations);

                    currentItemItemMeta.setLore(lore);
                    currentItem.setItemMeta(currentItemItemMeta);
                    assert cursorItem != null;
                    cursorItem.setAmount(cursorItem.getAmount() - 1);
                    player.updateInventory();
                    player.sendMessage("§aRefueled!");
                    event.setCancelled(true);
                    player.playSound(player.getLocation(), Sound.ITEM_BUCKET_FILL, 1f, -1f);
                } else {
                    event.setCancelled(true);
                    player.sendMessage("§cThis item has already reached max fuel!");
                    Utils.FailedSound(player);
                }
            }
            if(currentItemData.has(new NamespacedKey(EzMiner.getPlugin(), "Fortune"), PersistentDataType.INTEGER) && currentCursorData.has(new NamespacedKey(EzMiner.getPlugin(), "addFortune"), PersistentDataType.INTEGER)) {
                int getAddedFortune = currentCursorData.get(new NamespacedKey(EzMiner.getPlugin(), "addFortune"), PersistentDataType.INTEGER);
                int getFortune = currentItemData.get(new NamespacedKey(EzMiner.getPlugin(), "Fortune"), PersistentDataType.INTEGER);
                ItemMeta currentItemMeta = event.getCurrentItem().getItemMeta();
                currentItemMeta.getPersistentDataContainer().set(new NamespacedKey(EzMiner.getPlugin(), "Fortune"), PersistentDataType.INTEGER, getFortune + getAddedFortune);

                List<String> lore = currentItemMeta.getLore();

                int getIndex = lore.indexOf("§eFortune " + getFortune + "☘");
                int totalfortune = getFortune + getAddedFortune;
                lore.set(getIndex, "§eFortune " + totalfortune + "☘");
                currentItemMeta.setLore(lore);
                currentItem.setItemMeta(currentItemMeta);

                assert cursorItem != null;
                cursorItem.setAmount(cursorItem.getAmount() - 1);

                event.setCancelled(true);
                player.updateInventory();
                player.sendMessage("§aAdded fortune!!");
            }
        }
    }
}
