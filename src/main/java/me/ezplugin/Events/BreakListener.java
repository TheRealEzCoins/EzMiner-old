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
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;


public class BreakListener implements Listener {


    @EventHandler
    public void onBlockBreak(BlockBreakEvent block) {
        Player player = block.getPlayer();
        //PersistentDataContainer DrillData = (Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getPersistentDataContainer();

        Utils.BlockSetup(block, 1, Material.IRON_ORE, ItemManager.Orichalchite,ItemManager.OrichalchitePickaxe, player, 100, 50L);
        Utils.BlockSetup(block, 5, Material.IRON_BLOCK, ItemManager.Orichalchite, ItemManager.ObsidianPickaxe, player, 150, 100L);
        /*if(DrillData.has(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER)) {
            int CurrentFuelAmount = DrillData.get(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER);
            CurrentFuelAmount++;
            DrillData.set(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER, CurrentFuelAmount);
            player.sendMessage(String.valueOf(CurrentFuelAmount));
        }*/
    }
}


