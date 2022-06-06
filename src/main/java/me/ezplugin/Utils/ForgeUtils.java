package me.ezplugin.Utils;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.EzMiner;
import me.ezplugin.Items.ItemCreator;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.ParseException;
import java.util.*;

public class ForgeUtils {
    public static void ForgeSetup(Player player ,ForgeItems forgeItems) {
        PersistentDataContainer dataContainer = player.getPersistentDataContainer();


        Calendar cal = Calendar.getInstance();
        cal.setTime(Utils.getTime());
        cal.add(Calendar.SECOND, forgeItems.getTime());
        String time = Utils.formatter.format(cal.getTime());
        dataContainer.set(new NamespacedKey(EzMiner.getPlugin(), forgeItems.name()), PersistentDataType.STRING, time);


        player.sendMessage("§7Crafting: \n§8- " + forgeItems.getOuput().getName() + "§b " + Utils.TimeSetup(forgeItems.getTime()));
        Utils.SoundSetup(player, Sound.BLOCK_LAVA_POP, 1, 10);
        Utils.SoundSetup(player, Sound.BLOCK_FIRE_EXTINGUISH, 1, 10);

        new BukkitRunnable() {
            @Override
            public void run() {
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1f, 1f);
                player.sendMessage("§aYour item finished crafting!");
            }
        }.runTaskLater(EzMiner.getPlugin(), (forgeItems.getTime()) * 20L);
    }

    public static void ForgeTimeSetup(InventoryOpenEvent openEvent, ItemCreator Craftable, ForgeItems forgeItems) throws ParseException {

        if (!openEvent.getView().getTitle().equalsIgnoreCase("§8Forge"))
            return;

        Player player = (Player) openEvent.getPlayer();
        if(!player.getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), forgeItems.name()), PersistentDataType.STRING))
            return;
        PersistentDataContainer dataContainer = player.getPersistentDataContainer();
        Date forgedate = Utils.formatter.parse(dataContainer.get(new NamespacedKey(EzMiner.getPlugin(), forgeItems.name()), PersistentDataType.STRING));

        if (Utils.getTime().after(forgedate)) {
            player.sendMessage("§a§lWhile you were gone, an item finished crafting!");
            Utils.SoundSetup(player, Sound.ENTITY_ITEM_PICKUP, 1, -10);
            Utils.SoundSetup(player, Sound.ENTITY_PLAYER_LEVELUP, 1, -10);
            dataContainer.remove(new NamespacedKey(EzMiner.getPlugin(), forgeItems.name()));
            player.getInventory().addItem(Craftable.getItemStack());
        }
    }

    public static boolean checkTime(ForgeItems forgeItems, Player player) throws ParseException {
        PersistentDataContainer dataContainer = player.getPersistentDataContainer();
        if (dataContainer.has(new NamespacedKey(EzMiner.getPlugin(), forgeItems.name()), PersistentDataType.STRING)) {
                player.sendMessage("§cYou're already crafting an item!");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
                return false;

        }
        return true;
    }



}


