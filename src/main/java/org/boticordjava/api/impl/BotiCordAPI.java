package org.boticordjava.api.impl;

import org.boticordjava.api.entity.Enums.TokenEnum;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
    Result setStats(int servers, int shards, int users);

//    /**
//     * @param botId String botId or shortCode
//     * @return {@link BotStats}
//     */
//    BotStats getBot(@NotNull String botId);

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
    Comments[] getBotComments(@NotNull String botId);

    /**
     * @param botId String botId or shortCode
     * @return {@link BotStats}
     */
    BotInfo getBotInformation(@NotNull String botId);

    /**
     * @param botId String botId or shortCode
     * @return {@link ServerInfo}
     */
    ServerInfo getServerInformation(@NotNull String botId);

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
    Comments[] getServerComments(@NotNull String serverId);

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
    GetShortLink[] getUserLinks(@NotNull String code);

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
    GetShortLink[] getUserLinks();

    /**
     * @param code   The link code to use
     * @param link   The link that needs to be shortened
     * @param domain The domain for shortening the link. By default, it costs 1 (bcord.cc ), values of 2 are possible (myservers.me ) and 3 (discord.camp)
     * @return {@link GetShortLink}
     */
    GetShortLink createShortLink(@NotNull String code, @NotNull String link, @NotNull Domain domain);

    /**
     * @param code The link code to use
     * @param link The link that needs to be shortened
     * @return {@link GetShortLink}
     */
    GetShortLink createShortLink(@NotNull String code, @NotNull String link);

    /**
     * @param code The link code to use
     * @return {@link Result}
     */
    Result deleteShortLink(@NotNull String code);

    /**
     * @param code   The link code to use
     * @param domain The domain of the abbreviated link. Possible values: 1 (bcord.cc ), 2 (myservers.me ) and 3 (discord.camp)
     * @return {@link Result}
     */
    Result deleteShortLink(@NotNull String code, @NotNull Domain domain);

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
    ResultServer setServerStats(@NotNull String serverId, int up, int status, @Nullable String serverName, @Nullable String serverAvatar, @Nullable String serverMembersAllCount, @Nullable String serverMembersOnlineCount, @Nullable String serverOwnerID);

    /**
     * @param userId String userId
     * @return {@link DeveloperBots}
     */
    DeveloperBots[] getDeveloperBots(String userId);

    /**
     * @param userId String userId
     * @return {@link UserComments}
     */
    UserComments getUserComments(String userId);

    /**
     * @param userId String userId
     * @return {@link UserProfile}
     */
    UserProfile getUserProfile(String userId);

    class Builder {

        // Required
        private String token = null;
        private TokenEnum tokenEnum;

        /**
         * @param token Bot token, server token, or user token
         */
        public Builder token(String token) {
            this.token = token;
            return this;
        }

        /**
         * This method enable API v2
         *
         * @param tokenEnum:<br> {@link TokenEnum#BOT}: API-token bot. Used most often. <br>
         *                       {@link TokenEnum#PRIVATE_BOT}: API-token bot. Used in private cases (for example: Ap server, if you do not have a service bot)<br>
         *                       {@link TokenEnum#PROFILE}: API-token user. Used to shorten links.<br>
         *                       {@link TokenEnum#NONE}: None token. Used for get Bot/Server/User info.<br>
         */
        public Builder tokenEnum(TokenEnum tokenEnum) {
            this.tokenEnum = tokenEnum;
            return this;
        }

        /**
         * @throws IllegalArgumentException if token or botId null
         */
        public BotiCordAPI build() {
            if (tokenEnum != TokenEnum.NONE && token == null)
                throw new IllegalArgumentException("The provided token cannot be null!");

            if (tokenEnum != null)
                return new BotiCordAPIImpl(token, tokenEnum);

            return new BotiCordAPIImpl(token);
        }

    }

}
