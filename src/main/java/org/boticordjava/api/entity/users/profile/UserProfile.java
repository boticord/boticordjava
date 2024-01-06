package org.boticordjava.api.entity.users.profile;

import lombok.Getter;
import lombok.Setter;
import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.entity.bot.botinfo.Socials;
import org.boticordjava.api.entity.servers.serverinfo.ServerInfo;

@Getter
@Setter
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

}