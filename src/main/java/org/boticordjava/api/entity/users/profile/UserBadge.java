package org.boticordjava.api.entity.users.profile;

public class UserBadge {

    private long id;
    private String name;
    private String assetURL;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAssetURL() {
        return assetURL;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssetURL(String assetURL) {
        this.assetURL = assetURL;
    }
}