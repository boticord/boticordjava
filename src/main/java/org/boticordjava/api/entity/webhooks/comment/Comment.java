package org.boticordjava.api.entity.webhooks.comment;

import com.google.gson.annotations.SerializedName;

public class Comment {

    private Vote vote;

    @SerializedName("old")
    private String oldComment;

    @SerializedName("new")
    private String newComment;

    public Vote getVote() {
        return vote;
    }

    public String getOldComment() {
        return oldComment;
    }

    public String getNewComment() {
        return newComment;
    }
}