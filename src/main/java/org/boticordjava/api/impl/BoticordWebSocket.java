package org.boticordjava.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.boticordjava.api.entity.webhooks.notification.Notification;
import org.boticordjava.api.entity.webhooks.notification.NotificationError;
import org.boticordjava.api.entity.webhooks.WebhookListener;
import org.boticordjava.api.entity.webhooks.observer.ListenerAdapter;
import org.boticordjava.api.entity.webhooks.observer.Observer;
import org.boticordjava.api.io.DefaultWebSocketResponseTransformer;
import org.boticordjava.api.io.ResponseTransformer;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.HashMap;

public class BoticordWebSocket {

    private final WebSocketBuilder webSocketBuilder;
    private final String token;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Observer Observer = new Observer();

    public BoticordWebSocket(String token) throws URISyntaxException, IllegalAccessException {
        if (token == null || token.isEmpty()) throw new IllegalAccessException("Token is NULL");
        this.token = token;
        webSocketBuilder = new WebSocketBuilder(this);
        this.openConnection();
    }

    protected void handle(String message) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            HashMap<String, Object> result = mapper.readValue(message, HashMap.class);
            if (result.get("event") != null) {
                String event = result.get("event").toString();
                if (event != null && event.equals("notify")) {
                    webSocketHandler(new DefaultWebSocketResponseTransformer<>(gson, Notification.class), message);
                } else if (event != null && event.equals("error")) {
                    webSocketHandler(new DefaultWebSocketResponseTransformer<>(gson, NotificationError.class), message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private <E> void webSocketHandler(ResponseTransformer<E> responseTransformer, String response) {
        if (responseTransformer != null) {
            WebhookListener transform = (WebhookListener) responseTransformer.transform(response);
            Observer.handle(transform);
        }
    }

    public void addListener(ListenerAdapter... listenerAdapter) {
        Observer.addListener(listenerAdapter);
    }

    public void reconnect() {
        webSocketBuilder.reconnect();
    }

    protected void openConnection() {
        try {
            //open websocket
            webSocketBuilder.connectBlocking();
            //Send Hello
            webSocketBuilder.send(auth().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected JSONObject auth() {
        JSONObject json = new JSONObject();

        try {
            json.put("event", "auth");
            JSONObject data = new JSONObject();
            data.put("token", token);
            json.put("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}