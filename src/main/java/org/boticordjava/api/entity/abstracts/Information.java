package org.boticordjava.api.entity.abstracts;

public class Information {

    private String[] tags;
    private String shortDescription;
    private String longDescription;
    private Integer badge;

    public String[] getTags() {
        return tags;
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
}
