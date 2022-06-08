package me.ezplugin.World;

import org.apache.commons.io.FileUtils;
import org.bukkit.*;

import java.io.File;
import java.io.IOException;

public class WorldCreation {

    public static World world;

    public static void createWorld() throws IOException {
        if(Bukkit.getWorld("MineWorld") == null) {
            WorldCreator w = new WorldCreator("MineWorld");
            world = w.createWorld();
            world.setGameRule(GameRule.KEEP_INVENTORY, true);
            world.setGameRule(GameRule.DO_FIRE_TICK, false);
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
