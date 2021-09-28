package caizii.server.arcanetravel.util;

import caizii.server.arcanetravel.ArcaneTravel;
import caizii.server.arcanetravel.commands.VaultCommand;

//用来测试命令注册
public class commandRegister {
    public ArcaneTravel plugin;

    public commandRegister() {
        System.out.println("初始化构造器");
    }

    public commandRegister(ArcaneTravel plugin) {
        this.plugin = plugin;
    }

    public void RegisterCommand() {
        System.out.println("指令模块开始注册");
        plugin.getCommand("vault").setExecutor(new VaultCommand());
        System.out.println("指令模块注册完毕");
    }
}
