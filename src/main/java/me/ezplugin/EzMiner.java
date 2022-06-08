package me.ezplugin;

import me.ezplugin.Commands.Commands;
import me.ezplugin.Commands.TabCompletion;
import me.ezplugin.Events.ListenerManager;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.World.WorldClass;
import me.ezplugin.World.WorldCreation;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public final class EzMiner extends JavaPlugin implements Listener {

    public static EzMiner plugin;
    private ListenerManager listenerManager;

    public static ListenerManager getListenerManager() {
        return plugin.listenerManager;
    }

    private static boolean EzForagingInstalled;
    public static boolean isEzForagingInstalled() {
        return EzForagingInstalled;
    }

    public static PluginManager getPluginManager() {
        return plugin.getServer().getPluginManager();
    }



    public static EzMiner getInstance() {
        return plugin;
    }

    @Override
    public void onEnable() {

        getServer().createWorld(new WorldCreator("MiningWorld_Main"));
        try {
            WorldCreation.createWorld();
        } catch (IOException e) {
            e.printStackTrace();
        }


        World source = Bukkit.getWorld("MiningWorld_Main");
        File sourceFolder;

        {
            assert source != null;
            sourceFolder = source.getWorldFolder();
        }

        // The world to overwrite when copying
        World target = Bukkit.getWorld("MineWorld");
        File targetFolder;

        {
            assert target != null;
            targetFolder = target.getWorldFolder();
        }



        WorldClass.copyWorld(sourceFolder, targetFolder);
        Bukkit.getWorld("MineWorld").setSpawnLocation(138, 119, 237, 180);
        Bukkit.getWorld("MiningWorld_Main").setSpawnLocation(138, 119, 237, 180);



        System.out.println("Plugin has started.");

        getConfig().options().copyDefaults();
        getConfig().addDefault("Level-Scaling." + "Exp", 500);
        saveDefaultConfig();

        EzForagingInstalled = Bukkit.getServer().getPluginManager().isPluginEnabled("Vault");

        plugin = this;
        this.listenerManager = new ListenerManager();

        this.getServer().getPluginManager().registerEvents(this, this);

        // Command Handler
        getCommand("EzMiner").setExecutor(new Commands());
        getCommand("EzMiner").setTabCompleter(new TabCompletion());


        // Item int
        ItemManager.init();



    }

    @Override
    public void onDisable() {
        System.out.println("Plugin has been disabled.");
    }


    public static EzMiner getPlugin(){
        return plugin;
    }


}

