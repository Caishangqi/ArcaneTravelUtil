package caizii.server.arcanetravel.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EntityMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){

       /* Player player = event.getPlayer();

        player.getWorld().spawnEntity(player.getLocation(), EntityType.LIGHTNING);*/

        //玩家移动时在指定地点生成闪电
        /*Entity entity = Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"),560,77,-545),EntityType.LIGHTNING);
        entity.setGravity(false);
        entity.setGlowing(true);
        entity.setCustomName("闪电");
        entity.setCustomNameVisible(true);*/
    }


}
