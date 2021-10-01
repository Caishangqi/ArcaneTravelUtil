package caizii.server.arcanetravel.commands;

import caizii.server.arcanetravel.files.ConfigFile;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        ConfigFile.reload();
        player.sendMessage(ChatColor.YELLOW+"已重新加载配置文件");
        return true;
    }
}
