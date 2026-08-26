package com.redux;

import org.bukkit.plugin.java.JavaPlugin;

import com.redux.config.ConfigManager;

public final class ReduxMain extends JavaPlugin {

    private ConfigManager rankConfig;

    @Override
    public void onEnable() {
        rankConfig = new ConfigManager(this, "rankup-config.yml");
        
        getLogger().info("Rankup iniciado");
    }

}