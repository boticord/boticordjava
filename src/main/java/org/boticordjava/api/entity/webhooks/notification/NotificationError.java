package org.boticordjava.api.entity.webhooks.notification;

import org.boticordjava.api.entity.Errors;
import org.boticordjava.api.entity.webhooks.WebhookListener;

public class NotificationError implements WebhookListener {

    private String event;
    public Errors data;

    public String getEvent() {
        return event;
    }

    public Errors getData() {
        return data;
    }

    @Override
    public String getType() {
        return data.getType();
    }
}
