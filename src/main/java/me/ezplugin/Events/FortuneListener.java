package me.ezplugin.Events;

import me.ezplugin.EzMiner;
import org.bukkit.NamespacedKey;
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

public class FortuneListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getAction() == InventoryAction.SWAP_WITH_CURSOR) {
            ItemStack currentItem = event.getCurrentItem();
            ItemStack cursorItem = event.getCursor();
            PersistentDataContainer currentItemData = event.getCurrentItem().getItemMeta().getPersistentDataContainer();
            PersistentDataContainer currentCursorData = event.getCursor().getItemMeta().getPersistentDataContainer();
            if (currentItemData.has(new NamespacedKey(EzMiner.getPlugin(), "Fortune"), PersistentDataType.INTEGER) && currentCursorData.has(new NamespacedKey(EzMiner.getPlugin(), "addFortune"), PersistentDataType.INTEGER)) {
                int getAddedFortune = currentCursorData.get(new NamespacedKey(EzMiner.getPlugin(), "addFortune"), PersistentDataType.INTEGER);
                int getFortune = currentItemData.get(new NamespacedKey(EzMiner.getPlugin(), "Fortune"), PersistentDataType.INTEGER);
                ItemMeta currentItemMeta = event.getCurrentItem().getItemMeta();
                currentItemMeta.getPersistentDataContainer().set(new NamespacedKey(EzMiner.getPlugin(), "Fortune"), PersistentDataType.INTEGER, getFortune + getAddedFortune);

                List<String> lore = currentItemMeta.getLore();

                assert lore != null;
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
