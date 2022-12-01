package org.boticordjava.api.entity.webhooks.bump.bot;


public class BotBump {

    private String type;
    private Data data;
    private Bonus bonus;

    public String getType() {
        return type;
    }

    public Data getData() {
        return data;
    }

    public Bonus getBonus() {
        return bonus;
    }
}