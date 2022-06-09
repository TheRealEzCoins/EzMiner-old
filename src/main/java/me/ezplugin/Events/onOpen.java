package me.ezplugin.Events;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Utils.ForgeUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.text.ParseException;

public class onOpen implements Listener {
    @EventHandler
    public static void onOpen(InventoryOpenEvent event) throws ParseException {
        String inventory = event.getView().getTitle();

        if(inventory.equalsIgnoreCase("§8Forge")) {
            for (ForgeItems items : ForgeItems.values()) {
                ForgeUtils.ForgeTimeSetup(event, items);
            }
        }

    }
}
