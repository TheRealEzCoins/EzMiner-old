package me.ezplugin.Utils;

import com.jeff_media.morepersistentdatatypes.DataType;
import me.ezplugin.EzMiner;
import me.ezplugin.Items.ItemManager;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Locale;

public class ItemUtils extends Utils {

    public static ItemStack customItemName(Material mat, String name, String... lore){
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }



    public static ItemStack customItemUsingStack(ItemStack mat, String name, String... lore){
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

}
