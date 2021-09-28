package caizii.server.arcanetravel.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Baosha implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage("你把自己爆杀了");
                player.setHealth(0);
            } else {
                //获取玩家名称 调用 Bukkit
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target instanceof Player) {
                    target.sendMessage("你被" + player.getDisplayName() + "爆杀");
                    target.setHealth(0);
                    player.sendMessage("你爆杀了" + target.getDisplayName());

                } else {
                    player.sendMessage("玩家不存在");
                }
            }


        }

        return true;
    }
}
