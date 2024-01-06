package org.boticordjava.api.entity.api.request;

import org.boticordjava.api.entity.bot.stats.BotStats;

public class SetBotStatsRequest extends APIRequest {

    public SetBotStatsRequest(String host, String botId, BotStats botStats) {
        super(String.format("%s/bots/%s/stats", host, botId), RequestMethod.POST, botStats);
    }
}
