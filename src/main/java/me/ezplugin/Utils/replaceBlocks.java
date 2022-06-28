package me.ezplugin.Utils;

import it.unimi.dsi.fastutil.Hash;
import me.ezplugin.Events.onEnableXray;
import me.ezplugin.EzMiner;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Shulker;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;


public class replaceBlocks {


    public static void getBlocks(final Player p, final int radius) {
        final Location loc = p.getLocation();
        Material block = Utils.returnBlock(p);
        for (double x = p.getLocation().getX() - radius; x <= p.getLocation().getX() + radius; x++) {
            double z;
            for (z = p.getLocation().getZ() - radius; z <= p.getLocation().getZ() + radius; z++) {
                double y;
                for (y = 1.0D; y < 150.0D; y++) {
                    loc.setX(x);
                    loc.setZ(z);
                    loc.setY(y);
                    if (loc.getBlock().getType() == block) {
                        Shulker shulker = (Shulker) loc.getWorld().spawnEntity(loc, EntityType.SHULKER);
                        shulker.setCustomName(ChatColor.BLUE + "");
                        shulker.setCollidable(true);
                        shulker.setGlowing(true);
                        shulker.setAI(false);
                        shulker.setInvulnerable(true);
                        shulker.setInvisible(true);
                    }
                }
            }
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                for(Entity entity : p.getWorld().getNearbyEntities(loc, p.getLocation().getX() + 200, p.getLocation().getY() + 200, p.getLocation().getZ() + 200)) {
                    if (entity instanceof Shulker) {
                        if (entity.isInvulnerable()) {
                            entity.remove();

                        }
                    }
                }
            }
        }.runTaskLater(EzMiner.getPlugin(), (10 * 20L));
    }
}

