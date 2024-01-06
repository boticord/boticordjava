package org.boticordjava.api.entity.abstracts;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class AbstractComment {

    private String id;
    private String name;
    private String description;
    private String shortDescription;
    private String avatar;
    private String invite;
    private boolean premiumActive;
    private int ups;
    private LocalDateTime created;
    private int rating;
    private int banner;
    private int members;

}