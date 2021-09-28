package caizii.server.arcanetravel;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class ShearSheepListener implements Listener {

    @EventHandler
    public void onShearSheep(PlayerShearEntityEvent e) {

        Player player = e.getPlayer();
        Entity entity = e.getEntity();
        //判断是不是绵羊
        if (entity.getType() == EntityType.SHEEP) {
            player.sendMessage("你不能给绵羊剃毛");
            e.setCancelled(true);
        } else {
            player.sendMessage("这不是一只小绵羊");
        }
    }
}
