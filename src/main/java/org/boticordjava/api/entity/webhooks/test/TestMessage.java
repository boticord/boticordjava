package org.boticordjava.api.entity.webhooks.test;

import org.boticordjava.api.entity.webhooks.WebhookListener;

public class TestMessage implements WebhookListener {

    private String type;
    private TestData data;

    public String getType() {
        return type;
    }

    public TestData getData() {
        return data;
    }
}