package org.boticordjava.api.entity.bot.botinfo;

public enum Library {

    Discord4J("1"),
    Discordcr("2"),
    DiscordGO("3"),
    Discordoo("4"),
    DSharpPlus("5"),
    Discordjs("6"),
    DiscordNet("7"),
    Discordpy("8"),
    Eris("9"),
    Javacord("10"),
    JDA("11"),
    Other("12");

    private final String value;

    Library(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Library find(int value) {
        Library[] values = Library.values();
        for (Library library : values) {
            String localValue = library.getValue();
            boolean equals = localValue.equals(String.valueOf(value));
            if (equals) return library;
        }
        return null;
    }
}
