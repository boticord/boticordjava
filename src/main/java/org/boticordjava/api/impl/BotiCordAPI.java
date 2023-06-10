package org.boticordjava.api.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.meilisearch.sdk.exceptions.MeilisearchException;
import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.entity.bot.botssearch.BotsSearch;
import org.boticordjava.api.entity.bot.stats.BotStats;
import org.boticordjava.api.entity.servers.serverinfo.ServerInfo;
import org.boticordjava.api.entity.users.profile.UserProfile;
import org.boticordjava.api.entity.users.usercommentsearch.UsersCommentSearch;
import org.boticordjava.api.io.UnsuccessfulHttpException;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface BotiCordAPI {

    /**
     * @param botStats botStats class
     *                <p>Example:
     *                <p>AtomicInteger usersCount = new AtomicInteger();
     *                <p>jda.getGuilds().forEach(g -> usersCount.addAndGet(g.getMembers().size()));
     * @return {@link BotInfo}
     */
    BotInfo setBotStats(@NotNull String botId, BotStats botStats) throws UnsuccessfulHttpException;

    /**
     * @param botId String botId or shortCode
     * @return {@link BotInfo}
     */
    BotInfo getBotInfo(@NotNull String botId) throws UnsuccessfulHttpException;

    /**
     * @param serverId String botId or shortCode
     * @return {@link ServerInfo}
     */
    ServerInfo getServerInfo(@NotNull String serverId) throws UnsuccessfulHttpException;

    /**
     * @param text String text
     * @return {@link List<UsersCommentSearch>}
     */
    List<UsersCommentSearch> searchUserComments(@NotNull String text) throws MeilisearchException, IllegalArgumentException, JsonProcessingException ;

    /**
     * @param text String text
     * @return {@link List<ServerInfo>}
     */
    List<ServerInfo> searchServers(@NotNull String text) throws MeilisearchException, IllegalArgumentException, JsonProcessingException;

    /**
     * @param text String text
     * @return {@link List<BotsSearch>}
     */
    List<BotsSearch> searchBots(@NotNull String text) throws MeilisearchException, IllegalArgumentException, JsonProcessingException;

    /**
     * @param userId String userId
     * @return {@link UserProfile}
     */
    UserProfile getUserProfile(@NotNull String userId) throws UnsuccessfulHttpException;

    class Builder {

        // Required
        private String token;
        private String searchApiKey;
        private boolean devMode;

        /**
         * This enables LOGS
         */
        public Builder enableDevMode() {
            this.devMode = true;
            return this;
        }

        public Builder searchApiKey(String searchApiKey) {
            this.searchApiKey = searchApiKey;
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

            return new BotiCordAPIImpl(token, searchApiKey, devMode);
        }
    }
}