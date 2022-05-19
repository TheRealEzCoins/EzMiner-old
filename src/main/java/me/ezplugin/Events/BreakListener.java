package me.ezplugin.Events;

import me.ezplugin.EzMiner;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.Utils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.RegisteredListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BreakListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent block) {
        if(block.getBlock().getType().equals(Material.BEDROCK)) {
            block.setCancelled(true);
        } else {
            Player player = block.getPlayer();
            Utils.BlockSetup(block, 1, Material.IRON_ORE, 1, ItemManager.Orichalchite, player, 100, 50L);
            Utils.BlockSetup(block, 15, Material.GREEN_STAINED_GLASS, 2, ItemManager.Gemstone, player, 250, 500L);

            if(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER)) {

            } else {
                return;
            }
        }
    }
}



