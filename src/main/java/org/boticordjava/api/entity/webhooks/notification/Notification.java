package org.boticordjava.api.entity.webhooks.notification;

import org.boticordjava.api.entity.webhooks.WebhookListener;

public class Notification implements WebhookListener {

    private String event;
    private NotificationData data;

    public String getEvent() {
        return event;
    }

    public NotificationData getData() {
        return data;
    }

    @Override
    public String getType() {
        return data.getType();
    }
}
