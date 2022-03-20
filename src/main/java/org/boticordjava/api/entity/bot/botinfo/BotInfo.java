package org.boticordjava.api.entity.bot.botinfo;

import java.util.List;

public class BotInfo {

    private String id;
    private String shortCode;
    private List<String> links;
    private Server server;
    private BotInformation information;

    public String getId() {
        return id;
    }

    public String getShortCode() {
        return shortCode;
    }

    public List<String> getLinks() {
        return links;
    }

    public Server getServer() {
        return server;
    }

    public BotInformation getInformation() {
        return information;
    }
}
