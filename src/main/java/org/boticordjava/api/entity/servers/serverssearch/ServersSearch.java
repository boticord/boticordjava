package org.boticordjava.api.entity.servers.serverssearch;

import org.boticordjava.api.entity.abstracts.AbstractComment;
import org.boticordjava.api.entity.enums.ServerTags;

public class ServersSearch extends AbstractComment {

    private String discordBanner;
    private ServerTags[] tags;


    public String getDiscordBanner() {
        return discordBanner;
    }

    public void setDiscordBanner(String discordBanner) {
        this.discordBanner = discordBanner;
    }

    public ServerTags[] getTags() {
        return tags;
    }

    public void setTags(ServerTags[] tags) {
        this.tags = tags;
    }
}