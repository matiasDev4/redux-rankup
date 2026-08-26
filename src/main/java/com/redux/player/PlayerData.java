package com.redux.player;

import java.util.UUID;

public class PlayerData {
    private final UUID uuid;
    private final String username;
    private final String rankName;
    

    public PlayerData(
        UUID uuid,
        String username,
        String rankName
    ) {
        this.uuid = uuid;
        this.username = username;
        this.rankName = rankName;
    }


    public String getRankName() {return rankName;}
    public String getUsername() {return username;}
    public UUID getUUID() {return uuid;}
    
}
