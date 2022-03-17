package org.boticordjava.api;

import org.boticordjava.api.entity.Result;
import org.boticordjava.api.entity.ResultServer;
import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.entity.bot.stats.BotStats;
import org.boticordjava.api.entity.comments.Comments;
import org.boticordjava.api.entity.servers.serverinfo.ServerInfo;
import org.boticordjava.api.impl.BotiCordAPIImpl;
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

    /**
     * @param botId String botId or shortCode
     * @return {@link BotStats}
     */
    BotStats getBot(@NotNull String botId);

    /**
     * Example:
     * <p> Comments[] comments = api.getBotComments();
     * <p> for (int i = 0; i < comments.length; i++) {
     * <p>   System.out.println(comments[i].getUserId());
     * <p> }
     *
     * @return {@link Comments}
     */
    Comments[] getBotComments();

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

    class Builder {

        // Required
        private String botId = null;
        private String token = null;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder botId(String botId) {
            this.botId = botId;
            return this;
        }

        /**
         * @throws IllegalArgumentException if token or botId null
         */
        public BotiCordAPI build() {
            if (token == null)
                throw new IllegalArgumentException("The provided token cannot be null!");

            if (botId == null)
                throw new IllegalArgumentException("The provided bot ID cannot be null!");

            return new BotiCordAPIImpl(token, botId);
        }

    }

}
