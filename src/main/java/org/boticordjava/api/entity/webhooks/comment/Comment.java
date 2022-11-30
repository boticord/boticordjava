package org.boticordjava.api.entity.webhooks.comment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment {

    private Vote vote;

    @JsonProperty("old")
    private String oldComment;

    @JsonProperty("new")
    private String newComment;

    public Comment(Vote vote, String oldComment, String newComment) {
        this.vote = vote;
        this.oldComment = oldComment;
        this.newComment = newComment;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public String getOldComment() {
        return oldComment;
    }

    public void setOldComment(String oldComment) {
        this.oldComment = oldComment;
    }

    public String getNewComment() {
        return newComment;
    }

    public void setNewComment(String newComment) {
        this.newComment = newComment;
    }
}
