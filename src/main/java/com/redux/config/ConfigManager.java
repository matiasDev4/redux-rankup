package com.redux.config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {

    private final File file;
    private final FileConfiguration config;

    public ConfigManager(JavaPlugin plugin, String fileName) {

        this.file = new File(plugin.getDataFolder(), fileName);

        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
