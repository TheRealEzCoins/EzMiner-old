package me.ezplugin.Utils.Files;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Resources;
import me.ezplugin.Enums.ShopItems;
import me.ezplugin.Enums.Type;
import me.ezplugin.EzMiner;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import static me.ezplugin.EzMiner.plugin;


public class StatUtils {


    public static HashMap<UUID, Integer> EXP = new HashMap<>();
    public static HashMap<UUID, Integer> Level = new HashMap<>();
    public static HashMap<UUID, Integer> MiningFortune = new HashMap<>();
    public static HashMap<UUID, Integer> Fragments = new HashMap<>();


    public static FileConfiguration CheckIfCorrect(Player player) {
        File file = new File(plugin.getDataFolder() + "/PlayerData/" + player.getUniqueId() + ".yml");
        return YamlConfiguration.loadConfiguration(file);
    }

    public static int getConfigXP(Player player) {
        FileConfiguration config = CheckIfCorrect(player);
        return (int) config.get("Stats." + "EXP");
    }

    public static int getConfigLevel(Player player) {
        FileConfiguration config = CheckIfCorrect(player);

        return (int) config.get("Stats." + "Level");
    }

    public static int getConfigFragments(Player player) {
        FileConfiguration config = CheckIfCorrect(player);

        return (int) config.get("Stats." + "Fragments");
    }

    public static int getConfigMiningFortune(Player player) {
        FileConfiguration config = CheckIfCorrect(player);

        return (int) config.get("Stats." + "Mining_Fortune");
    }

    public static void setConfigXP(Player player, int Amount) {
        FileConfiguration config = CheckIfCorrect(player);
        config.set("Stats." + "EXP", Amount);
        File file = new File(plugin.getDataFolder() + "/PlayerData/" + player.getUniqueId() + ".yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void setConfigLevel(Player player, int Amount) {
        FileConfiguration config = CheckIfCorrect(player);
        config.set("Stats." + "Level", Amount);
        File file = new File(plugin.getDataFolder() + "/PlayerData/" + player.getUniqueId() + ".yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setConfigFragments(Player player, int Amount) {
        FileConfiguration config = CheckIfCorrect(player);
        config.set("Stats." + "Fragments", Amount);
        File file = new File(plugin.getDataFolder() + "/PlayerData/" + player.getUniqueId() + ".yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setConfigMiningFortune(Player player, int Amount) {
        FileConfiguration config = CheckIfCorrect(player);
        config.set("Stats." + "Mining_Fortune", Amount);
        File file = new File(plugin.getDataFolder() + "/PlayerData/" + player.getUniqueId() + ".yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getHashXP(Player player) {
        UUID uuid = player.getUniqueId();
        return EXP.get(uuid);
    }

    public static void setHashXP(Player player, int Amount) {
        UUID uuid = player.getUniqueId();
        EXP.put(uuid, Amount);
    }

    public static int getHashLevel(Player player) {
        UUID uuid = player.getUniqueId();
        return Level.get(uuid);
    }

    public static void setHashLevel(Player player, int Amount) {
        UUID uuid = player.getUniqueId();
        Level.put(uuid, Amount);
    }

    public static void setHashFragments(Player player, int Amount) {
        UUID uuid = player.getUniqueId();
        Fragments.put(uuid, Amount);
    }

    public static void addHashFragments(Player player, int Amount) {
        UUID uuid = player.getUniqueId();
        Fragments.put(uuid, (getHashFragments(player) + Amount));
    }

    public static void setHashFortune(Player player, int Amount) {
        UUID uuid = player.getUniqueId();
        MiningFortune.put(uuid, Amount);
    }

    public static int getHashFragments(Player player) {
        UUID uuid = player.getUniqueId();
        return Fragments.get(uuid);
    }

    public static void removeFragments(Player player, int Amount) {
        UUID uuid = player.getUniqueId();
        Fragments.put(uuid, getHashFragments(player) - Amount);
    }

    public static int getHashFortune(Player player) {
        UUID uuid = player.getUniqueId();
        return MiningFortune.get(uuid);
    }

    public static int getResources(Player player, Resources ores) {
        FileConfiguration config = CheckIfCorrect(player);

        if(ores.getType().equals(Type.GEM)) {
            return (int) config.get("Gems." + ores);
        } else if(ores.getType().equals(Type.ORE)) {
            return (int) config.get("Ores." + ores);
        }
        return 0;
    }

    public static void setResources(Player player, Resources ores, int Amount) {
        FileConfiguration config = CheckIfCorrect(player);

        if(ores.getType().equals(Type.ORE)) {
            config.set("Ores." + ores, Amount);
        } else if(ores.getType().equals(Type.GEM)) {
            config.set("Gems." + ores, Amount);
        }
        File file = new File(plugin.getDataFolder() + "/PlayerData/" + player.getUniqueId() + ".yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addResources(Player player, Resources ores, int Amount) {
        FileConfiguration config = CheckIfCorrect(player);

        if(ores.getType().equals(Type.ORE)) {
            config.set("Ores." + ores, Amount + getResources(player, ores));
        } else if(ores.getType().equals(Type.GEM)) {
            config.set("Gems." + ores, Amount + getResources(player, ores));
        }
        File file = new File(plugin.getDataFolder() + "/PlayerData/" + player.getUniqueId() + ".yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public static void RemoveResources(Player player, Resources ores, int Amount) {
        FileConfiguration config = CheckIfCorrect(player);

        if(ores.getType().equals(Type.ORE)) {
            config.set("Ores." + ores, getResources(player, ores) - Amount);
        } else if(ores.getType().equals(Type.GEM)) {
            config.set("Gems." + ores, getResources(player, ores) - Amount);
        }
        File file = new File(plugin.getDataFolder() + "/PlayerData/" + player.getUniqueId() + ".yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setMaterials(Player player, ShopItems items, int Amount) {
        FileConfiguration config = CheckIfCorrect(player);

        if(items.getType().equals(Type.MATERIAL)) {
            config.set("Materials." + items, Amount);
        }
        File file = new File(plugin.getDataFolder() + "/PlayerData/" + player.getUniqueId() + ".yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeMaterials(Player player, ShopItems items, int Amount) {
        FileConfiguration config = CheckIfCorrect(player);

        if(items.getType().equals(Type.MATERIAL)) {
            config.set("Materials." + items, getMaterials(player, items) - Amount);
        }
        File file = new File(plugin.getDataFolder() + "/PlayerData/" + player.getUniqueId() + ".yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getMaterials(Player player, ShopItems items) {
        FileConfiguration config = CheckIfCorrect(player);

        if(items.getType().equals(Type.MATERIAL)) {
            return (int) config.get("Materials." + items);
        }
        return 0;
    }

    public static void setTimer(Player player, ForgeItems forgeItems, String time) {
        FileConfiguration config = CheckIfCorrect(player);
        config.set("Forge." + "Times." + forgeItems, time);
        File file = new File(plugin.getDataFolder() + "/PlayerData/" + player.getUniqueId() + ".yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getTimer(Player player, ForgeItems forgeItems) {
        FileConfiguration config = CheckIfCorrect(player);
        return (String) config.get("Forge." + "Times." + forgeItems.name());
    }

    public static boolean hasTimer(Player player, ForgeItems forgeItems) {
        FileConfiguration config = CheckIfCorrect(player);
        return config.contains("Forge." + "Times." + forgeItems.name());
    }



    public static void startAutoSave() {
        long interval = 6000;
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    StatUtils.setConfigXP(player, StatUtils.getHashXP(player));
                    StatUtils.setConfigLevel(player, StatUtils.getHashLevel(player));
                    StatUtils.setConfigFragments(player, StatUtils.getHashFragments(player));
                    FileConfiguration config = CheckIfCorrect(player);
                    File file = new File(plugin.getDataFolder() + "/PlayerData/" + player.getUniqueId() + ".yml");
                    try {
                        config.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                plugin.getLogger().info("Player data saved!");
            }
        }.runTaskTimerAsynchronously(EzMiner.getPlugin(), interval, interval);
    }

    public static void save() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    StatUtils.setConfigXP(player, StatUtils.getHashXP(player));
                    StatUtils.setConfigLevel(player, StatUtils.getHashLevel(player));
                    StatUtils.setConfigFragments(player, StatUtils.getHashFragments(player));
                    FileConfiguration config = CheckIfCorrect(player);
                    File file = new File(plugin.getDataFolder() + "/PlayerData/" + player.getUniqueId() + ".yml");
                    try {
                        config.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                plugin.getLogger().info("Player data saved!");
    }



}
