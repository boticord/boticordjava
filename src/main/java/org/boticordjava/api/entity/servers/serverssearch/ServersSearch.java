package org.boticordjava.api.entity.servers.serverssearch;

import lombok.Getter;
import lombok.Setter;
import org.boticordjava.api.entity.abstracts.AbstractComment;
import org.boticordjava.api.entity.enums.ServerTags;

@Getter
@Setter
public class ServersSearch extends AbstractComment {

    private String discordBanner;
    private ServerTags[] tags;
}