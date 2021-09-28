package caizii.server.arcanetravel.util;

import caizii.server.arcanetravel.ArcaneTravel;
import org.bukkit.ChatColor;

public class util {


    static public ArcaneTravel plugin;
    public util(ArcaneTravel plugin){
        this.plugin = plugin;
    }


    //设置配置文件
    static public void setconfig(String config){
        plugin.getConfig().getString(ChatColor.translateAlternateColorCodes('&',config));

    }
}
