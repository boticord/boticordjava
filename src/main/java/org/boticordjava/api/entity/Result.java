package org.boticordjava.api.entity;

public class Result {

    String ok;

    public Result(String ok) {
        this.ok = ok;
    }

    public boolean getOk() {
        return ok.equals("true");
    }

    @Override
    public String toString() {
        return "Result{" +
                "ok='" + ok + '\'' +
                '}';
    }
}
