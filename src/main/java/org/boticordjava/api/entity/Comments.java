package org.boticordjava.api.entity;

import com.google.gson.annotations.SerializedName;

public class Comments {

    @SerializedName("userID")
    private String userId;
    private String text;
    private Integer vote;
    private boolean isUpdated;
    private String createdAt;

    public String getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public Integer getVote() {
        return vote;
    }

    public boolean isUpdated() {
        return isUpdated;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
