package org.boticordjava.api.entity.bot.botssearch;

import org.boticordjava.api.entity.abstracts.AbstractComment;
import org.boticordjava.api.entity.enums.BotTags;

public class BotsSearch extends AbstractComment {

    private String discriminator;
    private String premiumBanner;
    private int guilds;
    private int shard;
    private BotTags[] tags;

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public String getPremiumBanner() {
        return premiumBanner;
    }

    public void setPremiumBanner(String premiumBanner) {
        this.premiumBanner = premiumBanner;
    }

    public int getGuilds() {
        return guilds;
    }

    public void setGuilds(int guilds) {
        this.guilds = guilds;
    }

    public int getShard() {
        return shard;
    }

    public void setShard(int shard) {
        this.shard = shard;
    }

    public BotTags[] getTags() {
        return tags;
    }

    public void setTags(BotTags[] tags) {
        this.tags = tags;
    }
}