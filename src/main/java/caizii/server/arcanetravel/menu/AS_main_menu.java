package caizii.server.arcanetravel.menu;

import caizii.server.arcanetravel.ArcaneTravel;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AS_main_menu {

    public void AS_main_menu(Player player){
        Inventory as_gui = Bukkit.createInventory(player,9, ChatColor.BLACK + "ArmourStand GUi");

        ItemStack create = new ItemStack(Material.ARMOR_STAND);
        ItemMeta create_meta = create.getItemMeta();
        create_meta.setDisplayName(ChatColor.GREEN + "Create");
        ArrayList<String> create_lore = new ArrayList<>();
        create_lore.add(ChatColor.GRAY + "Create a new ArmorStand");
        create_meta.setLore(create_lore);
        create.setItemMeta(create_meta);

        ItemStack close = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta close_meta = close.getItemMeta();
        close_meta.setDisplayName(ChatColor.RED + "CLOSE");
        close.setItemMeta(close_meta);

        as_gui.setItem(2,create);
        as_gui.setItem(6,close);

        player.openInventory(as_gui);

    }
}
