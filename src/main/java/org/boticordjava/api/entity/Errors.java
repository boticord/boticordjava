package org.boticordjava.api.entity;

import org.boticordjava.api.entity.webhooks.WebhookListener;

public class Errors implements WebhookListener {

    private int code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String getType() {
        return "error";
    }

    @Override
    public String toString() {
        return "Errors code: " + code + "\nErrors message: " + message;
    }
}
