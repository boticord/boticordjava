package org.boticordjava.api.entity.bot.botinfo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Developers {

    private String id;
    private String discriminator;
    private String username;
    private String description;
    private String shortDescription;
    private Socials socials;
    private String shortDomain;
    private String avatar;

}