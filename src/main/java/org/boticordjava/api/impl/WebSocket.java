package org.boticordjava.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.boticordjava.api.entity.webhooks.bump.bot.BotBump;
import org.boticordjava.api.entity.webhooks.bump.server.ServerBump;
import org.boticordjava.api.entity.webhooks.comment.DeleteComment;
import org.boticordjava.api.entity.webhooks.comment.EditComment;
import org.boticordjava.api.entity.webhooks.comment.NewComment;
import org.boticordjava.api.entity.webhooks.test.TestMessage;
import org.boticordjava.api.io.DefaultResponseTransformer;
import org.boticordjava.api.io.ResponseTransformer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.stream.Collectors;

public class WebSocket {

    private final Gson gson;
    private final Queue<Object> webhookQueue;
    private final String XHookKey;
    private final String path;
    private final int port;

    public WebSocket(String xHookKey, String path, InetAddress ip, int port) {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.webhookQueue = new ArrayDeque<>();
        this.XHookKey = xHookKey;
        this.path = path;
        this.port = port;
        createServer(ip, port, path);
    }

    private void createServer(InetAddress ip, int port, String path) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(ip, port), 0);
            server.createContext(path == null ? "/" : path, new MyHandler());
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
                System.out.println("Test");
                Headers requestHeaders = t.getRequestHeaders();
                String hookKey = requestHeaders.get("X-Hook-Key")
                        .toString()
                        .replace("[", "")
                        .replace("]", "");

                System.out.println(hookKey);
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
                            defaultResponseTransformer = new DefaultResponseTransformer<>(NewComment.class, gson);
                            break;
                        case "edit_bot_comment":
                            defaultResponseTransformer = new DefaultResponseTransformer<>(EditComment.class, gson);
                            break;
                        case "delete_bot_comment":
                            defaultResponseTransformer = new DefaultResponseTransformer<>(DeleteComment.class, gson);
                            break;
//                        case "new_server_comment":
//                            defaultResponseTransformer = new DefaultResponseTransformer<>(Vote.class, gson);
//                            break;
//                        case "edit_server_comment":
//                            defaultResponseTransformer = new DefaultResponseTransformer<>(Vote.class, gson);
//                            break;
//                        case "delete_server_comment":
//                            defaultResponseTransformer = new DefaultResponseTransformer<>(Vote.class, gson);
//                            break;
                        case "new_server_bump":
                            defaultResponseTransformer = new DefaultResponseTransformer<>(ServerBump.class, gson);
                            break;
                        default: return;
                    }


                    webhooks(defaultResponseTransformer, collect);
                    System.out.println(collect);
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
            E transform = responseTransformer.transform(response);
            webhookQueue.add(transform);
        }
    }

    public Queue<Object> getWebhookQueue() {
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
