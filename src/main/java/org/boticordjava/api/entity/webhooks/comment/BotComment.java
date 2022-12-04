package org.boticordjava.api.entity.webhooks.comment;

import com.google.gson.annotations.SerializedName;
import org.boticordjava.api.entity.webhooks.WebhookListener;

public class BotComment implements WebhookListener {

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
