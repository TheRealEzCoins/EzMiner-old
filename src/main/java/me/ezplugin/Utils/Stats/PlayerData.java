package me.ezplugin.Utils.Stats;

import me.ezplugin.EzMiner;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class PlayerData {


    public static FileConfiguration fileData;
    public static File PlayerData;
    /**
     * It creates a file for the player if it doesn't exist
     *
     * @param player The player that is being setup.
     */
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

        public static void savePlayerData() {
            try{
                fileData.save(PlayerData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static boolean HasData(String Path) {
            return fileData.contains(Path);
        }


}
