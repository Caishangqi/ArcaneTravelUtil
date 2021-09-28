package caizii.server.arcanetravel.events;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class teleportBow_event implements Listener {
    @EventHandler
    public void onBowShoot(ProjectileHitEvent event){
        //只让类型为弓箭的实体出发这个事件
        if(event.getEntity() instanceof Arrow){
            Player player = (Player) event.getEntity().getShooter();
            Location location = event.getEntity().getLocation();


            player.teleport(location);
            player.playSound(location, Sound.ENCHANT_THORNS_HIT,1,1);
        }

    }
}
