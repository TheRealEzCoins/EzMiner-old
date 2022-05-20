package me.ezplugin.Events;

import me.ezplugin.EzMiner;
import me.ezplugin.GUI.GUIListener;
import me.ezplugin.GUI.PickaxeGUIListener;
import me.ezplugin.GUI.ReFuelGUIListener;
import me.ezplugin.GUI.SelectorGUIListener;
import org.bukkit.event.Listener;

public class ListenerManager {

    public ListenerManager() {
        addListener(new PickaxeGUIListener());
        addListener(new GUIListener());
        addListener(new SelectorGUIListener());
        addListener(new ReFuelGUIListener());
        addListener(new BreakListener());
        addListener(new OnJoin());
        addListener(new PlaceListener());

    }

    private void addListener(Listener listener) {
        EzMiner.getPluginManager().registerEvents(listener, EzMiner.getInstance());
    }

}
