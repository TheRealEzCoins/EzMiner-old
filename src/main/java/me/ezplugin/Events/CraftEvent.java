package me.ezplugin.Events;

import me.ezplugin.EzMiner;
import me.ezplugin.Utils.Utils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;


public class CraftEvent implements Listener {
    @EventHandler
    public static void craftItem(CraftItemEvent event) {
        CraftingInventory inv = event.getInventory();
        for(ItemStack stack : inv.getStorageContents()) {
            if(stack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Rarity"), PersistentDataType.STRING)) {
                inv.setResult(null);
                event.setCancelled(true);
            } else {
                return;
            }
        }
    }
}
