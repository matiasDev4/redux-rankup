package com.redux.player;

import java.util.HashMap;
import java.util.UUID;

// Manejar 
// dinero actual
// nivel de rango o experiencia acumulada

public class PlayerRankManager {

    private final HashMap<UUID, PlayerData> players;

    public PlayerRankManager() {
        this.players = new HashMap<>();
    }

    public HashMap<UUID, PlayerData> getPlayers() {
        return players;
    }

    public PlayerData getPlayer(UUID uuid) {
        return players.get(uuid);
    }


    public void addPlayer(UUID uuid, PlayerData player) {
        players.put(uuid, player);
    }

    public PlayerData getOrCreatePlayer(UUID uuid, String username) {
        return players.computeIfAbsent(uuid, id -> new PlayerData(username));
    }
}
