package me.ezplugin.Utils;

import me.ezplugin.Enums.Ores;
import me.ezplugin.EzMiner;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static me.ezplugin.Utils.Utils.*;

public class BlockUtils {
    public static void BlockSetup(BlockBreakEvent block, Player player, Ores ores, Long RespawnTimer, int ExpAmount) {
        if (Utils.isEmpty(player)) {
            Block getBlock = block.getBlock();
            if (getBlock.hasMetadata("CustomBlock")) {
                if(getBlock.getType().equals(ores.getBlock())) {
                    if(getLevel(player) >= ores.getLevel()) {
                        if(Utils.getTier(player) >= ores.getTier()) {
                            getBlock.removeMetadata("CustomBlock", EzMiner.getPlugin());

                            if (FuelHandler.getFuel(player)) {
                                FuelHandler.FuelConsume(player, block);
                            }

                            Utils.doFortune(player, ores.getItem());

                            block.setDropItems(false);
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                            block.setCancelled(true);
                            block.getBlock().setType(Material.BEDROCK);


                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    block.getBlock().setType(ores.getBlock());
                                    AddMeta(block);
                                }
                            }.runTaskLater(EzMiner.getPlugin(), RespawnTimer);

                            Utils.HandleXP(player, ExpAmount);

                        }else {
                            player.sendMessage("§cYour pickaxe must be §eTier " + ores.getTier() + " §cto mine this.");
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F);
                            block.setCancelled(true);
                        }
                    } else {
                        player.sendMessage("§cYou need to be §eLevel " + ores.getLevel() + " §cto mine this.");
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 1f);
                        block.setCancelled(true);
                    }
                }
            }
        }

    }

    public static void AddMeta(BlockBreakEvent block) {
        assert block != null;
        block.getBlock().setMetadata("CustomBlock", new MetadataValue() {
            @Nullable
            @Override
            public Object value() {
                return null;
            }

            @Override
            public int asInt() {
                return 0;
            }

            @Override
            public float asFloat() {
                return 0;
            }

            @Override
            public double asDouble() {
                return 0;
            }

            @Override
            public long asLong() {
                return 0;
            }

            @Override
            public short asShort() {
                return 0;
            }

            @Override
            public byte asByte() {
                return 0;
            }

            @Override
            public boolean asBoolean() {
                return false;
            }

            @NotNull
            @Override
            public String asString() {
                return null;
            }

            @Nullable
            @Override
            public Plugin getOwningPlugin() {
                return EzMiner.getPlugin();
            }

            @Override
            public void invalidate() {

            }

        });

    }
}
