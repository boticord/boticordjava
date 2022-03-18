package org.boticordjava.api.entity.comments;

import com.google.gson.annotations.SerializedName;
import org.boticordjava.api.entity.CommentsAbstract;

public class Comments extends CommentsAbstract {

    @SerializedName("userID")
    private String userId;

    @Override
    public String toString() {
        return "userId: " + userId +
                " text: " + text +
                " vote: " + vote +
                " isUpdated: " + isUpdated +
                " createdAt: " + createdAt;
    }
}
