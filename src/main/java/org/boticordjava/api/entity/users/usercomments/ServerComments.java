package org.boticordjava.api.entity.users.usercomments;

import com.google.gson.annotations.SerializedName;
import org.boticordjava.api.entity.abstracts.CommentsAbstract;

public class ServerComments extends CommentsAbstract {

    @SerializedName("serverID")
    private String serverId;

    public String getServerId() {
        return serverId;
    }

    @Override
    public String toString() {
        return "serverId: " + serverId +
                "\ntext: " + text +
                "\nvote: " + vote +
                "\nisUpdated: " + isUpdated +
                "\ncreatedAt: " + createdAt +
                "\n";
    }
}
