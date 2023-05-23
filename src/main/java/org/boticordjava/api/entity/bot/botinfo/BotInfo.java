package org.boticordjava.api.entity.bot.botinfo;

import java.time.LocalDateTime;
import java.util.List;

public class BotInfo {

    private String id;
    private String name;
    private String shortDescription;
    private String description;
    private String avatar;
    private String shortLink;
    private String inviteLink;
    private int standardBannerID;
    private String owner;
    private int status;
    private Ratings[] ratings;
    private List<String> tags;
    private String prefix;
    private String discriminator;
    private String createdDate; //"2023-05-22T22:12:15.637Z"
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
    private String[] ups;

    public String[] getUps() {
        return ups;
    }

    public void setUps(String[] ups) {
        this.ups = ups;
    }

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

    public int getStandardBannerID() {
        return standardBannerID;
    }

    public void setStandardBannerID(int standardBannerID) {
        this.standardBannerID = standardBannerID;
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

    public Ratings[] getRatings() {
        return ratings;
    }

    public void setRatings(Ratings[] ratings) {
        this.ratings = ratings;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getSupportServerInviteCode() {
        return supportServerInviteCode;
    }

    public void setSupportServerInviteCode(String supportServerInviteCode) {
        this.supportServerInviteCode = supportServerInviteCode;
    }

    public Library getLibrary() {
        return Library.find(library);
    }

    public void setLibrary(int library) {
        System.out.println("library " + library);
        this.library = library;
    }

    public int getGuilds() {
        return guilds;
    }

    public void setGuilds(int guilds) {
        this.guilds = guilds;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public int getShards() {
        return shards;
    }

    public void setShards(int shards) {
        this.shards = shards;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Premium getPremium() {
        return premium;
    }

    public void setPremium(Premium premium) {
        this.premium = premium;
    }

    public Notify getNotify() {
        return notify;
    }

    public void setNotify(Notify notify) {
        this.notify = notify;
    }

    public Developers[] getDevelopers() {
        return developers;
    }

    public void setDevelopers(Developers[] developers) {
        this.developers = developers;
    }

    public int getUpCount() {
        return upCount;
    }

    public void setUpCount(int upCount) {
        this.upCount = upCount;
    }
}