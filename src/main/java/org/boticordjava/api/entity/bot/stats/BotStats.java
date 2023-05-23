package org.boticordjava.api.entity.bot.stats;

public class BotStats {

    private Integer servers;
    private Integer shards;
    private Integer users;

    public Integer getServers() {
        return servers;
    }

    public Integer getShards() {
        return shards;
    }

    public Integer getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "servers: " + servers +
                "\nshards: " + shards +
                "\nusers: " + users +
                "\n";
    }
}
