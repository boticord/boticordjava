package org.boticordjava.api.entity.webhooks.comment;

import com.google.gson.annotations.SerializedName;

public class BotComment {

    private String type;
    @SerializedName("data")
    private CommentData commentData;

    public String getType() {
        return type;
    }

    public CommentData getData() {
        return commentData;
    }
}