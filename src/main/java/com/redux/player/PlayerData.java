package com.redux.player;

public class PlayerData {

    private String username;
    private int levelRank;
    private String rank;

    public PlayerData(String username) {
        this.username = username;
        this.levelRank = 1;
        this.rank = "default";
    }

    public int getLevelRank() {
        return levelRank;
    }



    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setLevelRank(int levelRank) {
        this.levelRank = levelRank;
    }

    public String getUsername() {
        return username;
    }


}   
