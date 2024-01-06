package org.boticordjava.api.entity.webhooks.notification;

import lombok.Getter;
import lombok.Setter;
import org.boticordjava.api.entity.Errors;
import org.boticordjava.api.entity.webhooks.WebhookListener;

@Getter
@Setter
public class NotificationError implements WebhookListener {

    private String event;
    public Errors data;

    @Override
    public String getType() {
        return data.getType();
    }
}
