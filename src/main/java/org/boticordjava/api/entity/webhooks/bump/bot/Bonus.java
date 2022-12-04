package org.boticordjava.api.entity.webhooks.bump.bot;

import java.sql.Timestamp;

public class Bonus {

    private String status;
    private Long expiresAt;

    public String getStatus() {
        return status;
    }

    public Timestamp getExpiresAt() {
        return new Timestamp(expiresAt);
    }
}