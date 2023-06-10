package org.boticordjava.api.entity.enums;

public enum ServerTags {

    GENERAL("130"),
    FAN("131"),
    GAMES("132"),
    MOVIES("133"),
    ANIME("134"),
    ART("135"),
    CODING("136"),
    MUSIC("137"),
    NSFW("138"),
    ROLE_PLAY("139"),
    HUMOR("140"),
    GENSHIN("160"),
    MINECRAFT("161"),
    GTA("162"),
    CS("163"),
    DOTA("164"),
    AMONG_US("165"),
    FORTNITE("166"),
    BRAWL_STARS("167");

    private final String code;

    ServerTags(String code) {
        this.code = code;
    }

    public String getValue() {
        return code;
    }

    public static ServerTags find(String value) {
        ServerTags[] values = ServerTags.values();
        for (ServerTags tag : values) {
            String localValue = tag.getValue();
            if (localValue.equals(value)) {
                return tag;
            }
        }
        return null;
    }
}
