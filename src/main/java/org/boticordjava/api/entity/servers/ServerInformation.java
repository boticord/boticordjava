package org.boticordjava.api.entity.servers;

import java.util.Arrays;
import java.util.List;

public class ServerInformation {

    private String name;
    private String avatar;
    private String[] members;
    private String owner;
    private String bumps;
    private List<String> tags;

    //TODO: Здесь ошибка Expected BEGIN_ARRAY but was BEGIN_OBJECT если использовать List<String> или String[]
    private ServerShortLinks links;

    private String shortDescription;
    private String longDescription;
    private Integer badge;

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public Integer getBadge() {
        return badge;
    }

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

    public List<String> getTags() {
        return tags;
    }

    public ServerShortLinks getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "ServerInformation{" +
                "name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", members=" + Arrays.toString(members) +
                ", owner='" + owner + '\'' +
                ", bumps='" + bumps + '\'' +
                ", tags=" + tags +
                ", links=" + links +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", badge=" + badge +
                '}';
    }
}
