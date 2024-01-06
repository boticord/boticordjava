package org.boticordjava.api.entity.bot.botinfo;

import lombok.Getter;
import lombok.Setter;
import org.boticordjava.api.entity.enums.BotTags;
import org.boticordjava.api.entity.enums.Library;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class BotInfo {

    private String id;
    private String name;
    private String shortDescription;
    private String description;
    private String avatar;
    private String shortLink;
    private String inviteLink;
    private boolean premiumActive;
    private String premiumSplashURL;
    private boolean premiumAutoFetch;
    private int standardBannerID;
    private String premiumBannerURL;
    private String owner;
    private int status; //TODO: Enum класс смотреть либу
    private ResourceRating[] ratings;
    private List<String> tags;
    private String prefix;
    private String discriminator;
    private LocalDateTime createdDate;
    private String supportServerInviteCode;
    private int library;
    private int guilds;
    private int members;
    private int shards;
    private String website;
    private Premium premium;
    private Notify notify;
    private Developers[] developers;
    private int upCount;
    private ResourceUp[] ups;

    public List<BotTags> getTags() {
        return tags.stream().map(BotTags::find).collect(Collectors.toList());
    }

    public Library getLibrary() {
        return Library.find(library);
    }
}