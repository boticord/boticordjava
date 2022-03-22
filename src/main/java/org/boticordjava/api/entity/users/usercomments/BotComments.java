package org.boticordjava.api.entity.users.usercomments;

import com.google.gson.annotations.SerializedName;
import org.boticordjava.api.entity.abstracts.CommentsAbstract;

public class BotComments extends CommentsAbstract {

    @SerializedName("botID")
    private String botId;

    public String getBotID() {
        return botId;
    }

    @Override
    public String toString() {
        return "text: " + text +
                "\nvote: " + vote +
                "\nisUpdated: " + isUpdated +
                "\ncreatedAt: " + createdAt +
                "\nbotId: " + botId +
                "\n";
    }
}
