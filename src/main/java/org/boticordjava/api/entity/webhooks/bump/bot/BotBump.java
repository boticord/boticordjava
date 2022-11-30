package org.boticordjava.api.entity.webhooks.bump.bot;

import org.boticordjava.api.entity.webhooks.Data;

public class BotBump {

    private String type;
    private Data data;
    private Bonus bonus;

    public BotBump(String type, Data data, Bonus bonus) {
        this.type = type;
        this.data = data;
        this.bonus = bonus;
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

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }
}
