package org.boticordjava.api.entity.webhooks.notification;

import lombok.Getter;
import lombok.Setter;
import org.boticordjava.api.entity.webhooks.WebhookListener;

@Getter
@Setter
public class Notification implements WebhookListener {

    private String event;
    private NotificationData data;

    @Override
    public String getType() {
        return data.getType();
    }
}