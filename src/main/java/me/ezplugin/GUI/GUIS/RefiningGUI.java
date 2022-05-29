package me.ezplugin.GUI.GUIS;

import me.ezplugin.EzMiner;
import me.ezplugin.Items.ItemManager;
import me.ezplugin.Utils.GuiUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import static me.ezplugin.Utils.Utils.customItemName;

public class RefiningGUI {

    private static final ItemStack blackglass = customItemName(Material.BLACK_STAINED_GLASS_PANE, " ");

    private static final int[] black_border = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            17, 18, 26, 27, 35, 36, 44, 45, 46, 47, 50,
            51, 52, 53};

    public static Inventory RefiningGUI(Player player) {

        Inventory RefiningGUI = Bukkit.createInventory(null, 54, "Refining");


        Integer xp = (player.getPersistentDataContainer().get(new NamespacedKey(EzMiner.getPlugin(), "XP"), PersistentDataType.INTEGER));
        Integer Level = (player.getPersistentDataContainer().get(new NamespacedKey(EzMiner.getPlugin(), "LEVEL"), PersistentDataType.INTEGER));

        if(Level >= 1) {
            RefiningGUI.setItem(
                    10,
                    GuiUtils.createCustomItem(ItemManager.Refined_Gemstone_1, ItemManager.Gemstone, 16, "5m"));

            RefiningGUI.setItem(
                    49,
                    GuiUtils.menuClose());


            RefiningGUI.setItem(
                    48,
                    GuiUtils.menuReturn());
        }



        for(int slot : black_border){
            RefiningGUI.setItem(slot, blackglass);
        }

        return RefiningGUI;
    }
}