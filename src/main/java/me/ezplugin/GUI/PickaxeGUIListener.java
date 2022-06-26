package me.ezplugin.GUI;

import me.ezplugin.Enums.ForgeItems;
import me.ezplugin.Enums.Resources;
import me.ezplugin.Enums.ShopItems;
import me.ezplugin.GUI.GUIS.ForgeGUI;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ForgeUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.text.ParseException;


public class PickaxeGUIListener implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent e) throws ParseException {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§8Pickaxe Forge")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
            } else if (e.getSlot() == 10) {
                ForgeUtils.DoubleCraft(player, ForgeItems.Nacrine_Pickaxe, Resources.Nacrine, 400, ShopItems.Tier_1_Handle, 1);
            }else if (e.getSlot() == 11) {
                ForgeUtils.DoubleCraft(player, ForgeItems.Uprum_Pickaxe, Resources.Uprum, 250, ShopItems.Tier_1_Handle, 1);
            } else if (e.getSlot() == 12) {
                ForgeUtils.DoubleCraft(player, ForgeItems.Zaplium_Pickaxe, Resources.Zaplium, 400, ShopItems.Tier_2_Handle, 1);
            }  else if(e.getSlot() == 13) {
                ForgeUtils.DoubleCraft(player, ForgeItems.Slaginite_Pickaxe, Resources.Slaginite, 500, ShopItems.Tier_3_Handle, 1);
            } else if(e.getSlot() == 14) {
                ForgeUtils.DoubleCraft(player, ForgeItems.Gryrium_Pickaxe, Resources.Gryrium, 600, ShopItems.Tier_3_Handle, 2);
            } else if(e.getSlot() == 15) {
                ForgeUtils.DoubleCraft(player, ForgeItems.Kreisium_Pickaxe, Resources.Kreisium, 750, ShopItems.Tier_4_Handle, 2);
            } else if(e.getSlot() == 16) {
                ForgeUtils.DoubleCraft(player, ForgeItems.Volcanium_Pickaxe, Resources.Volcanium, 350, ShopItems.Tier_4_Handle, 2);
            }
            else {
                GuiUtils.MiscSetup(e, ForgeGUI.FORGEGUI(player));
            }
        }
    }
}