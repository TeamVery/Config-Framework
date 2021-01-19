package com.teamvery.configframework;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class cfg {

    private static File file;
    public static FileConfiguration config;

    public static void makeData(String Plugin_Name, String yml) {
        try {
            file = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin(Plugin_Name)).getDataFolder(), yml);
            if (!file.exists()) {
                Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin(Plugin_Name)).saveResource(yml, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    @Deprecated
    public static void setup(String Plugin_Name, String yml) {
        file = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin(Plugin_Name)).getDataFolder(), yml);

        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                System.out.println("알수 없는 오류로 콘피그 파일을 생성할수 없습니다.");
            }Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin(Plugin_Name)).saveResource(yml, true);
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(String Plugin_Name, String yml) {
        file = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin(Plugin_Name)).getDataFolder(), yml);

        config = YamlConfiguration.loadConfiguration(file);
        return config;
    }

    @Deprecated
    public static void save(String Plugin_Name, String yml) {
        file = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin(Plugin_Name)).getDataFolder(), yml);

        config = YamlConfiguration.loadConfiguration(file);

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reload(String Plugin_Name, String yml){
        file = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin(Plugin_Name)).getDataFolder(), yml);

        config = YamlConfiguration.loadConfiguration(file);
    }
}
