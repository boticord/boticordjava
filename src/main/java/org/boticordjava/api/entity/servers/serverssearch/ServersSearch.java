package org.boticordjava.api.entity.servers.serverssearch;

import lombok.Getter;
import lombok.Setter;
import org.boticordjava.api.entity.abstracts.AbstractComment;
import org.boticordjava.api.entity.enums.ServerTags;

import java.util.List;

@Getter
@Setter
public class ServersSearch {

    private String avatar;
    private int banner;
    private List<String> features;
    private String id;
    private String invite;
    private Integer members; // может быть null
    private String name;
    private String premiumBanner;
    private String premiumInvite;
    private int rating;
    private String shortDescription;
    private boolean showDefaultBanner;
    private ServerTags[] tags;
}