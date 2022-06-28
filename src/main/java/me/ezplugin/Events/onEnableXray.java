package me.ezplugin.Events;

import me.ezplugin.EzMiner;
import me.ezplugin.Items.Items.PickaxeItems;
import me.ezplugin.Utils.Utils;
import me.ezplugin.Utils.replaceBlocks;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Shulker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.UUID;

public class onEnableXray implements Listener {
    public static HashMap<UUID, Long> Cooldown = new HashMap<>();
    @EventHandler
    public void onActivate(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if(!Cooldown.containsKey(player.getUniqueId())) {
            Cooldown.put(player.getUniqueId(), System.currentTimeMillis());
            long timeElapsed = System.currentTimeMillis() - Cooldown.get(player.getUniqueId());

            if (Utils.isEmpty(player)) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Pickaxe"))) {
                    if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                        e.setCancelled(true);
                        replaceBlocks.getBlocks(e.getPlayer(), 10);
                        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 10.0F, 0.0F);
                    } else if (timeElapsed >= 10000) {
                        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                            Cooldown.remove(player.getUniqueId());
                            replaceBlocks.getBlocks(e.getPlayer(), 10);
                            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 10.0F, 0.0F);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }
}