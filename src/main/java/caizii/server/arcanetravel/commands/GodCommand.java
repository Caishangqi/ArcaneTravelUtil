package caizii.server.arcanetravel.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;
            if (p.isInvulnerable()) {

                p.setInvulnerable(false);
                p.sendMessage(ChatColor.YELLOW + "已关闭无敌");
            } else {

                p.setInvulnerable(true);
                p.sendMessage(ChatColor.GRAY + "已开启无敌");

            }


        }
        return true;
    }
}
