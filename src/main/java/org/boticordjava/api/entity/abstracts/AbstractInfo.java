package org.boticordjava.api.entity.abstracts;

public abstract class AbstractInfo {

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
        return "\nid: " + id +
                "\napproved: " + approved +
                "\n";
    }
}
