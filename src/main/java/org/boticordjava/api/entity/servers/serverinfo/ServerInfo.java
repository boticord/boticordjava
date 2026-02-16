package org.boticordjava.api.entity.servers.serverinfo;

import lombok.Getter;
import lombok.Setter;
import org.boticordjava.api.entity.bot.botinfo.ResourceRating;
import org.boticordjava.api.entity.bot.botinfo.ResourceReviews;
import org.boticordjava.api.entity.bot.botinfo.ResourceUp;
import org.boticordjava.api.entity.enums.ServerTags;
import org.boticordjava.api.entity.users.profile.UserProfile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ServerInfo {

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
    private int status;
    private ResourceRating[] ratings;
    private ResourceReviews[] reviews;
    private LocalDateTime createdDate;
    private int members;
    private String website;
    private List<String> tags;
    private List<UserProfile> moderators;
    private int upCount;
    private ResourceUp[] ups;

    public List<ServerTags> getTags() {
        return tags.stream().map(ServerTags::find).collect(Collectors.toList());
    }
}