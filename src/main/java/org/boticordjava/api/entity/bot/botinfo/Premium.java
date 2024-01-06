package org.boticordjava.api.entity.bot.botinfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Premium {

    private boolean active;
    private String splashURL;
    private boolean autoFetch;
    private String bannerURL;

}