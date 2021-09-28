package caizii.server.arcanetravel;

import caizii.server.arcanetravel.commands.*;
import caizii.server.arcanetravel.events.PlayerMove;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArcaneTravel extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("插件已经加载 -- by Caizii");
        //加载config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        //别忘了事件要监听
        getServer().getPluginManager().registerEvents(this, this);
        //在不同的class 注册事件
        getServer().getPluginManager().registerEvents(new BottleBreakListenerXP(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        //getServer().getPluginManager().registerEvents(new JoinLeaveListener(), super.plugin);
        getServer().getPluginManager().registerEvents(new PlayerMove(),this);

        //事件注册器
        eventRegister eventregister = new eventRegister(this);
        eventregister.RegisterEvent();

        //注册命令在不同class中
        getCommand("god").setExecutor(new GodCommand());
        getCommand("food").setExecutor(new FeedCommands());
        getCommand("print").setExecutor(new print());
        getCommand("setfood").setExecutor(new Setfood());
        getCommand("sendWord").setExecutor(new sendWord());
        getCommand("baosha").setExecutor(new sendWord());
        /*
        这是先创建一个命令注册器，所有的代码注册全部移动到代码注册器中注册，你需要
        在括号内写入 this 来让插件这个对象class传入 commandRegister 中。再调用
        .RegisterCommand();方法注册内部的指令
         */
        commandRegister commandregister = new commandRegister(this);
        commandregister.RegisterCommand();

        getCommand("fly").setExecutor(new FlyCommand(this));
        //把这个this 插件主类(class)传入 FlyCommand中，这样在每次构造新的FlyCommand()中，里面的private plugin 会被参数占用
        //从而让FlyCommand()也可以调用主类的所有方法


    }

    //注册指令
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // /die -kills player
        if (command.getName().equalsIgnoreCase("die")) {
            if (sender instanceof Player p) {

                p.setHealth(0.0);
                p.sendMessage(ChatColor.RED + "你使用指令死亡");

            } else if (sender instanceof ConsoleCommandSender) {
                System.out.println("该指令只能由玩家执行");
            }

        }
/*        if (command.getName().equalsIgnoreCase("print")){
            Player player = (Player) sender;
            String food = getConfig().getString("Food");
            //活动yml中FoodList第三个物品
            String thirdItems = getConfig().getStringList("FoodList").get(2);
            player.sendMessage(ChatColor.DARK_PURPLE + "在yml中的food 为 " + ChatColor.RED + food);
            player.sendMessage(ChatColor.DARK_PURPLE + "在yml中FoodList第三个元素 为 " + ChatColor.RED + thirdItems);

        }*/
        return true;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("插件已经关闭");
    }

    //事件监听
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        System.out.println("玩家加入服务器");
        event.setJoinMessage("欢迎你他妈加入服务器");
    }


    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event) {

        Player player = event.getPlayer();
        player.setHealth(0);
        player.sendMessage("你下床了,然后死了");

    }
}
