package caizii.server.arcanetravel.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AS_armor_menu {
    static public void AS_armor_menu(Player player){
        Inventory armorMenu = Bukkit.createInventory(player,45, ChatColor.DARK_BLUE + "Choose some Armor");

        //HEAD
        ItemStack head = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack body = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_LEGGINGS);



        ItemStack confirm = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta confirm_meta = confirm.getItemMeta();
        confirm_meta.setDisplayName(ChatColor.GREEN + "DONE");
        confirm.setItemMeta(confirm_meta);

        armorMenu.setItem(11,head);
        armorMenu.setItem(12,body);
        armorMenu.setItem(14,legs);
        armorMenu.setItem(15,boots);
        armorMenu.setItem(40,confirm);

        player.openInventory(armorMenu);

    }
}
