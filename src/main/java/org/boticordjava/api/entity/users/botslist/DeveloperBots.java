package org.boticordjava.api.entity.users.botslist;

public class DeveloperBots {

    private Long id;
    private String shortCode;

    public Long getId() {
        return id;
    }

    public String getShortCode() {
        return shortCode;
    }

    @Override
    public String toString() {
        return "id: " + id + " shortCode: " + shortCode;
    }
}
