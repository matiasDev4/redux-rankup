package com.redux.rank;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class RankConfig {

    public RankConfig(
        FileConfiguration config
    ){

        ConfigurationSection rankSection = config.getConfigurationSection("ranks");
        
    }

    

}
