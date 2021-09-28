package caizii.server.arcanetravel.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMOve(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if (!(player.hasPermission("at.move"))){

            event.setCancelled(true);

        }
    }

}
