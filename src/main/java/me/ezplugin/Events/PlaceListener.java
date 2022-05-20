package me.ezplugin.Events;

import me.ezplugin.EzMiner;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.persistence.PersistentDataType;

public class PlaceListener implements Listener {
    @EventHandler
    public static void onItemPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Unplacable"), PersistentDataType.STRING)) {
            event.setCancelled(true);
        } else {
            return;
        }
    }
}
