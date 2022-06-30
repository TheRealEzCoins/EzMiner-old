package me.ezplugin.Events;

import me.ezplugin.Enums.Resources;
import me.ezplugin.Enums.ShopItems;
import me.ezplugin.Enums.Type;
import me.ezplugin.Items.Items.PickaxeItems;
import me.ezplugin.Utils.Files.PlayerData;
import me.ezplugin.Utils.Files.StatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;


public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent join) {
        Player player = join.getPlayer();
        String StringUUID = String.valueOf(player.getUniqueId());
        UUID playerUUID = player.getUniqueId();
        onEnableXray.Cooldown.remove(playerUUID);

        PlayerData.setupFile(player);
        if(!PlayerData.HasData("UUID")) {
            player.getInventory().addItem(PickaxeItems.Starter_Pickaxe.getItemStack());
            PlayerData.fileData.addDefault("UUID", StringUUID + " : " + player.getName());
            PlayerData.fileData.options().copyDefaults(true);
            PlayerData.savePlayerData();
        }

        if(!PlayerData.HasData("Stats.")) {
            PlayerData.fileData.addDefault("Stats." + "Level", 1);
            PlayerData.fileData.addDefault("Stats." + "EXP", 0);
            PlayerData.fileData.addDefault("Stats." + "Fragments", 0);
            PlayerData.fileData.options().copyDefaults(true);
            PlayerData.savePlayerData();
        }


        for(Resources ores : Resources.values()) {
            if(ores.getType().equals(Type.GEM)) {
                if (!PlayerData.HasData("Gems." + ores)) {
                    PlayerData.fileData.addDefault("Gems." + ores, 0);
                }
            }
            PlayerData.fileData.options().copyDefaults(true);
            PlayerData.savePlayerData();
        }

        for(Resources ores : Resources.values()) {
            if(ores.getType().equals(Type.ORE)) {
                if (!PlayerData.HasData("Ores." + ores)) {
                    PlayerData.fileData.addDefault("Ores." + ores, 0);
                }
            }
            PlayerData.fileData.options().copyDefaults(true);
            PlayerData.savePlayerData();
        }

        for(ShopItems items : ShopItems.values()) {
            if(items.getType().equals(Type.MATERIAL)) {
                if (!PlayerData.HasData("Materials." + items)) {
                    PlayerData.fileData.addDefault("Materials." + items, 0);
                }
            }
            PlayerData.fileData.options().copyDefaults(true);
            PlayerData.savePlayerData();
        }



        StatUtils.EXP.put(playerUUID, StatUtils.getConfigXP(player));
        StatUtils.Level.put(playerUUID, StatUtils.getConfigLevel(player));
        StatUtils.Fragments.put(playerUUID, StatUtils.getConfigFragments(player));


        if(!PlayerData.HasData("Time.")) {
            PlayerData.fileData.addDefault("Forge." + "Times", 0);
            PlayerData.fileData.options().copyDefaults(true);
            PlayerData.savePlayerData();
        }


    }


}


