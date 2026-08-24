package com.redux.rank;

public class Rank {
    private final String id;
    private final String displayName;
    private final String nextRank;
    private final int expRequire;

    public Rank(
        String id,
        String displayName,
        String nextRank,
        int expRequire
    ) {
        this.id = id;
        this.displayName = displayName;
        this.expRequire = expRequire;
        this.nextRank = nextRank;
    }

    public String getId() {
        return id;
    }
    
    public int getExpRequire() {
        return expRequire;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getNextRank() {
        return nextRank;
    }

}