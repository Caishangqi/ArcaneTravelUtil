package caizii.server.arcanetravel.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player p = (Player) sender;
            //增加权限系统
            if (p.hasPermission("at.food")) {
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "已恢复饥饿值");
            } else {
                p.sendMessage(ChatColor.RED + "" +ChatColor.BOLD + "你没有指定权限");
            }

        }
        return true;
    }
}
