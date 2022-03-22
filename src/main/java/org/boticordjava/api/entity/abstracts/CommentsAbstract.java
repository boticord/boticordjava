package org.boticordjava.api.entity.abstracts;

public abstract class CommentsAbstract {

    public String text;
    public Integer vote;
    public boolean isUpdated;
    public String createdAt;

    public String getText() {
        return text;
    }

    public Integer getVote() {
        return vote;
    }

    public boolean isUpdated() {
        return isUpdated;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
