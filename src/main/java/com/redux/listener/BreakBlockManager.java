package com.redux.listener;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class BreakBlockManager {
    private final HashMap<Material, Integer> breakBlocks = new HashMap<>();

    public BreakBlockManager(FileConfiguration config) {
        ConfigurationSection section = config.getConfigurationSection("blocks");


        for (String id : section.getKeys(false)) {

            Material material = Material.matchMaterial(id);

            if (material == null) {
                continue;
            }

            int value = section.getInt(id);

            breakBlocks.put(material, value);
        }
    }

    public Integer getValueBlock(Material id){
        return breakBlocks.get(id);
    } 

    public HashMap<Material, Integer> getBlocks() {
        return breakBlocks;
    }
}
