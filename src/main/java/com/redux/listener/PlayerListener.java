package com.redux.listener;

import java.util.logging.Logger;

import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import net.kyori.adventure.text.Component;

import com.redux.player.PlayerData;
import com.redux.player.PlayerRankManager;
import com.redux.rank.Rank;
import com.redux.rank.RankManager;
import com.redux.services.ProgressionService;

public class PlayerListener implements Listener {
    private PlayerRankManager playerRank;
    private BreakBlockManager breakBlockManager;
    private RankManager rankManager;
    private ProgressionService progressionService;
    private final Logger logger;

    public PlayerListener(
        Logger logger, 
        PlayerRankManager playerRank, 
        BreakBlockManager breakBlockManager,
        RankManager rankManager,
        ProgressionService progressionService
        
    ) {
        this.logger = logger;
        this.playerRank = playerRank;
        this.breakBlockManager = breakBlockManager;
        this.rankManager = rankManager;
        this.progressionService = progressionService;
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        try {
            Player player = event.getPlayer();

            PlayerData playerData = playerRank.getOrCreatePlayer(player.getUniqueId(), player.getName());
            
            logger.info("Ingreso el jugador, cargando PlayerData | Usuario " + playerData.getUsername());
        } catch (Exception e) {
            logger.severe("Error en el Listener Join " + e);
        }
    }

    // Sumar experiencia al romper bloques
    @EventHandler
    public void BreakBlock(BlockBreakEvent block) {
        Player player = block.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE) return;

        Block current_block = block.getBlock();
        Double block_value = breakBlockManager.getValueBlock(current_block.getType());
  
        if (block_value == null) return;
        
  

    }
        
    // Sumar experiencia al matar mobs

}
