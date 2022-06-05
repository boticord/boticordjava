package org.boticordjava.api.entity;

import org.jetbrains.annotations.Nullable;

public class Result {

    @Nullable
    String ok;

    public Result(@Nullable String ok) {
        this.ok = ok;
    }

    public boolean getOk() {
        if (ok == null) return false;

        return ok.equals("true");
    }

    @Override
    public String toString() {
        return "Result{" +
                "ok='" + ok + '\'' +
                '}';
    }
}
