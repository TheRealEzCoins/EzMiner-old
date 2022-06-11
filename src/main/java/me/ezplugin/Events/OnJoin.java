package me.ezplugin.Events;

import me.ezplugin.Enums.Ores;
import me.ezplugin.Enums.Type;
import me.ezplugin.Utils.Stats.PlayerDataStuff;
import me.ezplugin.Utils.ResourceSetup;
import me.ezplugin.Utils.Stats.StatUtils;
import me.ezplugin.Utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;
import java.util.UUID;


public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent join) {
        String user = join.getPlayer().getName();
        Player player = join.getPlayer();
        String StringUUID = String.valueOf(player.getUniqueId());
        UUID playerUUID = player.getUniqueId();

        PlayerDataStuff.setupFile(player);
        if(!PlayerDataStuff.HasData("UUID")) {
            PlayerDataStuff.fileData.addDefault("UUID", StringUUID + " : " + player.getName());
            PlayerDataStuff.fileData.options().copyDefaults(true);
            PlayerDataStuff.savePlayerData();
        }

        if(!PlayerDataStuff.HasData("Stats.")) {
            PlayerDataStuff.fileData.addDefault("Stats." + "Level", 1);
            PlayerDataStuff.fileData.addDefault("Stats." + "EXP", 0);
            PlayerDataStuff.fileData.options().copyDefaults(true);
            PlayerDataStuff.savePlayerData();
        }

        if(!PlayerDataStuff.HasData("Ores.")) {
            for(Ores ores : Ores.values())
                if(ores.getType().equals(Type.ORE)) {
                    PlayerDataStuff.fileData.addDefault("Ores." + ores, 0);
                }
            PlayerDataStuff.fileData.options().copyDefaults(true);
            PlayerDataStuff.savePlayerData();
        }

        if(!PlayerDataStuff.HasData("Gems.")) {
            for(Ores ores : Ores.values())
                if(ores.getType().equals(Type.GEM)) {
                    PlayerDataStuff.fileData.addDefault("Gems." + ores, 0);
                }
            PlayerDataStuff.fileData.options().copyDefaults(true);
            PlayerDataStuff.savePlayerData();
        }


        StatUtils.EXP.put(playerUUID, StatUtils.getConfigXP(player));
        StatUtils.Level.put(playerUUID, StatUtils.getConfigLevel(player));






        join.setJoinMessage(ChatColor.AQUA + "Welcome " + ChatColor.RED + ChatColor.BOLD + user + ChatColor.AQUA + " !");
    }


}


