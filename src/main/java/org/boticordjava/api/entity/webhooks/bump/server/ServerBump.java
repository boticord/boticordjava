package org.boticordjava.api.entity.webhooks.bump.server;

import org.boticordjava.api.entity.webhooks.Data;

public class ServerBump {

    private String type;
    private Data data;

    public ServerBump(String type, Data data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
