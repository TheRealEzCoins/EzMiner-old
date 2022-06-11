package me.ezplugin.Utils.Stats;

import me.ezplugin.EzMiner;
import me.ezplugin.Utils.ResourceSetup;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import static me.ezplugin.EzMiner.plugin;

public class PlayerDataStuff {

    public static HashMap<UUID, Integer> StatsHash = new HashMap<>();

    public static FileConfiguration fileData;
    public static File PlayerData;
    public static void setupFile(Player player) {
            UUID playerUUID = player.getUniqueId();

            PlayerData = new File(EzMiner.getPlayerDataFolder(), playerUUID + ".yml");


            if(!PlayerData.exists()) {
                try{
                    PlayerData.createNewFile();
                } catch(IOException e) {

                }
            }
        fileData = YamlConfiguration.loadConfiguration(PlayerData);

    }



            public static FileConfiguration getPlayerData() {
            return fileData;
        }

        public static void savePlayerData() {
            try{
                fileData.save(PlayerData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void reloadPlayerData() {
            fileData = YamlConfiguration.loadConfiguration(PlayerData);
        }

        public static boolean HasData(String Path) {
            return fileData.contains(Path);
        }


}
