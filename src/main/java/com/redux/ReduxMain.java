package com.redux;

import org.bukkit.plugin.java.JavaPlugin;

import com.redux.command.RankupCommand;
import com.redux.config.ConfigManager;
import com.redux.listener.BreakBlockManager;
import com.redux.listener.PlayerListener;
import com.redux.player.PlayerRankManager;
import com.redux.rank.RankManager;

public final class ReduxMain extends JavaPlugin {

    private PlayerRankManager playerRankManager;

    public ReduxMain() {
        this.playerRankManager = new PlayerRankManager();
    }

    @Override
    public void onEnable() {

        ConfigManager rankConfig = new ConfigManager(this, "rankup-config.yml");
        ConfigManager breakBlockConfig = new ConfigManager(this, "break-block-config.yml");
        

        RankManager rankManager = new RankManager(rankConfig.getConfig());
        BreakBlockManager breakBlockManager = new BreakBlockManager(breakBlockConfig.getConfig());
        
        
        getServer()
        .getPluginManager()
        .registerEvents(new PlayerListener(getLogger(), playerRankManager, breakBlockManager, rankManager), this);

        getCommand("rank")
        .setExecutor(new RankupCommand(playerRankManager));

        getLogger().info("Rankup iniciado");
    }

}