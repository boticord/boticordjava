package org.boticordjava.api.entity.webhooks.observer;

import org.boticordjava.api.entity.webhooks.notification.NotificationData;
import org.boticordjava.api.entity.webhooks.notification.NotificationError;
import org.jetbrains.annotations.NotNull;

public abstract class ListenerAdapter {

    public void onCommentEvent(@NotNull NotificationData event) {}

    public void onBumpEvent(@NotNull NotificationData event) {}

    public void onErrorEvent(@NotNull NotificationError error) {}
}