package me.ezplugin.Events;

import me.ezplugin.EzMiner;
import me.ezplugin.Utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Date;


public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent join) {
        String user = join.getPlayer().getName();
        Player player = join.getPlayer();

        PersistentDataContainer data = player.getPersistentDataContainer();
        if(!player.hasPlayedBefore()) {
            data.set(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER, 0);
            data.set(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER, 1);
            Utils.setscore(player, 1, 0);
        } else {
            int level = player.getPersistentDataContainer().get(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER);
            int xp = player.getPersistentDataContainer().get(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER);
            Utils.setscore(player, level, xp);
        }

        join.setJoinMessage(ChatColor.AQUA + "Welcome " + ChatColor.RED + ChatColor.BOLD + user + ChatColor.AQUA + " !");
        }



}


