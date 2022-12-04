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
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.stream.Collectors;

public class WebSocket {

    private final Gson gson;
    private final Queue<WebhookListener> webhookQueue;
    private final String XHookKey;
    private final String path;
    private final int port;

    /**
     * @param xHookKey String X-Hook-Key for filter request
     * @param path String Can be NULL. Example: <a href="https://api.megoru.ru/path">https://api.megoru.ru/*path*</a>
     * @param port int You can use one of the free ports on your system
     */
    public WebSocket(String xHookKey, @Nullable String path, int port) {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.webhookQueue = new ArrayDeque<>();
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
                String hookKey = requestHeaders.get("X-Hook-Key")
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

                    String type = result.get("type").toString();

                    DefaultResponseTransformer<?> defaultResponseTransformer;

                    switch (type) {
                        case "new_bot_bump":
                            defaultResponseTransformer = new DefaultResponseTransformer<>(BotBump.class, gson);
                            break;
                        case "test_webhook_message":
                            defaultResponseTransformer = new DefaultResponseTransformer<>(TestMessage.class, gson);
                            break;
                        case "new_bot_comment":
                        case "edit_bot_comment":
                        case "delete_bot_comment":
                        case "new_server_comment":
                        case "edit_server_comment":
                        case "delete_server_comment":
                            defaultResponseTransformer = new DefaultResponseTransformer<>(CommentAction.class, gson);
                            break;
                        case "new_server_bump":
                            defaultResponseTransformer = new DefaultResponseTransformer<>(ServerBump.class, gson);
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
            webhookQueue.add(transform);
        }
    }

    public Queue<WebhookListener> getWebhookQueue() {
        return webhookQueue;
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
