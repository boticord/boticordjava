package org.boticordjava.api.entity.webhooks.bump.bot;

import org.boticordjava.api.entity.webhooks.WebhookListener;

public class BotBump implements WebhookListener {

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