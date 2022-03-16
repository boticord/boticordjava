package org.boticordjava.api.entity.servers;

public class Bot {

    private String id;
    private boolean approved;

    public String getId() {
        return id;
    }

    public boolean isApproved() {
        return approved;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "id='" + id + '\'' +
                ", approved=" + approved +
                '}';
    }
}
