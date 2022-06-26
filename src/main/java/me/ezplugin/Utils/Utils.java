package me.ezplugin.Utils;

import me.ezplugin.Enums.Resources;
import me.ezplugin.EzMiner;
import me.ezplugin.Utils.Files.StatUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {


    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


    static FileConfiguration config = EzMiner.plugin.getConfig();

    public static Float randomChance() {
        return ThreadLocalRandom.current().nextFloat();
    }


    public static String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }


    public static String TimeSetup(int time) {
        int s = time;
        int sec = s % 60;
        int min = (s / 60) % 60;
        int hours = (s / 60) / 60;

        String strSec = (sec < 10) ? "0" + sec : Integer.toString(sec);
        String strmin = (min < 10) ? "0" + min : Integer.toString(min);
        String strHours = (hours < 10) ? "0" + hours : Integer.toString(hours);

        String Translated = strHours + ":" + strmin + ":" + strSec;

        return Translated;
    }

    public static Date getTime() {
        Date date = new Date();
        return date;
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


    public static Integer getTier(Player player) {
        PersistentDataContainer data = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer();
        return data.get(new NamespacedKey(EzMiner.getPlugin(), "Tier"), PersistentDataType.INTEGER);
    }

    public static ItemStack getPlayerSkull(Player paramPlayer) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (short) SkullType.PLAYER.ordinal());

        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(paramPlayer.getName());
        meta.setDisplayName("§6" + paramPlayer.getName() + "'s stats");
        skull.setItemMeta(meta);
        return skull;
    }

    /*public static void doFortune(Player player, Ores ores) {
        ItemStack MainHand = player.getInventory().getItemInMainHand();
        int getAmount = StatUtils.getResources(player, ores);
        if (MainHand.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
            int min = 1;
            int max = 3;
            int Rnd = (int) (Math.random() * (max - min + 1) + min);
            int getFortune = MainHand.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
            for (int output = Rnd; output < getFortune + 3; output++) {
                int otherAmount = StatUtils.getResources(player, ores);
                StatUtils.setResources(player, ores, otherAmount + 1);
            }
        }
        if (!(MainHand.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS))) {
            StatUtils.setResources(player, ores, getAmount + 1);
        }
    } */

    public static void handleFortune(Player player, Resources ores) {
        ItemStack MainHand = player.getInventory().getItemInMainHand();
        PersistentDataContainer data = MainHand.getItemMeta().getPersistentDataContainer();
        int getAmount = StatUtils.getResources(player, ores);

        if (data.has(new NamespacedKey(EzMiner.getPlugin(), "Fortune"), PersistentDataType.INTEGER)) {
            int getFortune = data.get(new NamespacedKey(EzMiner.getPlugin(), "Fortune"), PersistentDataType.INTEGER);
            int newAmount = getFortune / 100;
            StatUtils.setResources(player, ores, getAmount + 1 + newAmount);
        } else {
            StatUtils.setResources(player, ores, getAmount + 1);
        }
    }


    public static void handleXP(Player player, Resources ores) {

        double CurrentLVL = StatUtils.getHashLevel(player);
        int CurrentXP = StatUtils.getHashXP(player);
        final int v = (int) (25 * Math.round((500 + CurrentLVL * Math.log(Math.pow(25, CurrentLVL))) / 25));
        if (CurrentXP >= v) {
            StatUtils.setHashLevel(player, (int) (CurrentLVL + 1));
            StatUtils.setHashXP(player, (CurrentXP - v));
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
            player.sendMessage("§a§lLevel up!\n§6You are now level: " + StatUtils.getHashLevel(player));
        } else {
            int newXP = StatUtils.getHashXP(player) + (ores.getTier() * 25);
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("" + ChatColor.LIGHT_PURPLE + newXP + " §9/ " + ChatColor.LIGHT_PURPLE + v + ""));
            StatUtils.setHashXP(player, newXP);
        }
    }

    public static void handleFragment(Player player, int Amount) {
        int currentFragments = StatUtils.getHashFragments(player);
        StatUtils.setHashFragments(player, currentFragments + Amount);
    }






}
