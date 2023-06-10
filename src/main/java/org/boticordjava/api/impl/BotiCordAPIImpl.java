package org.boticordjava.api.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.Config;
import com.meilisearch.sdk.Index;
import com.meilisearch.sdk.exceptions.MeilisearchException;
import com.meilisearch.sdk.model.SearchResult;
import okhttp3.HttpUrl;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.boticordjava.api.entity.ErrorResponse;
import org.boticordjava.api.entity.ErrorResponseToMany;
import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.entity.bot.stats.BotStats;
import org.boticordjava.api.entity.servers.serverinfo.ServerInfo;
import org.boticordjava.api.entity.servers.serverssearch.ServersSearch;
import org.boticordjava.api.entity.users.profile.UserProfile;
import org.boticordjava.api.io.DefaultResponseTransformer;
import org.boticordjava.api.io.ResponseTransformer;
import org.boticordjava.api.io.UnsuccessfulHttpException;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class BotiCordAPIImpl implements BotiCordAPI {

    private final HttpUrl baseUrl;

    private final Gson gson;
    private final String token;
    private final String searchApiKey;
    private final boolean devMode;

    protected BotiCordAPIImpl(String token, String searchApiKey, boolean devMode) {
        this.token = token;
        this.searchApiKey = searchApiKey;
        this.devMode = devMode;

        baseUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("api.arbuz.pro")
//                .addPathSegment("v3")
                .build();

        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public BotInfo setBotStats(@NotNull String botId, BotStats botStats) throws UnsuccessfulHttpException {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("bots")
                .addPathSegment(botId)
                .addPathSegment("stats")
                .build();

        JSONObject json = new JSONObject();

        try {
            json.put("members", botStats.getMembers());
            json.put("guilds", botStats.getGuilds());
            json.put("shards", botStats.getShards());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return post(url, json, new DefaultResponseTransformer<>(gson, BotInfo.class)).getResult();
    }

//    @Override
//    public Comments[] getBotComments(@NotNull String botId) throws UnsuccessfulHttpException {
//        HttpUrl url = baseUrl.newBuilder()
//                .addPathSegment("bot")
//                .addPathSegment(botId)
//                .addPathSegment("comments")
//                .build();
//
//        return get(url, new DefaultResponseTransformer<>(Comments[].class, gson));
//    }

    @Override
    public BotInfo getBotInfo(@NotNull String botId) throws UnsuccessfulHttpException {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("bots")
                .addPathSegment(botId)
                .build();
        return get(url, new DefaultResponseTransformer<>(gson, BotInfo.class)).getResult();
    }

    @Override
    public ServerInfo getServerInfo(@NotNull String serverId) throws UnsuccessfulHttpException {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("servers")
                .addPathSegment(serverId)
                .build();
        return get(url, new DefaultResponseTransformer<>(gson, ServerInfo.class)).getResult();
    }

    @Override
    public ServersSearch[] searchServers(String text) throws MeilisearchException, IllegalArgumentException {
        if (searchApiKey == null) throw new IllegalArgumentException("SearchApiKey is NULL!");

        Client client = new Client(new Config("https://api.arbuz.pro/search/", searchApiKey));
        Index index = client.index("servers");
        SearchResult searchResult = index.search(text);

        ArrayList<HashMap<String, Object>> hits = searchResult.getHits();

        for (HashMap<String, Object> hit : hits) {
            for (String key : hit.keySet()) {
                Object value = hit.get(key);


                System.out.println(key + ": " + value);
            }
            System.out.println();
        }


        return null;
    }

//    @Override
//    public Comments[] getServerComments(@NotNull String serverId) throws UnsuccessfulHttpException {
//        HttpUrl url = baseUrl.newBuilder()
//                .addPathSegment("server")
//                .addPathSegment(serverId)
//                .addPathSegment("comments")
//                .build();
//        return get(url, new DefaultResponseTransformer<>(Comments[].class, gson));
//    }

//    @Override
//    public GetShortLink[] getUserLinks(@NotNull String code) throws UnsuccessfulHttpException {
//        HttpUrl url = baseUrl.newBuilder()
//                .addPathSegment("links")
//                .addPathSegment("get")
//                .build();
//
//        JSONObject json = new JSONObject();
//
//        json.put("code", code);
//
//        return post(url, json, new DefaultResponseTransformer<>(GetShortLink[].class, gson));
//    }

//    @Override
//    public GetShortLink[] getUserLinks() throws UnsuccessfulHttpException {
//        HttpUrl url = baseUrl.newBuilder()
//                .addPathSegment("links")
//                .addPathSegment("get")
//                .build();
//        JSONObject json = new JSONObject();
//
//        return post(url, json, new DefaultResponseTransformer<>(GetShortLink[].class, gson));
//    }

//    @Override
//    public GetShortLink createShortLink(@NotNull String code, @NotNull String link, @NotNull Domain domain) throws UnsuccessfulHttpException {
//        HttpUrl url = baseUrl.newBuilder()
//                .addPathSegment("links")
//                .addPathSegment("create")
//                .build();
//
//        JSONObject json = new JSONObject();
//
//        json.put("code", code);
//        json.put("link", link);
//        json.put("domain", domain.get());
//
//        return post(url, json, new DefaultResponseTransformer<>(GetShortLink.class, gson));
//    }

//    @Override
//    public GetShortLink createShortLink(@NotNull String code, @NotNull String link) throws UnsuccessfulHttpException {
//        HttpUrl url = baseUrl.newBuilder()
//                .addPathSegment("links")
//                .addPathSegment("create")
//                .build();
//
//        JSONObject json = new JSONObject();
//
//        json.put("code", code);
//        json.put("link", link);
//        json.put("domain", 1);
//
//        return post(url, json, new DefaultResponseTransformer<>(GetShortLink.class, gson));
//    }

//    @Override
//    public Result deleteShortLink(@NotNull String code) throws UnsuccessfulHttpException {
//        HttpUrl url = baseUrl.newBuilder()
//                .addPathSegment("links")
//                .addPathSegment("delete")
//                .build();
//
//        JSONObject json = new JSONObject();
//        json.put("code", code);
//
//        return post(url, json, new DefaultResponseTransformer<>(Result.class, gson));
//    }

//    @Override
//    public Result deleteShortLink(@NotNull String code, @NotNull Domain domain) throws UnsuccessfulHttpException {
//        HttpUrl url = baseUrl.newBuilder()
//                .addPathSegment("links")
//                .addPathSegment("delete")
//                .build();
//
//        JSONObject json = new JSONObject();
//
//        json.put("code", code);
//        json.put("domain", domain.get());
//
//        return post(url, json, new DefaultResponseTransformer<>(Result.class, gson));
//    }

//    @Override
//    public UserComments getUserComments(String userId) throws UnsuccessfulHttpException {
//        HttpUrl url = baseUrl.newBuilder()
//                .addPathSegment("profile")
//                .addPathSegment(userId)
//                .addPathSegment("comments")
//                .build();
//
//        return get(url, new DefaultResponseTransformer<>(UserComments.class, gson));
//    }

    @Override
    public UserProfile getUserProfile(String userId) throws UnsuccessfulHttpException {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("users")
                .addPathSegment(userId)
                .build();
        return get(url, new DefaultResponseTransformer<>(gson, UserProfile.class)).getResult();
    }

    private String tokenHandler() {
        return this.token;
    }

    private <E> E get(HttpUrl url, ResponseTransformer<E> responseTransformer) throws UnsuccessfulHttpException {
        HttpGet request = new HttpGet(url.uri());
        request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        request.addHeader(HttpHeaders.AUTHORIZATION, tokenHandler());

        return execute(request, responseTransformer);
    }

    private <E> E post(HttpUrl url, JSONObject jsonBody, ResponseTransformer<E> responseTransformer) throws UnsuccessfulHttpException {
        HttpPost request = new HttpPost(url.uri());
        request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        request.addHeader(HttpHeaders.AUTHORIZATION, tokenHandler());

        HttpEntity stringEntity = new StringEntity(jsonBody.toString(), ContentType.APPLICATION_JSON);
        request.setEntity(stringEntity);
        return execute(request, responseTransformer);
    }

    private <E> E execute(ClassicHttpRequest request, ResponseTransformer<E> responseTransformer) throws UnsuccessfulHttpException {
        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionReuseStrategy(((requests, response, context) -> false))
                .useSystemProperties()
                .build();

        try {
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getCode();
                HttpEntity entity = response.getEntity();
                String body = entity != null ? EntityUtils.toString(entity) : null;
                if (body == null) body = "{}";

                logResponse(response, body);

                switch (statusCode) {
                    case 201:
                    case 200: {
                        return responseTransformer.transform(body);
                    }
                    case 400:
                    case 401:
                    case 403:
                    case 404: {
                        ErrorResponse result = gson.fromJson(body, ErrorResponse.class);
                        throw new UnsuccessfulHttpException(result.getErrors()[0].getCode(), result.getErrors()[0].getMessage());
                    }
                    case 429: {
                        ErrorResponseToMany result = gson.fromJson(body, ErrorResponseToMany.class);
                        throw new UnsuccessfulHttpException(result.getStatusCode(), result.getMessage());
                    }
                    case 502: {
                        body = "{\n" +
                                "  \"error\": {\n" +
                                "    \"code\": 502,\n" +
                                "    \"message\": \"Bad Gateway\"\n" +
                                "  }\n" +
                                "}";
                        ErrorResponse result = gson.fromJson(body, ErrorResponse.class);
                        throw new UnsuccessfulHttpException(502, result.getErrors()[0].getMessage());
                    }
                    default:
                        ErrorResponse result = gson.fromJson(body, ErrorResponse.class);
                        throw new UnsuccessfulHttpException(result.getErrors()[0].getCode(), result.getErrors()[0].getMessage());
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException();
    }

    private void logResponse(ClassicHttpResponse response, String body) {
        if (!devMode) return;
        String status = String.format("StatusCode: %s Reason: %s", response.getCode(), response.getReasonPhrase());
        System.out.println(status);
//        System.out.println(body);
        JsonElement jsonElement = JsonParser.parseString(body);
        String prettyJsonString = gson.toJson(jsonElement);
        System.out.println(prettyJsonString);
    }
}