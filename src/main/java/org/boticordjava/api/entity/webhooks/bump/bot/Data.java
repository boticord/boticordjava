package org.boticordjava.api.entity.webhooks;

import java.sql.Timestamp;

public class Data {

    private String user;
    private Long at;

    public Data(String user, Long at) {
        this.user = user;
        this.at = at;
    }

    public String getUser() {
        return user;
    }

    public Timestamp getAt() {
        return new Timestamp(at);
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setAt(Long at) {
        this.at = at;
    }
}
