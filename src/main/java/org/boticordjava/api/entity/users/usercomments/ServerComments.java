package org.boticordjava.api.entity.users.usercomments;

import com.google.gson.annotations.SerializedName;
import org.boticordjava.api.entity.CommentsAbstract;

public class ServerComments extends CommentsAbstract {

    @SerializedName("serverID")
    private String serverId;

    public String getServerId() {
        return serverId;
    }

    @Override
    public String toString() {
        return "serverId: " + serverId +
                " text: " + text +
                " vote: " + vote +
                " isUpdated: " + isUpdated +
                " createdAt: " + createdAt;
    }
}
