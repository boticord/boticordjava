package org.boticordjava.api.entity.webhooks.comment;

import com.google.gson.annotations.SerializedName;

public class Vote {

    @SerializedName("old")
    private String oldVote;

    @SerializedName("new")
    private String newVote;

    public String getOldComment() {
        return oldVote;
    }

    public String getNewComment() {
        return newVote;
    }
}