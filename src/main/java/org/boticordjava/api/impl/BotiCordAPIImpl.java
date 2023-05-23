package org.boticordjava.api.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import okhttp3.HttpUrl;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.boticordjava.api.ResponseHandler;
import org.boticordjava.api.entity.ErrorResponse;
import org.boticordjava.api.entity.ErrorResponseToMany;
import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.io.DefaultResponseTransformer;
import org.boticordjava.api.io.ResponseTransformer;
import org.boticordjava.api.io.UnsuccessfulHttpException;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class BotiCordAPIImpl implements BotiCordAPI {

    private final HttpUrl baseUrl;

    private final Gson gson;
    private final String token;
    private final boolean devMode;

    protected BotiCordAPIImpl(String token, boolean devMode) {
        this.token = token;
        this.devMode = devMode;

        baseUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("api.arbuz.pro")
//                .addPathSegment("v3")
                .build();

        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public BotInfo setStats(@NotNull String botId, int members, int guilds, int shards) throws UnsuccessfulHttpException {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("bots")
                .addPathSegment(botId)
                .addPathSegment("stats")
                .build();

        JSONObject json = new JSONObject();

        try {
            json.put("members", members);
            json.put("guilds", guilds);
            json.put("shards", shards);
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
    public BotInfo getBotInformation(@NotNull String botId) throws UnsuccessfulHttpException {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("bots")
                .addPathSegment(botId)
                .build();
        return get(url, new DefaultResponseTransformer<>(gson, BotInfo.class)).getResult();
    }

//    @Override
//    public ServerInfo getServerInformation(@NotNull String botId) throws UnsuccessfulHttpException {
//        HttpUrl url = baseUrl.newBuilder()
//                .addPathSegment("server")
//                .addPathSegment(botId)
//                .build();
//        return get(url, new DefaultResponseTransformer<>(ServerInfo.class, gson));
//    }

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
//    public ResultServer setServerStats(@NotNull String serverId, int up, int status, @Nullable String serverName, @Nullable String serverAvatar, @Nullable String serverMembersAllCount, @Nullable String serverMembersOnlineCount, @Nullable String serverOwnerID) throws UnsuccessfulHttpException {
//        HttpUrl url = baseUrl.newBuilder()
//                .addPathSegment("server")
//                .build();
//
//        JSONObject json = new JSONObject();
//
//        try {
//
//            json.put("serverID", serverId);
//            json.put("up", up);
//            json.put("status", status);
//
//            if (serverName != null)
//                json.put("serverName", serverName);
//
//            if (serverAvatar != null)
//                json.put("serverAvatar", serverAvatar);
//
//            if (serverMembersAllCount != null)
//                json.put("serverMembersAllCount", serverMembersAllCount);
//
//            if (serverMembersOnlineCount != null)
//                json.put("serverMembersOnlineCount", serverMembersOnlineCount);
//
//            if (serverOwnerID != null)
//                json.put("serverOwnerID", serverOwnerID);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return post(url, json, new DefaultResponseTransformer<>(ResultServer.class, gson));
//    }

    //TODO: разобраться
//    @Override
//    public DeveloperBots[] getDeveloperBots(String userId) throws UnsuccessfulHttpException {
//        HttpUrl url = baseUrl.newBuilder()
//                .addPathSegment("bots")
//                .addPathSegment(userId)
//                .build();
//
//        return get(url, new DefaultResponseTransformer<>(DeveloperBots[].class, gson));
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

//    @Override
//    public UserProfile getUserProfile(String userId) throws UnsuccessfulHttpException {
//        HttpUrl url = baseUrl.newBuilder()
//                .addPathSegment("profile")
//                .addPathSegment(userId)
//                .build();
//
//        return get(url, new DefaultResponseTransformer<>(UserProfile.class, gson));
//    }

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