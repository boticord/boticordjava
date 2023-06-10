package org.boticordjava.api.entity.enums;

public enum BotTags {
    MODERATION("0"),
    COMBINE("1"),
    UTILITIES("2"),
    ENTERTAINMENT("3"),
    MUSIC("4"),
    ECONOMY("5"),
    LOGS("6"),
    LEVELS("7"),
    NSFW("8"),
    CONFIGURATION("9"),
    ROLE_PLAY("10"),
    MEMES("11"),
    GAMES("12"),
    AI("13");

    private final String value;

    BotTags(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BotTags find(String value) {
        BotTags[] values = BotTags.values();
        for (BotTags tag : values) {
            String localValue = tag.getValue();
            if (localValue.equals(value)) {
                return tag;
            }
        }
        return null;
    }
}