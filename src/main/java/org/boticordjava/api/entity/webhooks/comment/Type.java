package org.boticordjava.api.entity.webhooks.comment;

public enum Type {

    NEW_BOT_COMMENT,
    EDIT_BOT_COMMENT,
    DELETE_BOT_COMMENT,
    NEW_SERVER_COMMENT,
    EDIT_SERVER_COMMENT,
    DELETE_SERVER_COMMENT;

    public static boolean equals(String s, Type type) {
        Type typeFrom = Type.valueOf(s.toUpperCase());
        return typeFrom.equals(type);
    }
}
