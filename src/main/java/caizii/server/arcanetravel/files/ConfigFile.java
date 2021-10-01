package caizii.server.arcanetravel.files;


import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigFile {

    private static File file; //直接从电脑文件夹中的IO方法，然后把File Object转换成 FileConfiguration Object
    private static FileConfiguration customFile;

    //找或者生成自定义配置文件
    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ArcaneTravel").getDataFolder(), "customconfig.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                //ops
            }

        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile() {
        return customFile;
    }

    public static void SaveFile() {
        try {
            customFile.save(file);
        } catch (IOException e) {
            System.out.println("无法保存文件");
        }
    }

    public static void reload() {
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
