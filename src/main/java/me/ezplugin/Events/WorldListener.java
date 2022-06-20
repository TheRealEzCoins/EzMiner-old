package me.ezplugin.Events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.WorldUnloadEvent;

public class WorldListener implements Listener {
    @EventHandler
    public static void onExitWorld(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        World ExitWorld = event.getFrom();
        World world = player.getWorld();

        if(world.equals(Bukkit.getWorld("MineWorld"))) {

        }
    }
    @EventHandler
    public final void onChunkUnload(ChunkUnloadEvent event) {
        if(event.getWorld().equals(Bukkit.getWorld("MiningWorld"))) {
            event.setSaveChunk(false);
        }
    }

}
