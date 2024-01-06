package org.boticordjava.api.entity.bot.botssearch;

import lombok.Getter;
import lombok.Setter;
import org.boticordjava.api.entity.abstracts.AbstractComment;
import org.boticordjava.api.entity.enums.BotTags;

@Getter
@Setter
public class BotsSearch extends AbstractComment {

    private String discriminator;
    private String premiumBanner;
    private int guilds;
    private int shard;
    private BotTags[] tags;

}