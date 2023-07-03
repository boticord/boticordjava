package org.boticordjava.api.entity.webhooks.notification;

public enum Type {

    NEW_COMMENT("comment_added"),
    ERROR("error"),
    EDIT_COMMENT("comment_edited"),
    DELETE_COMMENT("comment_removed"),
    TEST_WEBHOOK_MESSAGE("none"),
    NEW_UP("up_added");

    private final String value;

    Type(String value) {
        this.value = value;
    }

    public static boolean equals(String s, Type type) {
        Type typeFrom = Type.valueOf(s.toUpperCase());
        return typeFrom.equals(type);
    }

    public static Type getType(String value) {
        for (Type v : values()) {
            if (v.value.equals(value)) {
                return v;
            }
        }
        return null;
    }
}
