package org.boticordjava.api.entity.users.usercomments;

import com.google.gson.annotations.SerializedName;
import org.boticordjava.api.entity.CommentsAbstract;

public class BotComments extends CommentsAbstract {

    @SerializedName("botID")
    private String botId;

    public String getBotID() {
        return botId;
    }

    @Override
    public String toString() {
        return "BotComments{" +
                "text='" + text + '\'' +
                ", vote=" + vote +
                ", isUpdated=" + isUpdated +
                ", createdAt='" + createdAt + '\'' +
                ", botId='" + botId + '\'' +
                '}';
    }
}
