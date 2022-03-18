package org.boticordjava.api.entity.comments;

import com.google.gson.annotations.SerializedName;
import org.boticordjava.api.entity.CommentsAbstract;

public class Comments extends CommentsAbstract {

    @SerializedName("userID")
    private String userId;

    @Override
    public String toString() {
        return "userId: " + userId +
                "\ntext: " + text +
                "\nvote: " + vote +
                "\nisUpdated: " + isUpdated +
                "\ncreatedAt: " + createdAt +
                "\n";
    }
}
