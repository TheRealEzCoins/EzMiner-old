package me.ezplugin.GUI.GUIS;

import dev.dbassett.skullcreator.SkullCreator;
import me.ezplugin.Enums.Heads;
import me.ezplugin.Enums.ShopItems;
import me.ezplugin.Utils.GuiUtils;
import me.ezplugin.Utils.ItemUtils;
import me.ezplugin.Utils.ResourceSetup;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class ShopGUI extends GuiUtils {
    public static Inventory ShopGUI(Player player) {
        Inventory ShopGUI = Bukkit.createInventory(null, 54, "§8Shop");

        GuiUtils.fillBorder(ShopGUI);

        for(ShopItems items : ShopItems.values()) {
            ShopGUI.setItem(ShopGUI.firstEmpty(), GuiUtils.getItemAsShop(items));
        }

        ShopGUI.setItem(50,
                ItemUtils.customItemUsingStack(SkullCreator.itemFromUrl(Heads.Lootbox.getURL()),
                        "§cGamble §8(250 fragments / roll)",
                        "",
                        "§bOdds:",
                        "§c1% §7- §a1,000 fragments",
                        "§c5% §7- §a1x Fortune upgrade",
                        "§c10% §7- §a500 fragments",
                        "§c25% §7- §a25x of your current §cHIGHEST §aore",
                        "§c50% §7- §a100 fragments",
                        "",
                        "§c§oIf you get very unlucky: 50 fragments",
                        "§7§oI'm not responsible for any of this."));

        ShopGUI.setItem(
                49,
                GuiUtils.menuClose());


        ShopGUI.setItem(
                48,
                GuiUtils.menuReturn());


        return ShopGUI;
    }
}
