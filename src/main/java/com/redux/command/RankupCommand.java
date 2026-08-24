package com.redux.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.redux.player.PlayerData;
import com.redux.player.PlayerRankManager;

public class RankupCommand implements CommandExecutor {

    private final PlayerRankManager playerRank;

    public RankupCommand(PlayerRankManager playerRank) {
        this.playerRank = playerRank;
    }

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Este comando solo puede ser ejecutado por un jugador.");
            return true;
        }
        
        PlayerData currentPlayer = playerRank.getPlayer(player.getUniqueId());
        player.sendMessage("Rango actual " + currentPlayer.getRank());

        return true;
    }
}
