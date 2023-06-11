package org.boticordjava.api.entity.servers.serverinfo;

import org.boticordjava.api.entity.bot.botinfo.*;
import org.boticordjava.api.entity.enums.ServerTags;
import org.boticordjava.api.entity.users.profile.UserProfile;

import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime createdDate;
    private int members;
    private String website;
    private List<String> tags;
    private List<UserProfile> moderators;
    private int upCount;
    private ResourceUp[] ups;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public String getInviteLink() {
        return inviteLink;
    }

    public void setInviteLink(String inviteLink) {
        this.inviteLink = inviteLink;
    }

    public boolean isPremiumActive() {
        return premiumActive;
    }

    public void setPremiumActive(boolean premiumActive) {
        this.premiumActive = premiumActive;
    }

    public String getPremiumSplashURL() {
        return premiumSplashURL;
    }

    public void setPremiumSplashURL(String premiumSplashURL) {
        this.premiumSplashURL = premiumSplashURL;
    }

    public boolean isPremiumAutoFetch() {
        return premiumAutoFetch;
    }

    public void setPremiumAutoFetch(boolean premiumAutoFetch) {
        this.premiumAutoFetch = premiumAutoFetch;
    }

    public int getStandardBannerID() {
        return standardBannerID;
    }

    public void setStandardBannerID(int standardBannerID) {
        this.standardBannerID = standardBannerID;
    }

    public String getPremiumBannerURL() {
        return premiumBannerURL;
    }

    public void setPremiumBannerURL(String premiumBannerURL) {
        this.premiumBannerURL = premiumBannerURL;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ResourceRating[] getRatings() {
        return ratings;
    }

    public void setRatings(ResourceRating[] ratings) {
        this.ratings = ratings;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<ServerTags> getTags() {
        return tags.stream().map(ServerTags::find).toList();
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<UserProfile> getModerators() {
        return moderators;
    }

    public void setModerators(List<UserProfile> moderators) {
        this.moderators = moderators;
    }

    public int getUpCount() {
        return upCount;
    }

    public void setUpCount(int upCount) {
        this.upCount = upCount;
    }

    public ResourceUp[] getUps() {
        return ups;
    }

    public void setUps(ResourceUp[] ups) {
        this.ups = ups;
    }
}