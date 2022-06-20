package me.ezplugin.Utils;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.EzMiner;
import me.ezplugin.Utils.Files.StatUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.ParseException;
import java.util.*;

public class ForgeUtils {
    public static void ForgeSetup(Player player ,ForgeItems forgeItems) {


        Calendar cal = Calendar.getInstance();
        cal.setTime(Utils.getTime());
        cal.add(Calendar.SECOND, forgeItems.getTime());
        String time = Utils.formatter.format(cal.getTime());
        StatUtils.setTimer(player, forgeItems, time);



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





    public static void ForgeTimeSetup(InventoryOpenEvent openEvent, ForgeItems forgeItems) throws ParseException {

        if (!openEvent.getView().getTitle().equalsIgnoreCase("§8Forge"))
            return;

        Player player = (Player) openEvent.getPlayer();
        if(!StatUtils.hasTimer(player, forgeItems)) return;
        Date forgeDate = Utils.formatter.parse(StatUtils.getTimer(player, forgeItems));


        if (Utils.getTime().after(forgeDate)) {
            player.sendMessage("§a§lWhile you were gone, an item finished crafting!");
            Utils.SoundSetup(player, Sound.ENTITY_ITEM_PICKUP, 1, -10);
            Utils.SoundSetup(player, Sound.ENTITY_PLAYER_LEVELUP, 1, -10);
            StatUtils.setTimer(player, forgeItems, null);
            player.getInventory().addItem(forgeItems.getOuput().getItemStack());
            }
        }

    public static boolean checkTime(ForgeItems forgeItems, Player player) {
        if (StatUtils.hasTimer(player, forgeItems)) {
                player.sendMessage("§cYou're already crafting an item!");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
                return false;

        }
        return true;
    }



    public static void SingleCraft(Player player, ForgeItems craft, Ores Resource_1) throws ParseException {
        if(StatUtils.getHashLevel(player) >= craft.getLevel()) {
            int Value = Integer.parseInt(craft.getAmountInteger());
            if(StatUtils.getResources(player, Resource_1) >= Value) {
                if(ForgeUtils.checkTime(craft, player)) {
                    ForgeUtils.ForgeSetup(player, craft);
                    StatUtils.RemoveResources(player, Resource_1, Value);
                }
            } else {
                player.sendMessage("§cYou do not have enough resources to craft this!");
                Utils.FailedSound(player);
            }
        } else {
            player.sendMessage("§cYou're not high enough level to forge this!");
            Utils.FailedSound(player);
        }
    }

    public static void DoubleCraft(Player player, ForgeItems craft, Ores Resource_1, Ores Resource_2) throws ParseException {
            if(StatUtils.getHashLevel(player) >= craft.getLevel()) {
                int Value = Integer.parseInt((craft.getAmountInteger().split(" ")[0]));
                int Value2 = Integer.parseInt((craft.getAmountInteger().split(" ")[1]));
                if(StatUtils.getResources(player, Resource_1) >= Value && StatUtils.getResources(player, Resource_2) >= Value2) {
                    if(ForgeUtils.checkTime(craft, player)) {
                        ForgeUtils.ForgeSetup(player, craft);
                        StatUtils.RemoveResources(player, Resource_1, Value);
                        StatUtils.RemoveResources(player, Resource_2, Value2);
                    }
                } else {
                    player.sendMessage("§cYou do not have enough resources to craft this!");
                    Utils.FailedSound(player);
                }
            } else {
                player.sendMessage("§cYou're not high enough level to forge this!");
                Utils.FailedSound(player);
            }





        }
    }


