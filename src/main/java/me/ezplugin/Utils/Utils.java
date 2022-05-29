package me.ezplugin.Utils;

import me.ezplugin.EzMiner;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {


    public static SimpleDateFormat formatter =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    static FileConfiguration config = EzMiner.plugin.getConfig();
    public static int getRatio = (int) config.get("Level-Scaling.Exp");


    public static String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }


    public static String TimeSetup(int time) {
        int s = time / 2;
        int sec = s % 60;
        int min = (s / 60)%60;
        int hours = (s/60)/60;

        String strSec=(sec<10)?"0"+ sec :Integer.toString(sec);
        String strmin=(min<10)?"0"+ min :Integer.toString(min);
        String strHours=(hours<10)?"0"+ hours :Integer.toString(hours);

        String Translated = strHours + ":" + strmin + ":" + strSec;

        return Translated;
    }

    public static Date getTime() {
        Date date = new Date();
        return date;
    }

    public static void PlayerDataReload(Player player) {
        PersistentDataContainer data = player.getPersistentDataContainer();
        int CurrentXP = data.get(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER);
        int CurrentLVL = data.get(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER);
        Utils.setscore(player, CurrentLVL, CurrentXP);

    }

    public static boolean isEmpty(Player player) {
        ItemStack getMainHand = player.getItemInHand();
        return (getMainHand != null && getMainHand.getType() != Material.AIR);
    }

    public static PersistentDataContainer getMainHandData(Player player) {
        PersistentDataContainer MainHand = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer();
        return MainHand;
    }

    public static void SoundSetup(Player player, Sound sound, float volume, float pitch) {
        player.playSound(player.getLocation(), sound, volume, pitch);
    }

    public static void FailedSound(Player player) {
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, -10);
    }

    public static void setscore(Player player, int level, int xp) {
        Scoreboard scoreboard = EzMiner.plugin.getServer().getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("EzMiner", "Mining");

        objective.setDisplayName("§cPlayer Level");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score emptyspot1 = objective.getScore("");
        emptyspot1.setScore(1);
        Score exp = objective.getScore("XP: §a" + xp);
        exp.setScore(2);
        Score lvl = objective.getScore("Level: §a" + level);
        lvl.setScore(3);
        Score emptyspot2 = objective.getScore("");
        emptyspot2.setScore(4);
        Score score = objective.getScore("Player: " + ChatColor.GOLD + player.getName());
        score.setScore(5);

        player.setScoreboard(scoreboard);
    }


    public static Integer getXP(Player player) {
        PersistentDataContainer data = player.getPersistentDataContainer();
        return data.get(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER);
    }

    public static Integer getLevel(Player player) {
        PersistentDataContainer data = player.getPersistentDataContainer();
        return data.get(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER);
    }

    public static void setXP(Player player, int xp) {
        PersistentDataContainer data = player.getPersistentDataContainer();
        data.set(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER, xp);
    }

    public static void setLevel(Player player, int Level) {
        PersistentDataContainer data = player.getPersistentDataContainer();
        data.set(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER, Level);
    }

    public static ItemStack getPlayerSkull(Player paramPlayer) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (short) SkullType.PLAYER.ordinal());

        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(paramPlayer.getName());
        meta.setDisplayName("§6" + paramPlayer.getName() + "'s stats");
        skull.setItemMeta(meta);
        return skull;
    }


}
