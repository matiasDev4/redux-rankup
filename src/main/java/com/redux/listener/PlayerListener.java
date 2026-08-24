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

public class PlayerListener implements Listener {
    private PlayerRankManager playerRank;
    private BreakBlockManager breakBlockManager;
    private RankManager rankManager;
    private final Logger logger;

    public PlayerListener(
        Logger logger, 
        PlayerRankManager playerRank, 
        BreakBlockManager breakBlockManager,
        RankManager rankManager
        
    ) {
        this.logger = logger;
        this.playerRank = playerRank;
        this.breakBlockManager = breakBlockManager;
        this.rankManager = rankManager;
    }
    private String createProgressBar(int current, int max) {

        int bars = 20;

        double percentage = (double) current / max;

        int completed = (int) (percentage * bars);

        return "█".repeat(completed)
                + "░".repeat(bars - completed);
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
        Integer block_value = breakBlockManager.getValueBlock(current_block.getType());

        if (block_value == null) return;
        
        PlayerData playerData = playerRank.getPlayer(player.getUniqueId());
        if (playerData == null) return;

        Rank rank = rankManager.getRank(playerData.getRank());
        if (rank == null){
            logger.warning("No se encontro el rango");
            return;
        }
        if (rank.getNextRank() == null) return; // si no exite otro rango, no pasa

        playerData.addExperience(block_value);
        String progress = createProgressBar(
            playerData.getExperience(),
            rank.getExpRequire()
        );

        String text = rank.getDisplayName()
            + " "
            + progress
            + " "
            + playerData.getExperience()
            + "/"
            + rank.getExpRequire();
        
        player.sendActionBar(
            Component.text(text)
        );

        while (
            rank.getNextRank() != null &&
            playerData.getExperience() >= rank.getExpRequire()
        ) {

            playerData.addExperience(
                playerData.getExperience() -
                rank.getExpRequire()
            );

            playerData.setRank(
                rank.getNextRank()
            );

            rank =
                rankManager.getRank(
                    playerData.getRank()
                );

            player.sendMessage(
                "Subiste de rango! " +
                rank.getDisplayName()
            );
        }


    }

    // Sumar experiencia al matar mobs

}
