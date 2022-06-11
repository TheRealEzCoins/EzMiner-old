package me.ezplugin.GUI;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Ores;
import me.ezplugin.GUI.GUIS.SelectorGUI;
import me.ezplugin.Utils.*;
import me.ezplugin.Utils.Stats.StatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.text.ParseException;


public class RefiningGUIListener implements Listener {

    // This is the listener for the Refining GUI. It checks if the player has the required level and resources to forge the
    // item. If they do, it will take the resources and start the forge.
    @EventHandler
    public void onClick(InventoryClickEvent e) throws ParseException {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§8Refining")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
            } else if (e.getCurrentItem().isSimilar(GuiUtils.createItem(ForgeItems.Refined_Gem, Ores.Gemstone))) {
                if (StatUtils.getHashLevel(player) >= ForgeItems.Refined_Gem.getLevel()) {
                    int Value = Integer.parseInt((ForgeItems.Refined_Gem.getAmountInteger().split(" ")[0]));
                    if (StatUtils.getResources(player, Ores.Gemstone) >= Value) {
                        if (ForgeUtils.checkTime(ForgeItems.Refined_Gem, player)) {
                            StatUtils.RemoveResources(player, Ores.Gemstone, Integer.parseInt(ForgeItems.Refined_Gem.getAmountInteger()));
                            ForgeUtils.ForgeSetup(player, ForgeItems.Refined_Gem);
                        }
                    } else {
                        player.sendMessage("§cYou need more resources to forge this!");
                    }
                } else {
                    player.sendMessage("§cYou need to be higher level to forge this!");
                }
            } else if(e.getCurrentItem().isSimilar(GuiUtils.createItem(ForgeItems.Polished_Gem, Ores.Refined_Gemstone))) {
                if (StatUtils.getHashLevel(player) >= ForgeItems.Polished_Gem.getLevel()) {
                    int Value = Integer.parseInt((ForgeItems.Polished_Gem.getAmountInteger().split(" ")[0]));
                    if (StatUtils.getResources(player, Ores.Refined_Gemstone) >= Value) {
                        if (ForgeUtils.checkTime(ForgeItems.Polished_Gem, player)) {
                            StatUtils.RemoveResources(player, Ores.Refined_Gemstone, Integer.parseInt(ForgeItems.Polished_Gem.getAmountInteger()));
                            ForgeUtils.ForgeSetup(player, ForgeItems.Polished_Gem);
                        }
                    } else {
                        player.sendMessage("§cYou need more resources to forge this!");
                    }
                } else {
                    player.sendMessage("§cYou need to be higher level to forge this!");
                }
            } else if(e.getCurrentItem().isSimilar(GuiUtils.createItem(ForgeItems.Perfect_Gem, Ores.Polished_Gemstone))) {
                if (StatUtils.getHashLevel(player) >= ForgeItems.Perfect_Gem.getLevel()) {
                    int Value = Integer.parseInt((ForgeItems.Perfect_Gem.getAmountInteger().split(" ")[0]));
                    if (StatUtils.getResources(player, Ores.Polished_Gemstone) >= Value) {
                        if (ForgeUtils.checkTime(ForgeItems.Perfect_Gem, player)) {
                            StatUtils.RemoveResources(player, Ores.Polished_Gemstone, Integer.parseInt(ForgeItems.Perfect_Gem.getAmountInteger()));
                            ForgeUtils.ForgeSetup(player, ForgeItems.Perfect_Gem);
                        }
                    } else {
                        player.sendMessage("§cYou need more resources to forge this!");
                    }
                } else {
                    player.sendMessage("§cYou need to be higher level to forge this!");
                }


























            }  else {
                GuiUtils.MiscSetup(e, SelectorGUI.SelectorGUI());
            }
        }
    }
}