package org.boticordjava.api.entity.webhooks.observer;

import org.boticordjava.api.entity.webhooks.notification.Notification;
import org.boticordjava.api.entity.webhooks.notification.NotificationError;
import org.boticordjava.api.entity.webhooks.WebhookListener;
import org.boticordjava.api.entity.webhooks.notification.Type;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Observer {

    private final List<ListenerAdapter> listeners = new ArrayList<>();

    public void addListener(@NotNull ListenerAdapter... listenerAdapter) {
        Collections.addAll(this.listeners, listenerAdapter);
    }

    public void handle(WebhookListener notification) {
        Type type = Type.getType(notification.getType());
        if (type == null) return;
        for (ListenerAdapter hl : listeners) {
            switch (type) {
                case EDIT_COMMENT:
                case DELETE_COMMENT:
                case NEW_COMMENT: {
                    hl.onCommentEvent(((Notification) notification).getData());
                    break;
                }
                case NEW_UP: {
                    hl.onBumpEvent(((Notification) notification).getData());
                    break;
                }
                case ERROR: {
                    hl.onErrorEvent(((NotificationError) notification));
                    break;
                }
            }
        }
    }
}