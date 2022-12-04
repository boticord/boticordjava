package org.boticordjava.api.entity.webhooks.observer;

import org.boticordjava.api.entity.webhooks.bump.bot.BotBump;
import org.boticordjava.api.entity.webhooks.bump.server.ServerBump;
import org.boticordjava.api.entity.webhooks.comment.CommentAction;
import org.boticordjava.api.entity.webhooks.test.TestMessage;
import org.jetbrains.annotations.NotNull;

public abstract class ListenerAdapter {

    public void onTestEvent(@NotNull TestMessage event) {}
    public void onCommentEvent(@NotNull CommentAction event) {}
    public void onBotBumpEvent(@NotNull BotBump event) {}
    public void onServerBumpEvent(@NotNull ServerBump event) {}
}