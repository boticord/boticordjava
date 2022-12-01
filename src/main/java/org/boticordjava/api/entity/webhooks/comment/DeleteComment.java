package org.boticordjava.api.entity.webhooks.comment;

import com.google.gson.annotations.SerializedName;
import org.boticordjava.api.entity.webhooks.bump.bot.Bonus;

public class DeleteComment {

    private String type;
    @SerializedName("data")
    private CommentData commentData;
    private Bonus bonus;

    public String getType() {
        return type;
    }

    public CommentData getData() {
        return commentData;
    }

    public Bonus getBonus() {
        return bonus;
    }
}
