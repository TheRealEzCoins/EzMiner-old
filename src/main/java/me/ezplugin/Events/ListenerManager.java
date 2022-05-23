package me.ezplugin.Events;

import me.ezplugin.EzMiner;
import me.ezplugin.GUI.ForgeGUIListener;
import me.ezplugin.GUI.PickaxeGUIListener;
import me.ezplugin.GUI.ReFuelGUIListener;
import me.ezplugin.GUI.CastingGUIListener;
import org.bukkit.event.Listener;

public class ListenerManager {

    public ListenerManager() {
        addListener(new PickaxeGUIListener());
        addListener(new ForgeGUIListener());
        addListener(new CastingGUIListener());
        addListener(new ReFuelGUIListener());
        addListener(new BreakListener());
        addListener(new OnJoin());
        addListener(new PlaceListener());

    }

    private void addListener(Listener listener) {
        EzMiner.getPluginManager().registerEvents(listener, EzMiner.getInstance());
    }

}
