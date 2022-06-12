package me.ezplugin.Events;

import me.ezplugin.Enums.Ores;
import me.ezplugin.Enums.Type;
import me.ezplugin.Utils.Stats.PlayerData;
import me.ezplugin.Utils.Stats.StatUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;


public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent join) {
        String user = join.getPlayer().getName();
        Player player = join.getPlayer();
        String StringUUID = String.valueOf(player.getUniqueId());
        UUID playerUUID = player.getUniqueId();

        PlayerData.setupFile(player);
        if(!PlayerData.HasData("UUID")) {
            PlayerData.fileData.addDefault("UUID", StringUUID + " : " + player.getName());
            PlayerData.fileData.options().copyDefaults(true);
            PlayerData.savePlayerData();
        }

        if(!PlayerData.HasData("Stats.")) {
            PlayerData.fileData.addDefault("Stats." + "Level", 1);
            PlayerData.fileData.addDefault("Stats." + "EXP", 0);
            PlayerData.fileData.options().copyDefaults(true);
            PlayerData.savePlayerData();
        }

        if(!PlayerData.HasData("Ores.")) {
            for(Ores ores : Ores.values())
                if(ores.getType().equals(Type.ORE)) {
                    PlayerData.fileData.addDefault("Ores." + ores, 0);
                }
            PlayerData.fileData.options().copyDefaults(true);
            PlayerData.savePlayerData();
        }

        if(!PlayerData.HasData("Gems.")) {
            for(Ores ores : Ores.values())
                if(ores.getType().equals(Type.GEM)) {
                    PlayerData.fileData.addDefault("Gems." + ores, 0);
                }
            PlayerData.fileData.options().copyDefaults(true);
            PlayerData.savePlayerData();
        }



        StatUtils.EXP.put(playerUUID, StatUtils.getConfigXP(player));
        StatUtils.Level.put(playerUUID, StatUtils.getConfigLevel(player));


        if(!PlayerData.HasData("Time.")) {
            PlayerData.fileData.addDefault("Forge." + "Times", 0);
            PlayerData.fileData.options().copyDefaults(true);
            PlayerData.savePlayerData();
        }



        join.setJoinMessage(ChatColor.AQUA + "Welcome " + ChatColor.RED + ChatColor.BOLD + user + ChatColor.AQUA + " !");
    }


}


