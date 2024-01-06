package org.boticordjava.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.boticordjava.api.entity.webhooks.WebhookListener;

@Getter
@Setter
public class Errors implements WebhookListener {

    private int code;
    private String message;

    @Override
    public String getType() {
        return "error";
    }

    @Override
    public String toString() {
        return "Errors code: " + code + "\nErrors message: " + message;
    }
}