package caizii.server.arcanetravel.commands;

import caizii.server.arcanetravel.ArcaneTravel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class Setfood implements CommandExecutor {
    //导入插件主类
    Plugin plugin = ArcaneTravel.getPlugin(ArcaneTravel.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.getConfig().set("Food","设置后的默认值");
        return true;
    }
}
