package me.ezplugin.GUI;

import me.ezplugin.Enums.Resources;
import me.ezplugin.Enums.ShopItems;
import me.ezplugin.Enums.Type;
import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.Items.Items.MaterialItems;
import me.ezplugin.Items.Items.OreItems;
import me.ezplugin.Utils.Files.StatUtils;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ShopGUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§8Shop")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ShopItems.FUEL.getItem().getName())) {
                    if (StatUtils.getHashLevel(player) >= ShopItems.FUEL.getLevel()) {
                        if (StatUtils.getHashFragments(player) >= ShopItems.FUEL.getCost()) {
                            StatUtils.removeFragments(player, ShopItems.FUEL.getCost());
                            player.getInventory().addItem(MaterialItems.OIL_BARREL.getItemStack());
                        } else {
                            player.sendMessage("§cYou do not have enough Fragments!");
                        }
                    }
                } else if(e.getRawSlot() == 50) {
                    if(StatUtils.getHashFragments(player) >= 250) {
                        StatUtils.removeFragments(player, 250);
                        player.sendMessage("§cWithdrew 250 fragments!");
                        Float random = Utils.randomChance();

                        if (random <= 0.01) {
                            player.sendMessage("§aYou won 1000 fragments!");
                            StatUtils.addHashFragments(player, 1000);
                            return;
                        }

                        if(random <= 0.05) {
                            player.getInventory().addItem(MaterialItems.FortuneUpgrade.getItemStack());
                            player.sendMessage("§aYou won a fortune upgrade!");
                            return;
                        }

                        if(random <= 0.10) {
                            player.sendMessage("§aYou won 500 fragments!");
                            StatUtils.addHashFragments(player, 250);
                            return;
                        }

                        if(random <= 0.25) {
                            int CurrentLevel = StatUtils.getHashLevel(player);
                            if(CurrentLevel < 10) {
                                StatUtils.addResources(player, Resources.Nacrine, 25);
                                player.sendMessage("§aYou found 25x §8Nacrine");
                                return;
                            } else if(10  < CurrentLevel && CurrentLevel < 25) {
                                StatUtils.addResources(player, Resources.Uprum, 25);
                                player.sendMessage("§aYou found 25x §cUprum");
                                return;
                            }  else if(24  < CurrentLevel && CurrentLevel < 50) {
                                StatUtils.addResources(player, Resources.Zaplium, 25);
                                player.sendMessage("§aYou found 25x §eZaplium");
                                return;
                            } else if(49  < CurrentLevel && CurrentLevel < 60) {
                                StatUtils.addResources(player, Resources.Slaginite, 25);
                                player.sendMessage("§aYou found 25x §5Slaginite");
                                return;
                            } else if(59  < CurrentLevel && CurrentLevel < 75) {
                                StatUtils.addResources(player, Resources.Gryrium, 25);
                                player.sendMessage("§aYou found 25x §7Gryrium");
                                return;
                            } else if(75  < CurrentLevel && CurrentLevel < 90) {
                                StatUtils.addResources(player, Resources.Kreisium, 25);
                                player.sendMessage("§aYou found 25x §cKreisium");
                                return;
                            } else if(90  < CurrentLevel && CurrentLevel < 100) {
                                StatUtils.addResources(player, Resources.Volcanium, 25);
                                player.sendMessage("§aYou found 25x §6Volcanium");
                                return;
                            } else if(CurrentLevel > 100) {
                                StatUtils.addResources(player, Resources.Flotine, 25);
                                player.sendMessage("§aYou found 25x §aFlotine");
                                return;
                            }
                        } else if(random <= 0.35) {
                            StatUtils.setHashXP(player, StatUtils.getHashXP(player) + 250);
                            Utils.checkXP(player);
                            player.sendMessage("§aYou received 250 xp!");

                        } else if(random <= 0.50) {
                            StatUtils.addHashFragments(player, 150);
                            player.sendMessage("§aYou found 150 fragments.");
                        } else {
                            StatUtils.addHashFragments(player, 100);
                            player.sendMessage("§aYou found 100 fragments!");
                        }
                    }



                }
                GuiUtils.MiscSetup(e, ForgeGUI.FORGEGUI(player));
                for(ShopItems items : ShopItems.values()) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(items.getItem().getName())) {
                        if(items.getType().equals(Type.MATERIAL)) {
                            if (StatUtils.getHashLevel(player) >= items.getLevel()) {
                                if (StatUtils.getHashFragments(player) >= items.getCost()) {
                                    StatUtils.removeFragments(player, items.getCost());
                                    StatUtils.setMaterials(player, items, StatUtils.getMaterials(player, items) + 1);
                                    player.sendMessage("§aYou bought " + items.getItem().getName());
                                } else {
                                    player.sendMessage("§cYou do not have enough Fragments!");
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}
