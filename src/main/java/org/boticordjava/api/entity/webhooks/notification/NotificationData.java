package org.boticordjava.api.entity.webhooks.notification;

import org.boticordjava.api.entity.webhooks.WebhookListener;

public class NotificationData implements WebhookListener {

    private String type;
    private Payload payload;
    private String affected;
    private String id;
    private String user;
    private long happened;

    public Payload getPayload() {
        return payload;
    }

    public String getAffected() {
        return affected;
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public long getHappened() {
        return happened;
    }

    @Override
    public String getType() {
        return type;
    }
}