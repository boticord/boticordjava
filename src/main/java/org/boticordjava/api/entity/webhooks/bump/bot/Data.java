package org.boticordjava.api.entity.webhooks.bump.bot;

import java.sql.Timestamp;

public class Data {

    private String user;
    private Long at;

    public String getUser() {
        return user;
    }

    public Timestamp getAt() {
        return new Timestamp(at);
    }
}
