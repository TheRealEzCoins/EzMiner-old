package me.ezplugin.Utils;

import me.ezplugin.EzMiner;
import me.ezplugin.GUI.GUIS.PickaxeGUI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {


    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static SimpleDateFormat formatter =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");





    public static String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }



    public static ItemStack customItemName(Material mat, String name, String... lore){
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack customForgeBuilder(ItemStack craftable, String displayName, String forgeLore) {
        ItemStack item = new ItemStack(craftable);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(forgeLore));
        item.setItemMeta(meta);
        return item;
    }


    public static ItemStack customItemUsingStack(ItemStack mat, String... lore){
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
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

    public static void SoundSetup(Player player, Sound sound, float volume, float pitch) {
        player.playSound(player.getLocation(), sound, volume, pitch);
    }

    public static void FailedSound(Player player) {
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, -10);
    }

    public static void BlockSetup(BlockBreakEvent block, Integer LevelReq, Material ore,Integer Hardness ,ItemStack drop ,Player player, Integer ExpAmount, Long RespawnTimer) {
        if (isEmpty(player)) {
            PersistentDataContainer data = player.getPersistentDataContainer();
            PersistentDataContainer pick = player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer();
            Boolean CheckTier = pick.has(new NamespacedKey(EzMiner.getPlugin(), "Tier"), PersistentDataType.INTEGER);
            if (block.getBlock().getType() == ore && player.getWorld().getName().equals("world")) {
                if (CheckTier) {
                    int Tier = pick.get(new NamespacedKey(EzMiner.getPlugin(), "Tier"), PersistentDataType.INTEGER);
                    if (Tier >= Hardness) {
                        int CurrentLVL = data.get(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER);
                        int totalLevel = CurrentLVL + 1;
                        int CurrentXP = data.get(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER);
                        int totalXP = CurrentXP + ExpAmount;
                        if (CurrentLVL >= LevelReq) {
                            ItemStack MainHand = player.getInventory().getItemInMainHand();
                            Location BlockLocation = block.getBlock().getLocation();

                            // Handles Fortune
                            if(MainHand.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                                int min = 1;
                                int max = 3;
                                int Rnd = (int)(Math.random()*(max-min+1)+min);
                                int getFortune = MainHand.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                                for (int output = Rnd; output < getFortune + 3; output++  ) {
                                    player.getInventory().addItem(drop);
                                }
                            } if(!(MainHand.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS))) {
                                player.getInventory().addItem(drop);
                            }

                                // Handles basic block breaking events
                                block.setDropItems(false);
                                BlockLocation.getWorld().spawnParticle(Particle.CRIT, BlockLocation.add(0, 1, 0 ), 10);
                                FuelHandler.onFuelUsage(player);
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                                block.setCancelled(true);
                                block.getBlock().setType(Material.BEDROCK);
                                Utils.setscore(player, CurrentLVL, CurrentXP + ExpAmount);


                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    block.getBlock().setType(ore);
                                }
                            }.runTaskLater(EzMiner.getPlugin(), RespawnTimer);

                            if (CurrentXP >= 500 * CurrentLVL) {

                                data.set(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER, 0);
                                data.set(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER, CurrentLVL + 1);
                                player.sendMessage("§bLeveling...");
                                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
                                player.sendMessage("§a§lLevel up!\n§6You are now level: " + totalLevel);
                                Utils.setscore(player, CurrentLVL + 1, 0);
                            } else {
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("" + ChatColor.LIGHT_PURPLE + totalXP + " §9/ " + ChatColor.LIGHT_PURPLE + CurrentLVL * 500 + ""));
                                data.set(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER, CurrentXP + ExpAmount);
                            }
                        } else {
                            player.sendMessage("You need to be level " + LevelReq + " to mine this.");
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
                            block.setCancelled(true);
                        }
                    } else {
                        player.sendMessage("Your pickaxe must be Tier " + Hardness + " mine this.");
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F);
                        block.setCancelled(true);
                }
                }
            }
        } else {
            return;
        }
    }


    public static void ForgeSetup(Player player, int LevelReq , ItemStack Craftable, Material Item1, Integer Amount1, Integer CraftingTime, String key) {

        PersistentDataContainer dataContainer = player.getPersistentDataContainer();
        int Level = dataContainer.get(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER);

        if(dataContainer.has(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING)) {
            player.sendMessage("You're already crafting an item!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
            return;
        }
        if(Level >= LevelReq) {
            if (player.getInventory().contains(Item1, Amount1)) {
                    for (ItemStack stack : player.getInventory().getContents()) {
                        if (stack != null) {
                            if (stack.getType() == Item1 && stack.getAmount() >= Amount1) {
                                int newStack = stack.getAmount() - Amount1;
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(Utils.getTime());
                                cal.add(Calendar.SECOND, CraftingTime);
                                String time = Utils.formatter.format(cal.getTime());
                                dataContainer.set(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING, time);

                                stack.setAmount(newStack);
                                player.sendMessage("§7Crafting: \n§8- " + Objects.requireNonNull(Craftable.getItemMeta()).getDisplayName() + " §b30s");
                                player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1f, 1f);

                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1f, 1f);
                                        player.sendMessage("§b§lYour item finished crafting!");
                                    }
                                }.runTaskLater(EzMiner.getPlugin(), CraftingTime * 20);
                                break;
                            }
                        }
                    }


            } else {
                FailedSound(player);
                player.sendMessage("You are missing the ingredients to make this item!");
            }
        } else {
            FailedSound(player);
            player.sendMessage("You need to be level " + Level + " to forge this item.");
        }
    }

    public static void CustomForgeSetup(Player player, int LevelReq ,ItemStack Craftable, ItemStack ore, Integer OreAmount, Integer CraftingTime, String key) throws ParseException {

        PersistentDataContainer dataContainer = player.getPersistentDataContainer();
        PersistentDataContainer ItemContainer = ore.getItemMeta().getPersistentDataContainer();
        int Level = dataContainer.get(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER);

        if(dataContainer.has(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING)) {
            player.sendMessage("You're already crafting an item!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
            return;
        }
        if(Level >= LevelReq) {
            if (player.getInventory().contains(ore.getType(), OreAmount)) {
                if (ItemContainer.has(new NamespacedKey(EzMiner.getPlugin(), "Ore"), PersistentDataType.STRING)) {
                    for (ItemStack stack : player.getInventory().getContents()) {
                        if (stack != null) {
                            if (stack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Ore"), PersistentDataType.STRING) == ore.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), "Ore"), PersistentDataType.STRING) && stack.getAmount() >= OreAmount) {
                                int newStack = stack.getAmount() - OreAmount;
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(Utils.getTime());
                                cal.add(Calendar.SECOND, CraftingTime);
                                String time = Utils.formatter.format(cal.getTime());
                                dataContainer.set(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING, time);

                                stack.setAmount(newStack);
                                player.sendMessage("§7Crafting: \n§8- " + Objects.requireNonNull(Craftable.getItemMeta()).getDisplayName() + " §b30s");
                                SoundSetup(player, Sound.BLOCK_LAVA_POP, 1, 10);
                                SoundSetup(player, Sound.BLOCK_FIRE_EXTINGUISH, 1, 10);

                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1f, 1f);
                                        player.sendMessage("§b§lYour item finished crafting!");
                                    }
                                }.runTaskLater(EzMiner.getPlugin(), CraftingTime * 20);
                                break;
                            }
                        }
                    }
                }

                } else {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
                player.sendMessage("You are missing the ingredients to make this item!");
            }
        } else {
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
            player.sendMessage("You need to be level " + Level + " to forge this item.");
        }
    }


    public static void ForgeTimeSetup(InventoryOpenEvent openEvent, ItemStack Craftable, String key) throws ParseException {

            if (!openEvent.getView().getTitle().equalsIgnoreCase("Forge"))
                return;

            Player player = (Player) openEvent.getPlayer();
            if(!player.getPersistentDataContainer().has(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING))
                return;
            PersistentDataContainer dataContainer = player.getPersistentDataContainer();
            Date forgedate = Utils.formatter.parse(dataContainer.get(new NamespacedKey(EzMiner.getPlugin(), key), PersistentDataType.STRING));

            if (Utils.getTime().after(forgedate)) {
                player.sendMessage("§a§lWhile you were gone, an item finished crafting!");
                SoundSetup(player, Sound.ENTITY_ITEM_PICKUP, 1, -10);
                SoundSetup(player, Sound.ENTITY_PLAYER_LEVELUP, 1, -10);
                dataContainer.remove(new NamespacedKey(EzMiner.getPlugin(), key));
                player.getInventory().addItem(Craftable);
            }
        }

    public static void setscore(Player player, int level, int xp) {
        Scoreboard scoreboard = EzMiner.plugin.getServer().getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("test", "dummy");

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
        Score score = objective.getScore("Player: " + ChatColor.GOLD + player.getDisplayName());
        score.setScore(5);

        player.setScoreboard(scoreboard);
    }


    public static Integer getCurrentStats(Player player, String stat) {
        PersistentDataContainer data = player.getPersistentDataContainer();
        return data.get(new NamespacedKey(EzMiner.getPlugin(), stat), PersistentDataType.INTEGER);
    }


}
