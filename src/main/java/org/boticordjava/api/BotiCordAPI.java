package org.boticordjava.api;

import org.boticordjava.api.entity.*;
import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.entity.bot.stats.BotStats;
import org.boticordjava.api.entity.bot.comments.Comments;
import org.boticordjava.api.impl.BotiCordAPIAPIImpl;

public interface BotiCordAPI {

    Result setStats(int servers, int shards, int users);

    BotStats getBot(String botId);

    Comments[] getBotComments();

    BotInfo getBotInformation(String botId);

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

        public BotiCordAPI build() {
            if(token == null)
                throw new IllegalArgumentException("The provided token cannot be null!");

            if(botId == null)
                throw new IllegalArgumentException("The provided bot ID cannot be null!");

            return new BotiCordAPIAPIImpl(token, botId);
        }

    }

}
