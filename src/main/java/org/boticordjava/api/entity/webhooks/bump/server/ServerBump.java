package org.boticordjava.api.entity.webhooks.bump.server;

import org.boticordjava.api.entity.webhooks.bump.bot.Data;

public class ServerBump {

    private String type;
    private Data data;

    public String getType() {
        return type;
    }

    public Data getData() {
        return data;
    }
}
