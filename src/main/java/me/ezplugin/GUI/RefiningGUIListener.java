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


public class RefiningGUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) throws ParseException {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§8Refining")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
            } else if (e.getCurrentItem().getType().equals(ItemManager.Refined_Gemstone_1.getType())) {
                if(Utils.getLevel(player) >= ForgeItems.Gemstone_2.getLevel()) {
                    int Value = Integer.parseInt((ForgeItems.Gemstone_2.getAmountInteger().split(" ")[0]));
                    if(Utils.getResources(player, Ores.Gemstone_1) >= Value) {
                        if(ForgeUtils.checkTime(ForgeItems.Gemstone_2, player)) {
                            Utils.TakeResources(player, Ores.Gemstone_1, Integer.parseInt(ForgeItems.Gemstone_2.getAmountInteger()));
                            ForgeUtils.ForgeSetup(player, ForgeItems.Gemstone_2);
                        }
                    }
                }


























            }  else {
                GuiUtils.MiscSetup(e, SelectorGUI.SelectorGUI());
            }
        }
    }
}