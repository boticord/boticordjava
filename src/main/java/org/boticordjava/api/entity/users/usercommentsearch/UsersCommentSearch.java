package org.boticordjava.api.entity.users.usercommentsearch;

import java.time.LocalDateTime;

public class UsersCommentSearch {

    private String id;
    private String author;
    private String content;
    private int rating;
    private String resource;
    private LocalDateTime created;
    private String modReply;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getModReply() {
        return modReply;
    }

    public void setModReply(String modReply) {
        this.modReply = modReply;
    }
}
