package org.boticordjava.api;

public enum TokenEnum {

    BOT("Bot "),
    PRIVATE_BOT("PrivateBot "),
    PROFILE("Profile ");

    private final String text;

    TokenEnum(String text) {
        this.text = text;
    }

    public String get() {
        return text;
    }
}
