package org.boticordjava.api.entity.webhooks.comment;

import java.sql.Timestamp;

public class Data {

    private String user;
    private Comment comment;
    private String reason;
    private Long at;

    public Data(String user, Comment comment, String reason, Long at) {
        this.user = user;
        this.comment = comment;
        this.reason = reason;
        this.at = at;
    }

    public String getUser() {
        return user;
    }

    public Comment getComment() {
        return comment;
    }

    public String getReason() {
        return reason;
    }

    public Timestamp getAt() {
        return new Timestamp(at);
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setAt(Long at) {
        this.at = at;
    }
}
