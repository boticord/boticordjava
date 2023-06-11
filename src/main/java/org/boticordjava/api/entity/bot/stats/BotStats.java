package org.boticordjava.api.entity.bot.stats;

public class BotStats {

    private Integer members;
    private Integer guilds;

    public BotStats(Integer members, Integer guilds, Integer shards) {
        this.members = members;
        this.guilds = guilds;
        this.shards = shards;
    }

    private Integer shards;

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public Integer getGuilds() {
        return guilds;
    }

    public void setGuilds(Integer guilds) {
        this.guilds = guilds;
    }

    public Integer getShards() {
        return shards;
    }

    public void setShards(Integer shards) {
        this.shards = shards;
    }
}
