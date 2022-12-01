package org.boticordjava.api.entity.webhooks.test;

public class TestMessage {

    private String type;
    private TestData data;

    public TestMessage(String type, TestData data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TestData getData() {
        return data;
    }

    public void setData(TestData data) {
        this.data = data;
    }
}
