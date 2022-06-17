package me.ezplugin.World;

import org.apache.commons.io.FileUtils;
import org.bukkit.*;

import java.io.File;
import java.io.IOException;

public class WorldCreation {

    public static World world;

    public static void createWorld() throws IOException {
        if(Bukkit.getWorld("MiningWorld") == null) {
            WorldCreator w = new WorldCreator("MiningWorld");

            world = w.createWorld();
            world.setGameRule(GameRule.DO_FIRE_TICK, false);
            world.setGameRule(GameRule.KEEP_INVENTORY, true);
            world.setSpawnLocation(0, 120, 0);
            WorldBorder worldBorder = world.getWorldBorder();
            worldBorder.setCenter(0, 0);
            worldBorder.setSize(2500);

        }
    }

    public static void DeleteWorld() throws IOException {
        if(Bukkit.getWorld("MineWorld") != null) {
            Bukkit.unloadWorld("MineWorld", false);
            World thisWorld = Bukkit.getWorld("MineWorld");
            assert thisWorld != null;
            FileUtils.deleteDirectory(new File("MineWorld"));


        }
    }



}
