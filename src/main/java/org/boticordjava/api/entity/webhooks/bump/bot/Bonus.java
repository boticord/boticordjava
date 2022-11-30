package org.boticordjava.api.entity.webhooks.bump.bot;

import java.sql.Timestamp;

public class Bonus {

    private String status;
    private Long expiresAt;

    public Bonus(String status, Long expiresAt) {
        this.status = status;
        this.expiresAt = expiresAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getExpiresAt() {
        return new Timestamp(expiresAt);
    }

    public void setExpiresAt(Long expiresAt) {
        this.expiresAt = expiresAt;
    }
}
