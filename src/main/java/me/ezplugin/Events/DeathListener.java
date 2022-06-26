package me.ezplugin.Events;

import com.jeff_media.morepersistentdatatypes.DataType;
import me.ezplugin.EzMiner;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DeathListener implements Listener {
    @EventHandler
    public final void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        for(ItemStack item : player.getInventory().getContents()) {
            if(item != null) {
                if (item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Pickaxe"), DataType.BOOLEAN)) {
                    event.getDrops().remove(item);
                    event.getItemsToKeep().add(item);
                }
            }
        }
    }
}
