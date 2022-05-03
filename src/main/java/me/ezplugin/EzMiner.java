package me.ezplugin;

import me.ezplugin.Commands.Commands;
import me.ezplugin.Events.BreakListener;
import me.ezplugin.Events.OnJoin;
import me.ezplugin.GUI.GUIListener;
import me.ezplugin.GUI.PickaxeGUIListener;
import me.ezplugin.GUI.StatsGUIListener;
import me.ezplugin.Items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class EzMiner extends JavaPlugin implements Listener {

    public static EzMiner plugin;

    @Override
    public void onEnable() {
        System.out.println("Plugin has started.");

        getConfig().options().copyDefaults();
        getConfig().addDefault("Level-Scaling." + "Exp", 500);
        saveDefaultConfig();

        plugin = this;

        // Event Handler
        Bukkit.getPluginManager().registerEvents(new OnJoin(), this);
        Bukkit.getPluginManager().registerEvents(new BreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new PickaxeGUIListener(), this);
        Bukkit.getPluginManager().registerEvents(new GUIListener(), this);
        Bukkit.getPluginManager().registerEvents(new StatsGUIListener(), this);
        this.getServer().getPluginManager().registerEvents(this, this);

        // Command Handler
        getCommand("Pickaxe").setExecutor(new Commands());
        getCommand("Forge").setExecutor(new Commands());
        getCommand("CheckXP").setExecutor(new Commands());
        getCommand("ResetXP").setExecutor(new Commands());
        getCommand("Date").setExecutor(new Commands());

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

