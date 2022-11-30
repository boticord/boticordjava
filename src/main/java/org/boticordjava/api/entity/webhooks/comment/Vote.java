package org.boticordjava.api.entity.webhooks.comment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vote {

    @JsonProperty("old")
    private String oldVote;

    @JsonProperty("new")
    private String newVote;

    public Vote(String oldVote, String newVote) {
        this.oldVote = oldVote;
        this.newVote = newVote;
    }

    public String getOldComment() {
        return oldVote;
    }

    public void setOldComment(String oldComment) {
        this.oldVote = oldComment;
    }

    public String getNewComment() {
        return newVote;
    }

    public void setNewComment(String newComment) {
        this.newVote = newComment;
    }
}
