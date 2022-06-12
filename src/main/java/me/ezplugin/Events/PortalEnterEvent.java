package me.ezplugin.Events;

import org.bukkit.Bukkit;
import org.bukkit.PortalType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.Objects;

public class PortalEnterEvent implements Listener {
    @EventHandler
    public void onNetherPortalEnter(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        if(player.getWorld().equals(Bukkit.getWorld("MiningWorld_Main")) || player.getWorld().equals(Bukkit.getWorld("MineWorld"))) {
            if (event.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)) {
                if(!(player.getBedSpawnLocation() == null)) {
                    player.teleport(Objects.requireNonNull(player.getBedSpawnLocation()));
                } else {
                    player.sendMessage("§cPlease set a respawn point before using this!");
                }
                event.setCancelled(true);
            }
        }

    }
}
