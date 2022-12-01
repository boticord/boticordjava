package org.boticordjava.api.entity.webhooks.comment;

import java.sql.Timestamp;

public class CommentData {

    private String user;
    private Comment comment;
    private String reason;
    private Long at;

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
}