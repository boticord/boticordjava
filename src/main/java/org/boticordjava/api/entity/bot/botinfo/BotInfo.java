package org.boticordjava.api.entity.bot.botinfo;

import java.util.List;

public class BotInfo {

    private String id;
    private String shortCode;
    private List<String> links;
    private Information information;

    public Information getInformation() {
        return information;
    }

    public String getId() {
        return id;
    }

    public String getShortCode() {
        return shortCode;
    }

    public List<String> getLinks() {
        return links;
    }
}