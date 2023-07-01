package org.boticordjava.api.entity.webhooks.observer;

import org.boticordjava.api.entity.webhooks.WebhookListener;
import org.boticordjava.api.entity.webhooks.bump.bot.BotBump;
import org.boticordjava.api.entity.webhooks.bump.server.ServerBump;
import org.boticordjava.api.entity.webhooks.comment.CommentAction;
import org.boticordjava.api.entity.webhooks.comment.Type;
import org.boticordjava.api.entity.webhooks.test.TestMessage;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Observer {

    private final List<ListenerAdapter> listeners = new ArrayList<>();

    public void addListener(@NotNull ListenerAdapter... listenerAdapter) {
        Collections.addAll(this.listeners, listenerAdapter);
    }

    public void handle(WebhookListener commentAction) {
        Type type = Type.valueOf(commentAction.getType().toUpperCase());
        for (ListenerAdapter hl : listeners) {
            switch (type) {
                case EDIT_BOT_COMMENT:
                case DELETE_BOT_COMMENT:
                case NEW_SERVER_COMMENT:
                case EDIT_SERVER_COMMENT:
                case DELETE_SERVER_COMMENT:
                case NEW_BOT_COMMENT: {
                    hl.onCommentEvent((CommentAction) commentAction);
                }
                case NEW_BOT_BUMP: {
                    hl.onBotBumpEvent((BotBump) commentAction);
                }
                case NEW_SERVER_BUMP: {
                    hl.onServerBumpEvent((ServerBump) commentAction);
                }
                case TEST_WEBHOOK_MESSAGE: {
                    hl.onTestEvent((TestMessage) commentAction);
                }
            }
        }
    }
}