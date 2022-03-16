package org.boticordjava.api.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.HttpUrl;
import org.boticordjava.api.BotiCordAPI;
import org.boticordjava.api.entity.BotStats;
import org.boticordjava.api.entity.Comments;
import org.boticordjava.api.entity.Result;
import org.boticordjava.api.io.DefaultResponseTransformer;
import org.boticordjava.api.io.ResponseTransformer;
import org.boticordjava.api.io.UnsuccessfulHttpException;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BotiCordAPIAPIImpl implements BotiCordAPI {

    private static final HttpUrl baseUrl = new HttpUrl.Builder()
            .scheme("https")
            .host("api.boticord.top")
            .addPathSegment("v1")
            .build();

    private final Gson gson;

    private final String token, botId;

    public BotiCordAPIAPIImpl(String token, String botId) {
        this.token = token;
        this.botId = botId;

        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public Result setStats(int servers, int shards, int users) {
        JSONObject json = new JSONObject()
                .put("servers", servers)
                .put("shards", shards)
                .put("users", users);

        return setStats(json);
    }

    private Result setStats(JSONObject jsonBody) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("stats")
                .build();

        return post(url, jsonBody, new DefaultResponseTransformer<>(Result.class, gson));
    }

    public BotStats getBot(String botId) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("bot")
                .addPathSegment(botId)
                .build();

        return get(url, new DefaultResponseTransformer<>(BotStats.class, gson));
    }

    public Comments[] getBotComments() {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("bot")
                .addPathSegment(this.botId)
                .addPathSegment("comments")
                .build();

        System.out.println(url);

        return get(url, new DefaultResponseTransformer<>(Comments[].class, gson));
    }

    private <E> E get(HttpUrl url, ResponseTransformer<E> responseTransformer) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url.url().toString()))
                .GET()
                .header("Content-Type", "application/json")
                .header("Authorization", this.token)
                .build();

        return execute(client, req, responseTransformer);
    }

    private <E> E post(HttpUrl url, JSONObject jsonBody, ResponseTransformer<E> responseTransformer) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url.url().toString()))
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody.toString()))
                .header("Content-Type", "application/json")
                .header("Authorization", this.token)
                .build();
        return execute(client, req, responseTransformer);
    }

    private <E> E execute(HttpClient client, HttpRequest request, ResponseTransformer<E> responseTransformer) {
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new UnsuccessfulHttpException(response.statusCode(), response.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseTransformer.transform(response);
    }
}
