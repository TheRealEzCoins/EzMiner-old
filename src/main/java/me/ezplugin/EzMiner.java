package me.ezplugin;

import me.ezplugin.Commands.Commands;
import me.ezplugin.Events.ListenerManager;
import me.ezplugin.Items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


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
        System.out.println("Plugin has started.");

        getConfig().options().copyDefaults();
        getConfig().addDefault("Level-Scaling." + "Exp", 500);
        saveDefaultConfig();

        EzForagingInstalled = Bukkit.getServer().getPluginManager().isPluginEnabled("Vault");

        plugin = this;
        this.listenerManager = new ListenerManager();

        this.getServer().getPluginManager().registerEvents(this, this);

        // Command Handler
        getCommand("Pickaxe").setExecutor(new Commands());
        getCommand("Forge").setExecutor(new Commands());
        getCommand("CheckXP").setExecutor(new Commands());
        getCommand("ResetXP").setExecutor(new Commands());
        getCommand("Date").setExecutor(new Commands());
        getCommand("BreakBlock").setExecutor(new Commands());
        getCommand("CreateBlock").setExecutor(new Commands());
        getCommand("SetXP").setExecutor(new Commands());
        getCommand("Stats").setExecutor(new Commands());
        getCommand("Test").setExecutor(new Commands());
        getCommand("ResetAll").setExecutor(new Commands());


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

