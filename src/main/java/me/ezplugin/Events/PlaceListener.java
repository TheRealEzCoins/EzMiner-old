package me.ezplugin.Events;

import me.ezplugin.Enums.Resources;
import me.ezplugin.EzMiner;
import me.ezplugin.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.persistence.PersistentDataType;

public class PlaceListener implements Listener {
    @EventHandler
    public static void onItemPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if(Utils.isEmpty(player)) {
            if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Unplacable"), PersistentDataType.STRING)) {
                event.setCancelled(true);
            }
        }
    }
}
