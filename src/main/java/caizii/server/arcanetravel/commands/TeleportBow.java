package caizii.server.arcanetravel.commands;

import caizii.server.arcanetravel.ArcaneTravel;
import caizii.server.arcanetravel.items.ArcaneBow;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

//使用指令给予玩家奥术弓箭

public class TeleportBow implements CommandExecutor {

    private ArcaneTravel plugin;
    public TeleportBow(ArcaneTravel plugin){
        this.plugin = plugin;

    }

    @Override //提示你覆盖了父类的方法 接口定制规则但是不实现，留给实现类
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("at.tpbow")) {
                ArcaneBow bow = new ArcaneBow(plugin);
                bow.get_Arcane_bow(player);

            } else {
                player.sendMessage(ChatColor.RED + "你没有指定权限");
            }
        } else {
            System.out.println("该指令只能由玩家使用");
        }
        return true;
    }
}
