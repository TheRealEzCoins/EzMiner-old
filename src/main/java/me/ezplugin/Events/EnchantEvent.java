package me.ezplugin.Events;

import me.ezplugin.EzMiner;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;


public class EnchantEvent implements Listener {
    @EventHandler
    public static void enchantItem(EnchantItemEvent event) {
        ItemStack item = event.getItem();
        Player player = event.getEnchanter();
        if(item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Rarity"), PersistentDataType.STRING)) {
            event.setCancelled(true);
            player.sendMessage("§cYou can not enchant this item!");


        }
    }

    @EventHandler
    public final void anvilItem(PrepareAnvilEvent event) {
        if(event.getResult() != null) {
            ItemStack item = event.getResult();
            boolean isUnbreakable = Objects.requireNonNull(item.getItemMeta()).isUnbreakable();
            if (isUnbreakable) {
                event.setResult(new ItemStack(Material.AIR));
            }
        }
    }

    @EventHandler
    public final void smithingTableItem(PrepareSmithingEvent event) {
        if(event.getResult() != null) {
            ItemStack item = event.getResult();
            boolean isUnbreakable = Objects.requireNonNull(item.getItemMeta()).isUnbreakable();
            if (isUnbreakable) {
                event.setResult(new ItemStack(Material.AIR));
            }
        }

    }
}
