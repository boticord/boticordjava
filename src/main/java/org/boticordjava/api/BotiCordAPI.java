package org.boticordjava.api;

import org.boticordjava.api.entity.Result;
import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.entity.bot.comments.Comments;
import org.boticordjava.api.entity.bot.stats.BotStats;
import org.boticordjava.api.entity.servers.ServerInfo;
import org.boticordjava.api.entity.servers.ServerInformation;
import org.boticordjava.api.impl.BotiCordAPIAPIImpl;

public interface BotiCordAPI {

    /**
     * @param servers server count
     * @param shards  shard count
     * @param users   users count
     *                <p>Example:
     *                <p>AtomicInteger usersCount = new AtomicInteger();
     *                BotStartConfig.jda.getGuilds().forEach(g -> usersCount.addAndGet(g.getMembers().size()));
     * @return {@link Result}
     */
    Result setStats(int servers, int shards, int users);

    /**
     * @param botId String botId or shortCode
     * @return {@link BotStats}
     */
    BotStats getBot(String botId);

    /**
     * Example:
     * <p> Comments[] comments = discordBotListAPI.getBotComments();
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
    BotInfo getBotInformation(String botId);

    /**
     * @param botId String botId or shortCode
     * @return {@link ServerInfo}
     */
    ServerInfo getServerInformation(String botId);

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
         *
         * @throws IllegalArgumentException if token or botId null
         */
        public BotiCordAPI build() {
            if (token == null)
                throw new IllegalArgumentException("The provided token cannot be null!");

            if (botId == null)
                throw new IllegalArgumentException("The provided bot ID cannot be null!");

            return new BotiCordAPIAPIImpl(token, botId);
        }

    }

}
