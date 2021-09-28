package caizii.server.arcanetravel.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class VaultCommand implements CommandExecutor {
    //让玩家打开一个自定义背包 GUI
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            //创建一个界面，或者是背包
            Inventory vault = Bukkit.createInventory(p, 9, "你的背包");
            //创建一个物品
            ItemStack item1 = new ItemStack(Material.CLAY_BALL, 2);
            //给物品附魔
            item1.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE,4);

            //新建一个 meta 值-------------------------------
            ItemMeta meta = item1.getItemMeta();
            meta.setDisplayName(ChatColor.AQUA + "物品名称");
            meta.setUnbreakable(true);
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "金色闪光");
            lore.add(ChatColor.DARK_PURPLE + "紫色忧郁");
            meta.setLore(lore);
            //----------------新建meta值完毕------------------
            item1.setItemMeta(meta); //使用我们建立的meta值

/*            ItemStack item2 = new ItemStack(Material.BLACK_SHULKER_BOX, 1);
            //itemstack也可以创建数组物品
            ItemStack[] items = {item1, item2};

            vault.setItem(2, item1);
            //setContends会覆盖之前的物品，直接使用Array内的物品
            vault.setContents(items);

            //获取玩家的背包物品把他存放在一个ItemStack中
            ItemStack[] playerinv = vault.getContents();*/
            vault.addItem(item1);
            p.openInventory(vault);
        } else {
            System.out.println("该指令只能由玩家执行");
        }
        return true;
    }
}
