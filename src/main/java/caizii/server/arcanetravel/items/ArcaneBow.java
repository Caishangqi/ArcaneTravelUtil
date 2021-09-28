package caizii.server.arcanetravel.items;

import caizii.server.arcanetravel.ArcaneTravel;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


public class ArcaneBow {
    ArcaneTravel plugin;

    public ArcaneBow(ArcaneTravel plugin) {
        this.plugin = plugin;
    }

    public void get_Arcane_bow(Player player){
        ItemStack teleport_bow = new ItemStack(Material.BOW);
        teleport_bow.addEnchantment(Enchantment.ARROW_INFINITE,1);

        ItemMeta meta = teleport_bow.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("bow-name")));
        meta.setUnbreakable(true);
        //添加一个ArrayList
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("bow-description")));
        meta.setLore(lore);
        teleport_bow.setItemMeta(meta);
        player.getInventory().addItem(teleport_bow);
    }
}
