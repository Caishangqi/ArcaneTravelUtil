package caizii.server.arcanetravel.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class AS_create_menu {

    static public void AS_create_menu(Player player) {
        Inventory AS_create_menu = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "Create a ArmorStand");

        ItemStack arms = new ItemStack(Material.ARMOR_STAND);
        ItemStack glow = new ItemStack(Material.LANTERN);
        ItemStack armor = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack base = new ItemStack(Material.ANDESITE_SLAB);
        ItemStack confirm = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemStack cancel = new ItemStack(Material.RED_STAINED_GLASS_PANE);

        ItemMeta arms_meta = arms.getItemMeta();
        arms_meta.setDisplayName("Set arms");
        arms.setItemMeta(arms_meta);

        ItemMeta glow_meta = glow.getItemMeta();
        glow_meta.setDisplayName("Set glowing or not");
        glow.setItemMeta(glow_meta);

        ItemMeta armor_meta = armor.getItemMeta();
        armor_meta.setDisplayName("Set armor stand armor");
        armor.setItemMeta(armor_meta);

        ItemMeta base_meta = base.getItemMeta();
        base_meta.setDisplayName("Set base or not");
        base.setItemMeta(base_meta);

        ItemMeta confirm_meta = confirm.getItemMeta();
        confirm_meta.setDisplayName(ChatColor.DARK_GREEN + "CONFIRM");
        confirm.setItemMeta(confirm_meta);

        ItemMeta cancel_meta = cancel.getItemMeta();
        cancel_meta.setDisplayName(ChatColor.DARK_RED + "CANCEL");
        cancel.setItemMeta(cancel_meta);

        AS_create_menu.setItem(0, arms);
        AS_create_menu.setItem(1, glow);
        AS_create_menu.setItem(2, armor);
        AS_create_menu.setItem(3, base);
        AS_create_menu.setItem(7, confirm);
        AS_create_menu.setItem(8, cancel);

        player.openInventory(AS_create_menu);
    }

}
