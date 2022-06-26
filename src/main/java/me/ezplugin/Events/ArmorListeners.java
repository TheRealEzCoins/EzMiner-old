package me.ezplugin.Events;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import me.ezplugin.Items.Items.ArmorItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;

import java.util.Objects;

public class ArmorListeners implements Listener {
    @EventHandler
    public final void onArmorCheck(PlayerArmorChangeEvent event) {
        if(event.getSlotType().equals(PlayerArmorChangeEvent.SlotType.CHEST)) {
            if(Objects.equals(event.getNewItem(), ArmorItems.Uprum_Chestplate.getItemStack())) {
                event.getPlayer().sendMessage("Yessssss");
            }
        }
    }
}
