package org.boticordjava.api.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.meilisearch.sdk.exceptions.MeilisearchException;
import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.entity.bot.botssearch.BotsSearch;
import org.boticordjava.api.entity.bot.stats.BotStats;
import org.boticordjava.api.entity.servers.serverinfo.ServerInfo;
import org.boticordjava.api.entity.servers.serverssearch.ServersSearch;
import org.boticordjava.api.entity.users.profile.UserProfile;
import org.boticordjava.api.entity.users.usercommentsearch.UsersCommentSearch;
import org.boticordjava.api.io.UnsuccessfulHttpException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

public interface BotiCordAPI {

    /**
     * @param botStats botStats class
     *                <p>Example:
     *                <p>AtomicInteger usersCount = new AtomicInteger();
     *                <p>jda.getGuilds().forEach(g -> usersCount.addAndGet(g.getMembers().size()));
     * @return {@link BotInfo}
     */
    BotInfo setBotStats(@NotNull String botId, BotStats botStats) throws IOException;

    /**
     * @param botId String botId or shortCode
     * @return {@link BotInfo}
     */
    @Nullable
    BotInfo getBotInfo(@NotNull String botId) throws IOException;

    /**
     * @param serverId String botId or shortCode
     * @return {@link ServerInfo}
     */
    @Nullable
    ServerInfo getServerInfo(@NotNull String serverId) throws IOException;

    /**
     * @param userId String userId
     * @return {@link UserProfile}
     */
    @Nullable
    UserProfile getUserProfile(@NotNull String userId) throws IOException;

    /**
     * @return {@link List<UsersCommentSearch>}
     */
    List<UsersCommentSearch> searchUserComments(@NotNull String resourceId) throws MeilisearchException, IllegalArgumentException, JsonProcessingException;

    /**
     * @param text String text
     * @return {@link List<ServersSearch>}
     */
    List<ServersSearch> searchServers(@NotNull String text) throws MeilisearchException, IllegalArgumentException, JsonProcessingException;

    /**
     * @param text String text
     * @return {@link List<BotsSearch>}
     */
    List<BotsSearch> searchBots(@NotNull String text) throws MeilisearchException, IllegalArgumentException, JsonProcessingException;

    class Builder {

        // Required
        private String token;
        private boolean devMode;

        /**
         * This enables LOGS
         */
        public Builder enableDevMode() {
            this.devMode = true;
            return this;
        }

        /**
         * @param token Bot token, server token, or user token
         */
        public Builder token(String token) {
            this.token = token;
            return this;
        }

        /**
         * @throws IllegalArgumentException if token or botId null
         */
        public BotiCordAPI build() {
            if (token == null)
                throw new IllegalArgumentException("The provided token cannot be null!");

            return new BotiCordAPIImpl(token, devMode);
        }
    }
}