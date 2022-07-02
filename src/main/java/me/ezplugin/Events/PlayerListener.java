package me.ezplugin.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public final void onMineWithXray(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getAction().isLeftClick() && event.hasBlock()) {
            if(onEnableXray.Cooldown.containsKey(player.getUniqueId())) {
                if(onEnableXray.Cooldown.get(player.getUniqueId()) != null) {
                    long timeElapsed = System.currentTimeMillis() - onEnableXray.Cooldown.get(player.getUniqueId());
                    if (!(timeElapsed >= 9000)) {
                        event.setCancelled(true);
                        player.sendMessage("§cYou can't mine while xray is enabled!");
                    }
                }
            }
        }
    }
}
