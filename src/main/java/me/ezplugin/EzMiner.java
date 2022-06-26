package me.ezplugin;

import me.ezplugin.Commands.Commands;
import me.ezplugin.Commands.TabCompletion;
import me.ezplugin.Events.ListenerManager;
import me.ezplugin.Items.Items.*;
import me.ezplugin.Utils.Files.StatUtils;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public final class EzMiner extends JavaPlugin implements Listener {



    public static EzMiner plugin;
    private ListenerManager listenerManager;
    private static File PlayerDataFolder;

    public static ListenerManager getListenerManager() {
        return plugin.listenerManager;
    }

    public static PluginManager getPluginManager() {
        return plugin.getServer().getPluginManager();
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


        System.out.println("Plugin has started.");
        StatUtils.startAutoSave();


        getConfig().options().copyDefaults();
        getConfig().addDefault("Level-Scaling." + "Exp", 500);
        saveDefaultConfig();

        this.listenerManager = new ListenerManager();

        this.getServer().getPluginManager().registerEvents(this, this);

        // Command Handler
        getCommand("EzMiner").setExecutor(new Commands());
        getCommand("EzMiner").setTabCompleter(new TabCompletion());


        // Item int
        OreItems.init();
        GemItems.init();
        MaterialItems.init();
        PickaxeItems.init();
        ArmorItems.init();



    }

    @Override
    public void onDisable() {
        StatUtils.save();
        System.out.println("Plugin has been disabled.");
    }



    public static File getPlayerDataFolder() {
        return PlayerDataFolder;
    }


}

