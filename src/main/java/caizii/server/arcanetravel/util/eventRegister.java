package caizii.server.arcanetravel.util;

import caizii.server.arcanetravel.ArcaneTravel;
import caizii.server.arcanetravel.JoinLeaveListener;
import caizii.server.arcanetravel.util.commandRegister;

//事件注册器，用来集中注册事件
public class eventRegister extends commandRegister {

    public eventRegister(ArcaneTravel plugin){
        this.plugin = plugin;
    }

    public void RegisterEvent(){
        System.out.println("事件模块开始注册");
        plugin.getServer().getPluginManager().registerEvents(new JoinLeaveListener(),plugin);
        System.out.println("事件模块注册完毕");
    }

}
