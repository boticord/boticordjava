package org.boticordjava.api.entity.bot.botinfo;

import org.boticordjava.api.entity.abstracts.Info;
import org.boticordjava.api.entity.abstracts.AbstractInfo;

import java.util.List;

public class BotInfo {

    private String id;
    private String shortCode;
    private List<String> links;
    private Info server;
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

    public AbstractInfo getServer() {
        return server;
    }

    public BotInformation getInformation() {
        return information;
    }
}
