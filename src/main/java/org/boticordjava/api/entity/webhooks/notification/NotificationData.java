package org.boticordjava.api.entity.webhooks.notification;

import lombok.Getter;
import lombok.Setter;
import org.boticordjava.api.entity.webhooks.WebhookListener;

@Getter
@Setter
public class NotificationData implements WebhookListener {

    private String type;
    private Payload payload;
    private String affected;
    private String id;
    private String user;
    private long happened;

    @Override
    public String getType() {
        return type;
    }
}