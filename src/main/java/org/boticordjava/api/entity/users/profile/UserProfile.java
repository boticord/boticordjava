package org.boticordjava.api.entity.users.profile;

import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.entity.bot.botinfo.Socials;
import org.boticordjava.api.entity.servers.serverinfo.ServerInfo;

public class UserProfile {

    private String username;
    private String discriminator;
    private String avatar;
    private String id;
    private UserBadge[] badges;
    private BotInfo[] bots;
    private ServerInfo[] servers;
    private Socials socials;
    private String description;
    private String shortDescription;
    private String status;
    private String shortDomain;

    public Socials getSocials() {
        return socials;
    }

    public void setSocials(Socials socials) {
        this.socials = socials;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBadges(UserBadge[] badges) {
        this.badges = badges;
    }

    public void setBots(BotInfo[] bots) {
        this.bots = bots;
    }

    public void setServers(ServerInfo[] servers) {
        this.servers = servers;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setShortDomain(String shortDomain) {
        this.shortDomain = shortDomain;
    }

    public String getUsername() {
        return username;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getId() {
        return id;
    }

    public UserBadge[] getBadges() {
        return badges;
    }

    public BotInfo[] getBots() {
        return bots;
    }

    public ServerInfo[] getServers() {
        return servers;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getStatus() {
        return status;
    }

    public String getShortDomain() {
        return shortDomain;
    }
}