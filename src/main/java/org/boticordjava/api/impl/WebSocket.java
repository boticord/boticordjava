package org.boticordjava.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.boticordjava.api.entity.webhooks.WebhookListener;
import org.boticordjava.api.entity.webhooks.bump.bot.BotBump;
import org.boticordjava.api.entity.webhooks.bump.server.ServerBump;
import org.boticordjava.api.entity.webhooks.comment.CommentAction;
import org.boticordjava.api.entity.webhooks.comment.Type;
import org.boticordjava.api.entity.webhooks.observer.Initiator;
import org.boticordjava.api.entity.webhooks.observer.ListenerAdapter;
import org.boticordjava.api.entity.webhooks.test.TestMessage;
import org.boticordjava.api.io.DefaultResponseTransformer;
import org.boticordjava.api.io.ResponseTransformer;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class WebSocket {

    private final Gson gson;
    private final String XHookKey;
    private final String path;
    private final int port;
    private final static Initiator INITIATOR = new Initiator();

    /**
     * @param xHookKey String X-Hook-Key for filter request
     * @param path String Can be NULL. Example: <a href="https://api.megoru.ru/path">https://api.megoru.ru/*path*</a>
     * @param port int You can use one of the free ports on your system
     */
    public WebSocket(String xHookKey, @Nullable String path, int port) {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.XHookKey = xHookKey;
        this.path = path == null ? "/" : path;
        this.port = port;
        createServer(port, path == null ? "/" : path);
    }

    private void createServer(int port, String path) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext(path, new MyHandler());
            server.setExecutor(null);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) {
            try {
                Headers requestHeaders = t.getRequestHeaders();
                List<String> strings = requestHeaders.get("X-Hook-Key");
                if (strings == null || strings.isEmpty()) {
                    String response = "400 Bad Request";
                    t.sendResponseHeaders(400 , response.length());
                    OutputStream os = t.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                    return;
                }

                String hookKey = strings
                        .toString()
                        .replace("[", "")
                        .replace("]", "");

                if (hookKey.equals(XHookKey)) {
                    InputStream responseBody = t.getRequestBody();
                    InputStreamReader isr = new InputStreamReader(responseBody, StandardCharsets.UTF_8);
                    BufferedReader br = new BufferedReader(isr);

                    String collect = br.lines().map(String::trim).collect(Collectors.joining());

                    ObjectMapper mapper = new ObjectMapper();
                    HashMap<String, Object> result = mapper.readValue(collect, HashMap.class);

                    Type type = Type.valueOf(result.get("type").toString().toUpperCase());
                    DefaultResponseTransformer<?> defaultResponseTransformer;

                    switch (type) {
                        case EDIT_BOT_COMMENT:
                        case DELETE_BOT_COMMENT:
                        case NEW_SERVER_COMMENT:
                        case EDIT_SERVER_COMMENT:
                        case DELETE_SERVER_COMMENT:
                        case NEW_BOT_COMMENT:
                            defaultResponseTransformer = new DefaultResponseTransformer<>(CommentAction.class, gson);
                            break;
                        case NEW_BOT_BUMP:
                            defaultResponseTransformer = new DefaultResponseTransformer<>(BotBump.class, gson);
                            break;
                        case NEW_SERVER_BUMP:
                            defaultResponseTransformer = new DefaultResponseTransformer<>(ServerBump.class, gson);
                            break;
                        case TEST_WEBHOOK_MESSAGE:
                            defaultResponseTransformer = new DefaultResponseTransformer<>(TestMessage.class, gson);
                            break;
                        default:
                            return;
                    }

                    webhooks(defaultResponseTransformer, collect);

                    br.close();
                    isr.close();
                    //Отправка отправителю статус 200
                    String response = "200";
                    t.sendResponseHeaders(200, response.length());
                    OutputStream os = t.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                    //Закончена отправка
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private <E> void webhooks(ResponseTransformer<E> responseTransformer, String response) {
        if (responseTransformer != null) {
            WebhookListener transform = (WebhookListener) responseTransformer.transform(response);
            INITIATOR.handle(transform);
        }
    }

    public void addListener(ListenerAdapter listenerAdapter) {
        INITIATOR.addListener(listenerAdapter);
    }
    public void addListener(ListenerAdapter... listenerAdapter) {
        INITIATOR.addListener(listenerAdapter);
    }


    public String getXHookKey() {
        return XHookKey;
    }

    public String getPath() {
        return path;
    }

    public int getPort() {
        return port;
    }
}
