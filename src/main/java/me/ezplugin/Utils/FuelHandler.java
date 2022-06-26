package me.ezplugin.Utils;

import me.ezplugin.EzMiner;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class FuelHandler {

    public static void onFuelUsage(Player player) {
        ItemStack MainHand = player.getInventory().getItemInMainHand();
        ItemMeta mainHandItemMeta = MainHand.getItemMeta();
        PersistentDataContainer data = mainHandItemMeta.getPersistentDataContainer();
        int FuelAmount = data.get(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER);
        int Calculations = FuelAmount - 1;

        data.set(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER, Calculations);

        List<String> lore = mainHandItemMeta.getLore();

        int getIndex = lore.indexOf("§fFuel: " + "§b" + FuelAmount);
        lore.set(getIndex, "§fFuel: " + "§b" + Calculations);

        mainHandItemMeta.setLore(lore);
        MainHand.setItemMeta(mainHandItemMeta);
        player.updateInventory();
    }

    public static void FuelConsume(Player player, BlockBreakEvent block) {
        PersistentDataContainer pick = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer();
        ItemStack MainHand = player.getInventory().getItemInMainHand();
        int CurrentFuel = pick.get(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER);
        if (CurrentFuel > 0) {
            FuelHandler.onFuelUsage(player);
        } else if (CurrentFuel <= 0) {
            block.setCancelled(true);
            Utils.FailedSound(player);
            player.sendMessage("§cYour " + MainHand.getItemMeta().getDisplayName() + "has ran out of fuel.");
        }
    }

    public static boolean getFuel(Player player) {
        if(Utils.isEmpty(player)) {
            PersistentDataContainer data = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer();
            return data.has(new NamespacedKey(EzMiner.getPlugin(), "Fuel"), PersistentDataType.INTEGER);
        }
        return false;
    }
}
