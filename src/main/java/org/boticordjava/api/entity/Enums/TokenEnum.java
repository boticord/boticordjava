package org.boticordjava.api.entity.Enums;

public enum TokenEnum {

    BOT("Bot "),
    PRIVATE_BOT("PrivateBot "),
    PROFILE("Profile "),
    NONE("None ");

    private final String text;

    TokenEnum(String text) {
        this.text = text;
    }

    public String get() {
        return text;
    }
}
