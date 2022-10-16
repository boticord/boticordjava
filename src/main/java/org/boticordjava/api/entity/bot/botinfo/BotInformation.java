package org.boticordjava.api.entity.bot.botinfo;

import org.boticordjava.api.entity.abstracts.Information;
import org.boticordjava.api.entity.bot.stats.BotStats;

import java.util.Arrays;

public class BotInformation extends Information {

    private Integer bumps;
    private Integer added;
    private String prefix;
    private Long permissions;
    private String[] developers;
    private Links links;
    private String library;
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

    public String[] getDevelopers() {
        return developers;
    }

    public Links getLinks() {
        return links;
    }

    public String getLibrary() {
        return library;
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
                "\ntags: " + Arrays.toString(this.getTags()) +
                "\ndevelopers: " + Arrays.toString(developers) +
                "\nlinks: " + links +
                "\nlibrary: " + library +
                "\nshortDescription: " + this.getShortDescription() +
                "\nlongDescription: " + this.getLongDescription() +
                "\nbadge: " + this.getBadge() +
                "\nstats: " + stats +
                "\nstatus: " + status +
                "\n";
    }
}