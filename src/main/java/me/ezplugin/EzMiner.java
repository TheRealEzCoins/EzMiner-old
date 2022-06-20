package me.ezplugin;

import me.ezplugin.Commands.Commands;
import me.ezplugin.Commands.TabCompletion;
import me.ezplugin.Events.ListenerManager;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.Files.StatUtils;
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
    private static File PlayerDataFolder;
    private static File PlayerData;


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

    public static EzMiner getPlugin(){
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        getDataFolder().mkdirs();

        saveConfig();

        File PlayerDataFolder = new File(getDataFolder(), "PlayerData");
        this.PlayerDataFolder = PlayerDataFolder;
        if(!PlayerDataFolder.exists()) {
            PlayerDataFolder.mkdirs();

        }



        getServer().createWorld(new WorldCreator("MiningWorld"));
        /*try {
            WorldCreation.createWorld();
        } catch (IOException e) {
            e.printStackTrace();
        }


        World source = Bukkit.getWorld("MiningWorld_Admin");
        File sourceFolder;

        {
            assert source != null;
            sourceFolder = source.getWorldFolder();
        }

        // The world to overwrite when copying
        World target = Bukkit.getWorld("MiningWorld");
        File targetFolder;

        {
            assert target != null;
            targetFolder = target.getWorldFolder();
        }



        WorldClass.copyWorld(sourceFolder, targetFolder);


         */


        Bukkit.getWorld("MiningWorld").setSpawnLocation(138, 119, 237, 180);

        System.out.println("Plugin has started.");
        StatUtils.startAutoSave();


        getConfig().options().copyDefaults();
        getConfig().addDefault("Level-Scaling." + "Exp", 500);
        saveDefaultConfig();

        EzForagingInstalled = Bukkit.getServer().getPluginManager().isPluginEnabled("Vault");

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
        StatUtils.save();
        System.out.println("Plugin has been disabled.");
    }



    public static File getPlayerDataFolder() {
        return PlayerDataFolder;
    }

    public static File getPlayerData() {
        return PlayerData;
    }


}

