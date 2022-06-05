package org.boticordjava.api.entity;

public enum Domain {


    ONE("bcord.cc"),
    TWO("myservers.me"),
    THREE("discord.camp");

    private final String domain;

    Domain(String domain) {
        this.domain = domain;
    }

    public int get() {
        switch (domain) {
            case ("myservers.me"):
                return 2;
            case ("discord.camp"):
                return 3;
            default:
                return 1;
        }
    }
}