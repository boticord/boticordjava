package org.boticordjava.api.entity.webhooks.test;

public class TestData {

    private Boolean hello;
    private Boolean world;

    protected TestData(Boolean hello, Boolean world) {
        this.hello = hello;
        this.world = world;
    }

    public Boolean getHello() {
        return hello;
    }

    public void setHello(Boolean hello) {
        this.hello = hello;
    }

    public Boolean getWorld() {
        return world;
    }

    public void setWorld(Boolean world) {
        this.world = world;
    }
}
