package org.boticordjava.api.entity.bot.botssearch;

import lombok.Getter;
import lombok.Setter;
import org.boticordjava.api.entity.abstracts.AbstractComment;
import org.boticordjava.api.entity.enums.BotTags;

import java.util.List;

@Getter
@Setter
public class BotsSearch {

    private String avatar;
    private int banner;
    private String discriminator;
    private List<String> features;
    private int guilds;
    private String id;
    private String invite;
    private String name;
    private String premiumBanner;
    private String premiumInvite;
    private int rating;
    private String shortDescription;
    private boolean showDefaultBanner;
    private BotTags[] tags;
}