package com.redux.rank;

import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class RankManager {
    private final HashMap<String, Rank> ranks = new HashMap<>();


    public RankManager(FileConfiguration config) {
        ConfigurationSection section = config.getConfigurationSection("ranks");



        if (section == null) return;
  

        for (String id : section.getKeys(false)){
            String displayName = section.getString(id + ".display-name");

            List<String> commands = section.getStringList(id + ".commands");


            Rank rank = new Rank(id, displayName, commands);

            ranks.put(id, rank);
        }



    }

    public Rank getRank(String id) {
        return ranks.get(id);
    }


}
