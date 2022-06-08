package me.ezplugin.Events;

import me.ezplugin.Enums.Ores;
import me.ezplugin.Utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent join) {
        String user = join.getPlayer().getName();
        Player player = join.getPlayer();

        if(!player.hasPlayedBefore()) {
            Utils.setXP(player, 0);
            Utils.setLevel(player, 1);
            Utils.setupResources(player, Ores.Gemstone_1, 0);
            Utils.setupResources(player, Ores.Orichalchite, 0);
        }

        join.setJoinMessage(ChatColor.AQUA + "Welcome " + ChatColor.RED + ChatColor.BOLD + user + ChatColor.AQUA + " !");
        }

}


