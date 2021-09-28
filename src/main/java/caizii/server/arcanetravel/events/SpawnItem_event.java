package caizii.server.arcanetravel.events;

import caizii.server.arcanetravel.ArcaneTravel;
import caizii.server.arcanetravel.items.ArcaneBow;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SpawnItem_event implements Listener {

    ArcaneTravel plugin;

    public SpawnItem_event(ArcaneTravel plugin) {
        this.plugin = plugin;
    }
    //在进入服务器时依据配置文件自动给予玩家奥术弓箭
    public void onSpawnEvent(PlayerJoinEvent event){
    if (plugin.getConfig().getBoolean("give-bow-on-join")){
        Player player = event.getPlayer();
        ArcaneBow bow = new ArcaneBow(plugin);
        bow.get_Arcane_bow(player);
    }

    }
}
