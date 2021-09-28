package caizii.server.arcanetravel.events;

import caizii.server.arcanetravel.ArcaneTravel;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SpawnItem_event implements Listener {

    ArcaneTravel plugin;

    public SpawnItem_event(ArcaneTravel plugin) {
        this.plugin = plugin;
    }

    public void onSpawnEvent(PlayerJoinEvent event){
    if (plugin.getConfig().getBoolean("give-bow-on-join")){

    }

    }
}
