package org.boticordjava.api.entity.bot.botinfo;

import org.boticordjava.api.entity.bot.stats.BotStats;

import java.util.List;

public class BotInformation {

    private Integer bumps;
    private Integer added;
    private String prefix;
    private Long permissions;
    private List<String> tags;
    private List<String> developers;
    private Links links;
    private String library;
    private String shortDescription;
    private String longDescription;
    private Integer badge;
    private BotStats stats;
    private String status;

    public Integer getBumps() {
        return bumps;
    }

    public Integer getAdded() {
        return added;
    }

    public String getPrefix() {
        return prefix;
    }

    public Long getPermissions() {
        return permissions;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<String> getDevelopers() {
        return developers;
    }

    public Links getLinks() {
        return links;
    }

    public String getLibrary() {
        return library;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public Integer getBadge() {
        return badge;
    }

    public BotStats getStats() {
        return stats;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "" +
                "bumps: " + bumps +
                "\nadded: " + added +
                "\nprefix: " + prefix +
                "\npermissions: " + permissions +
                "\ntags: " + tags +
                "\ndevelopers: " + developers +
                "\nlinks: " + links +
                "\nlibrary: " + library +
                "\nshortDescription: " + shortDescription +
                "\nlongDescription: " + longDescription +
                "\nbadge: " + badge +
                "\nstats: " + stats +
                "\nstatus: " + status +
                "\n";
    }
}