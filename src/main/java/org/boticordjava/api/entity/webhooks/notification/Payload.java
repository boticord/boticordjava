package org.boticordjava.api.entity.webhooks.notification;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
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
}