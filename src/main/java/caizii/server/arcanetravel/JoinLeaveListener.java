package caizii.server.arcanetravel;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class JoinLeaveListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        if (player.hasPlayedBefore()){
            e.setJoinMessage(ChatColor.GREEN + "欢迎回来" + ChatColor.YELLOW + "" + ChatColor.BOLD + player.getDisplayName());
        } else {
            e.setJoinMessage(ChatColor.BLUE + ""+ ChatColor.BOLD + player.getDisplayName() + "," + ChatColor.BLUE + "欢迎新冒险者加入我们");

        }
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + player.getDisplayName() + ChatColor.RED + "离开了奥术旅途");
    }
}
