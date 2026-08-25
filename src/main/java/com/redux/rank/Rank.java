package com.redux.rank;

import java.util.List;

public class Rank {
    private final String id;
    private final String displayName;
    private final List<String> commands;



    public Rank(
        String id,
        String displayName,
        List<String> commands

    ) {
        this.id = id;
        this.displayName = displayName;
        this.commands = commands;

    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }


    public List<String> getCommands() {
        return commands;
    }

}