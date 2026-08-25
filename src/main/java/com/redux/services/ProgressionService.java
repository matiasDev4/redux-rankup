package com.redux.services;


import org.bukkit.entity.Player;

import com.redux.player.PlayerData;
import com.redux.player.PlayerRankManager;
import com.redux.rank.Rank;
import com.redux.rank.RankManager;

public class ProgressionService {
    private final PlayerRankManager playerRankManager;
    private final RankManager rankManager;

    public ProgressionService(
        PlayerRankManager playerRankManager,
        RankManager rankManager
    ) {
        this.rankManager = rankManager;
        this.playerRankManager = playerRankManager;
    }



}
