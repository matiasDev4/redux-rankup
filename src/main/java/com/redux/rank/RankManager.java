package com.redux.rank;

import java.util.HashMap;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class RankManager {
    private final HashMap<String, Rank> ranks = new HashMap<>();

    public RankManager(FileConfiguration config) {
        ConfigurationSection section = config.getConfigurationSection("ranks");

        if (section == null) return;

        for (String id : section.getKeys(false)){
            String displayName = section.getString(id + ".display-name");

            int expRequire = section.getInt(id + ".exp-require");
            String nextRank = section.getString(id + ".next");

            Rank rank = new Rank(id, displayName, nextRank, expRequire);

            ranks.put(id, rank);
        }
    }

    public Rank getRank(String id) {
        return ranks.get(id);
    }
}
