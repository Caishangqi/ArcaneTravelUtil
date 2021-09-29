package caizii.server.arcanetravel.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainGUI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Inventory GUI = Bukkit.createInventory(player,9,"Arcane Travel");

            ItemStack item1 = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
            ItemMeta item1_meta = item1.getItemMeta();
            item1_meta.setDisplayName("Help");
            item1.setItemMeta(item1_meta);

            ItemStack item2 = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
            ItemMeta item2_meta = item2.getItemMeta();
            item2_meta.setDisplayName("Setting");
            item2.setItemMeta(item2_meta);

            GUI.addItem(item1,item2);

            player.openInventory(GUI);
        }



        return true;


    }
}
