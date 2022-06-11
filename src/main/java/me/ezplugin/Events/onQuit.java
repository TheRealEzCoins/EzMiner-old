package me.ezplugin.Events;

import me.ezplugin.Utils.Stats.StatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class onQuit implements Listener {
    @EventHandler
    public static void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        StatUtils.setConfigXP(player, StatUtils.getHashXP(player));
        StatUtils.setConfigLevel(player, StatUtils.getHashLevel(player));
    }
}
