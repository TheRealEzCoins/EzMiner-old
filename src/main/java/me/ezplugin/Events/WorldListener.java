package me.ezplugin.Events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class WorldListener implements Listener {
    @EventHandler
    public static void onExitWorld(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        World ExitWorld = event.getFrom();
        World world = player.getWorld();

        if(world.equals(Bukkit.getWorld("MiningWorld_Main"))) {
            player.sendMessage("§c§lYou are entering the main MineWorld!!!!");
        }

        if(world.equals(Bukkit.getWorld("MineWorld"))) {
            player.setGameMode(GameMode.ADVENTURE);
        }

        if(ExitWorld.equals(Bukkit.getWorld("MineWorld"))) {
            player.setGameMode(GameMode.SURVIVAL);
        }

    }
}