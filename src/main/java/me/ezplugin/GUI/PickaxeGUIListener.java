package me.ezplugin.GUI;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.GUI.GUIS.SelectorGUI;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.Utils;
import me.ezplugin.Utils.ForgeUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.text.ParseException;


public class PickaxeGUIListener implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent e) throws ParseException {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§8Pickaxe Forge")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
            } else if (e.getCurrentItem().getType().equals(ItemManager.Orichalchite_Pickaxe.getType())) {
                if(Utils.getLevel(player) >= ForgeItems.Orichalchite_Pickaxe.getLevel()) {
                    int Value = Integer.parseInt(ForgeItems.Orichalchite_Pickaxe.getAmountInteger());
                    if(Utils.getResources(player, Ores.Orichalchite) >= Value) {
                        if(ForgeUtils.checkTime(ForgeItems.Orichalchite_Pickaxe, player)) {
                            ForgeUtils.ForgeSetup(player, ForgeItems.Orichalchite_Pickaxe);
                            Utils.TakeResources(player, Ores.Orichalchite, Value);
                        }
                    } else {
                        player.sendMessage("§cYou do not have enough resources to craft this!");
                        Utils.FailedSound(player);
                    }
                } else {
                    player.sendMessage("§cYou're not high enough level to forge this!");
                    Utils.FailedSound(player);
                }



            } else if (e.getCurrentItem().getType().equals(ItemManager.Obsidian_Pickaxe.getType())) {
                if(Utils.getLevel(player) >= ForgeItems.Obsidian_Pickaxe.getLevel()) {
                    int Value = Integer.parseInt((ForgeItems.Obsidian_Pickaxe.getAmountInteger().split(" ")[0]));
                    int Value2 = Integer.parseInt((ForgeItems.Obsidian_Pickaxe.getAmountInteger().split(" ")[1]));
                    if(Utils.getResources(player, Ores.Gemstone_1) >= Value && Utils.getResources(player, Ores.Orichalchite) >= Value2) {
                        if(ForgeUtils.checkTime(ForgeItems.Obsidian_Pickaxe, player)) {
                            ForgeUtils.ForgeSetup(player, ForgeItems.Obsidian_Pickaxe);
                            Utils.TakeResources(player, Ores.Gemstone_1, Value);
                            Utils.TakeResources(player, Ores.Orichalchite, Value2);
                        }
                    } else {
                        player.sendMessage("§cYou do not have enough resources to craft this!");
                        Utils.FailedSound(player);
                    }
                } else {
                    player.sendMessage("§cYou're not high enough level to forge this!");
                    Utils.FailedSound(player);
                }





            } else {
                GuiUtils.MiscSetup(e, SelectorGUI.SelectorGUI());
            }
        }
    }
}