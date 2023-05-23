package org.boticordjava.api.impl;

import org.boticordjava.api.entity.Enums.Domain;
import org.boticordjava.api.entity.Result;
import org.boticordjava.api.entity.ResultServer;
import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.entity.bot.stats.BotStats;
import org.boticordjava.api.entity.comments.Comments;
import org.boticordjava.api.entity.links.GetShortLink;
import org.boticordjava.api.entity.servers.serverinfo.ServerInfo;
import org.boticordjava.api.entity.users.botslist.DeveloperBots;
import org.boticordjava.api.entity.users.profile.UserProfile;
import org.boticordjava.api.entity.users.usercomments.UserComments;
import org.boticordjava.api.io.UnsuccessfulHttpException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Queue;

public interface BotiCordAPI {

    /**
     * @param servers server count
     * @param shards  shard count
     * @param users   users count
     *                <p>Example:
     *                <p>AtomicInteger usersCount = new AtomicInteger();
     *                <p>jda.getGuilds().forEach(g -> usersCount.addAndGet(g.getMembers().size()));
     * @return {@link Result}
     */
//    Result setStats(int servers, int shards, int users) throws UnsuccessfulHttpException;

//    /**
//     * @param botId String botId or shortCode
//     * @return {@link BotStats}
//     */
//    BotStats getBot(@NotNull String botId) throws UnsuccessfulHttpException;

    /**
     * Example:
     * <p> Comments[] comments = api.getBotComments();
     * <p> for (int i = 0; i < comments.length; i++) {
     * <p>   System.out.println(comments[i].getUserId());
     * <p> }
     *
     * @param botId String botId or shortCode
     * @return {@link Comments}
     */
//    Comments[] getBotComments(@NotNull String botId) throws UnsuccessfulHttpException;

    /**
     * @param botId String botId or shortCode
     * @return {@link BotStats}
     */
    BotInfo getBotInformation(@NotNull String botId) throws UnsuccessfulHttpException;

    /**
     * @param botId String botId or shortCode
     * @return {@link ServerInfo}
     */
//    ServerInfo getServerInformation(@NotNull String botId) throws UnsuccessfulHttpException;

    /**
     * @param serverId String serverID
     *                 <p>
     *                 Example:
     *                 <p> Comments[] comments = api.getServerComments(serverId);
     *                 <p> for (int i = 0; i < comments.length; i++) {
     *                 <p>   System.out.println(comments[i].getUserId());
     *                 <p> }
     * @return {@link Comments}
     */
//    Comments[] getServerComments(@NotNull String serverId) throws UnsuccessfulHttpException;

    /**
     * @param code String code. The link code, if specified, then information about links with such a code is searched
     *             <p>
     *             Example:
     *             <p> GetShortLink[] userLinks = api.GetShortLink(code);
     *             <p> for (int i = 0; i < userLinks.length; i++) {
     *             <p>   System.out.println(userLinks[i].getLink());
     *             <p> }
     * @return {@link GetShortLink}
     */
//    GetShortLink[] getUserLinks(@NotNull String code) throws UnsuccessfulHttpException;

    /**
     * <p>
     * Example:
     * <p> GetShortLink[] userLinks = api.GetShortLink();
     * <p> for (int i = 0; i < userLinks.length; i++) {
     * <p>   System.out.println(userLinks[i].getLink());
     * <p> }
     *
     * @return {@link GetShortLink}
     */
//    GetShortLink[] getUserLinks() throws UnsuccessfulHttpException;

    /**
     * @param code   The link code to use
     * @param link   The link that needs to be shortened
     * @param domain The domain for shortening the link. By default, it costs 1 (bcord.cc ), values of 2 are possible (myservers.me ) and 3 (discord.camp)
     * @return {@link GetShortLink}
     */
//    GetShortLink createShortLink(@NotNull String code, @NotNull String link, @NotNull Domain domain) throws UnsuccessfulHttpException;

    /**
     * @param code The link code to use
     * @param link The link that needs to be shortened
     * @return {@link GetShortLink}
     */
//    GetShortLink createShortLink(@NotNull String code, @NotNull String link) throws UnsuccessfulHttpException;

    /**
     * @param code The link code to use
     * @return {@link Result}
     */
//    Result deleteShortLink(@NotNull String code) throws UnsuccessfulHttpException;

    /**
     * @param code   The link code to use
     * @param domain The domain of the abbreviated link. Possible values: 1 (bcord.cc ), 2 (myservers.me ) and 3 (discord.camp)
     * @return {@link Result}
     */
//    Result deleteShortLink(@NotNull String code, @NotNull Domain domain) throws UnsuccessfulHttpException;

    /**
     * @param serverId                 String serverID serverId
     * @param up                       <p>Request type:
     *                                 <p>- 0: just updating statistics (in this case, the output of the answer is not required)
     *                                 <p>- 1: along with the statistics update, 1 UP is added (if possible)
     * @param status                   <p>Server Status:
     *                                 <p>- 0: the bot is not on the server
     *                                 <p>- 1: the bot is on the server
     * @param serverName               Server name (if specified, it will change after each request) @Nullable
     * @param serverAvatar             Server avatar (if specified, it will change after each request) @Nullable
     * @param serverMembersAllCount    The total number of participants on the server (if specified, it will be updated after each request) @Nullable
     * @param serverMembersOnlineCount The number of participants Online on the server (if specified, it will be updated after each request) @Nullable
     * @param serverOwnerID            ID of the server owner (if specified, it will be updated after each request) @Nullable
     * @return {@link ResultServer}
     */
//    ResultServer setServerStats(@NotNull String serverId, int up, int status, @Nullable String serverName, @Nullable String serverAvatar, @Nullable String serverMembersAllCount, @Nullable String serverMembersOnlineCount, @Nullable String serverOwnerID) throws UnsuccessfulHttpException;

    /**
     * @param userId String userId
     * @return {@link DeveloperBots}
     */
//    DeveloperBots[] getDeveloperBots(String userId) throws UnsuccessfulHttpException;

    /**
     * @param userId String userId
     * @return {@link UserComments}
     */
//    UserComments getUserComments(String userId) throws UnsuccessfulHttpException;

    /**
     * @param userId String userId
     * @return {@link UserProfile}
     */
//    UserProfile getUserProfile(String userId) throws UnsuccessfulHttpException;

    class Builder {

        // Required
        private String token = null;
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
