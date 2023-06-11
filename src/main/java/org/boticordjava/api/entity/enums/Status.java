package org.boticordjava.api.entity.enums;

public enum Status {

    HIDDEN("0"),
    PUBLIC("1"),
    BANNED("2"),
    PENDING("3");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Status find(int value) {
        Status[] values = Status.values();
        for (Status status : values) {
            String localValue = status.getValue();
            boolean equals = localValue.equals(String.valueOf(value));
            if (equals) return status;
        }
        return null;
    }
}
