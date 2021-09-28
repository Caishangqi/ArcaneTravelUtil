package caizii.server.arcanetravel.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class sendWord implements CommandExecutor {
    //带参数的指令 使用args Array
    //command 后面的都叫做 args
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("garbage")) {
                    player.sendMessage("你是垃圾");
                } else if (args[0].equalsIgnoreCase("tree")) {
                    player.sendMessage("你是一棵树");
                } else {
                    player.sendMessage("你是一个" + args[0]);
                }
            } else {
                player.sendMessage("你必须指定参数");
                player.sendMessage("/sendWord [world]");
            }


        } else {
            System.out.println("你必须是玩家才能使用该指令!");
        }

        return true;
    }
}
