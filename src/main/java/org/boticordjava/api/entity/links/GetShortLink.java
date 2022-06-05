package org.boticordjava.api.entity.links;

public class GetShortLink {

    private Integer id;
    private String code;
    private String ownerID;
    private String domain;
    private Integer views;
    private String link;
    private Long date;

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public String getDomain() {
        return domain;
    }

    public Integer getViews() {
        return views;
    }

    public String getLink() {
        return link;
    }

    public Long getDate() {
        return date;
    }
}
