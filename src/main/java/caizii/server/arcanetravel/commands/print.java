package caizii.server.arcanetravel.commands;

import caizii.server.arcanetravel.ArcaneTravel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class print implements CommandExecutor {

    //导入插件主类
    Plugin plugin = ArcaneTravel.getPlugin(ArcaneTravel.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //获得plugin的yml
        String food = plugin.getConfig().getString("Food");

        Player player = (Player) sender;

        player.sendMessage(food);
        return true;
    }
}
