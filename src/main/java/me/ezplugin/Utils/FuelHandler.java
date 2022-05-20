package me.ezplugin.Utils;

import me.ezplugin.EzMiner;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
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
}
