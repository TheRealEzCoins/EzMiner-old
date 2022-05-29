package me.ezplugin.Events;

import me.ezplugin.Utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent join) {
        String user = join.getPlayer().getName();
        Player player = join.getPlayer();

        if(!player.hasPlayedBefore()) {
            Utils.setXP(player, 0);
            Utils.setLevel(player, 0);
            Utils.setscore(player, 1, 0);
        } else {
            int level = Utils.getLevel(player);
            int xp = Utils.getXP(player);
            Utils.setscore(player, level, xp);
        }

        join.setJoinMessage(ChatColor.AQUA + "Welcome " + ChatColor.RED + ChatColor.BOLD + user + ChatColor.AQUA + " !");
        }

}


