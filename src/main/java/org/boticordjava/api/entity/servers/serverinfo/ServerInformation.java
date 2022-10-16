package org.boticordjava.api.entity.servers.serverinfo;

import org.boticordjava.api.entity.abstracts.Information;

import java.util.Arrays;

public class ServerInformation extends Information {

    private String name;
    private String avatar;
    private String[] members;
    private String owner;
    private String bumps;
    private ServerLinks links;

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String[] getMembers() {
        return members;
    }

    public String getOwner() {
        return owner;
    }

    public String getBumps() {
        return bumps;
    }

    public ServerLinks getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "ServerInformation: " +
                "\nname: " + name +
                "\navatar: " + avatar +
                "\nmembers: " + Arrays.toString(members) +
                "\nowner: " + owner +
                "\nbumps: " + bumps +
                "\ntags: " + Arrays.toString(this.getTags()) +
                "\nlinks: " + links +
                "\nshortDescription: " + this.getShortDescription() +
                "\nlongDescription: " + this.getLongDescription() +
                "\nbadge: " + this.getBadge() +
                "\n";
    }
}
