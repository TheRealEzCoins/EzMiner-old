package me.ezplugin.Events;

import me.ezplugin.EzMiner;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;


public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent join) {
        String user = join.getPlayer().getName();
        Player player = join.getPlayer();

        PersistentDataContainer data = player.getPersistentDataContainer();
        if(!player.hasPlayedBefore()) {
            data.set(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER, 0);
            data.set(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER, 1);
        }

        join.setJoinMessage(ChatColor.AQUA + "Welcome " + ChatColor.RED + ChatColor.BOLD + user + ChatColor.AQUA + " !");
        }



}


