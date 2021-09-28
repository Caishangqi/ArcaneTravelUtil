package caizii.server.arcanetravel.commands;

import caizii.server.arcanetravel.ArcaneTravel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {
    //储存飞行玩家
    private ArrayList<Player> list_of_flying_player = new ArrayList<>();

    //导入插件主类 加载config.yml
    private ArcaneTravel plugin;

    //这是一个构造器 含参的
    public FlyCommand(ArcaneTravel plugin) {

        this.plugin = plugin;

    }

    public FlyCommand() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                flyMethod(player);
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                flyMethod(target);
            }

        }
        return true;
    }

    private void flyMethod(Player player) {
        if (player.hasPermission("at.fly")) {
            if (list_of_flying_player.contains(player)) {
                list_of_flying_player.remove(player);
                player.setAllowFlight(false);
                player.sendMessage("你现在不能飞行了");
            } else if (!list_of_flying_player.contains(player)) {
                list_of_flying_player.add(player);
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("on-message")));
            }
        } else {    //自动转换颜色代码
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("off-message")));
        }
    }
}
