package caizii.server.arcanetravel.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AS_confirm_menu {
    public void AS_confrim_menu(Player player, Material option) {
        Inventory confrim_menu = Bukkit.createInventory(player,27, ChatColor.DARK_GREEN+"CONFIRM OPTION");

        ItemStack option_item = new ItemStack(option);
        ItemMeta option_meta = option_item.getItemMeta();
        if(option == Material.ARMOR_STAND){
            option_meta.setDisplayName(ChatColor.YELLOW + "Give Arms?");
            option_item.setItemMeta(option_meta);
        }else if(option == Material.LANTERN){
            option_meta.setDisplayName(ChatColor.YELLOW + "Add Glow?");
            option_item.setItemMeta(option_meta);
        }else if(option == Material.ANDESITE_SLAB){
            option_meta.setDisplayName(ChatColor.YELLOW + "Add Base?");
            option_item.setItemMeta(option_meta);
        }

        ItemStack confirm = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta confirm_meta = confirm.getItemMeta();
        confirm_meta.setDisplayName(ChatColor.DARK_GREEN+ "YES");
        confirm.setItemMeta(confirm_meta);

        ItemStack cancel = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta cancel_meta = cancel.getItemMeta();
        cancel_meta.setDisplayName(ChatColor.DARK_RED+"NO");
        cancel.setItemMeta(cancel_meta);

        confrim_menu.setItem(13,option_item);
        confrim_menu.setItem(11,confirm);
        confrim_menu.setItem(15,cancel);

        player.openInventory(confrim_menu);
    }
}
