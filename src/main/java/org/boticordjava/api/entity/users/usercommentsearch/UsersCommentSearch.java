package org.boticordjava.api.entity.users.usercommentsearch;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersCommentSearch {

    private String id;
    private String author;
    private String content;
    private int rating;
    private String resource;
    private long created;
    private String modReply;

}