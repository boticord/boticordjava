package org.boticordjava.api.entity.webhooks.notification;

import org.jetbrains.annotations.Nullable;

public class Payload {

    private String content;
    private int rating;
    private int upCount;

    /**
     * @NotNull если NotificationData.type == comment_*
     * @return {@link String}
     */
    @Nullable
    public String getContent() {
        return content;
    }

    public int getRating() {
        return rating;
    }

    public int getUpCount() {
        return upCount;
    }
}