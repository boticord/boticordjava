package org.boticordjava.api.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.HttpUrl;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.boticordjava.api.TokenEnum;
import org.boticordjava.api.entity.*;
import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.entity.comments.Comments;
import org.boticordjava.api.entity.links.GetShortLink;
import org.boticordjava.api.entity.servers.serverinfo.ServerInfo;
import org.boticordjava.api.entity.users.botslist.DeveloperBots;
import org.boticordjava.api.entity.users.profile.UserProfile;
import org.boticordjava.api.entity.users.usercomments.UserComments;
import org.boticordjava.api.io.DefaultResponseTransformer;
import org.boticordjava.api.io.NullResponseException;
import org.boticordjava.api.io.ResponseTransformer;
import org.boticordjava.api.io.UnsuccessfulHttpException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class BotiCordAPIImpl implements BotiCordAPI {

    private final HttpUrl baseUrl;

    private final Gson gson;
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final String token, botId;
    private final TokenEnum tokenEnum;

    protected BotiCordAPIImpl(String token, String botId) {
        this.token = token;
        this.botId = botId;
        this.tokenEnum = null;

        baseUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("api.boticord.top")
                .addPathSegment("v1")
                .build();

        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    protected BotiCordAPIImpl(String token, String botId, TokenEnum tokenEnum) {
        this.token = token;
        this.botId = botId;
        this.tokenEnum = tokenEnum;

        baseUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("api.boticord.top")
                .addPathSegment("v2")
                .build();

        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public Result setStats(int servers, int shards, int users) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("stats")
                .build();

        JSONObject json = new JSONObject();

        try {
            json.put("servers", servers);
            json.put("shards", shards);
            json.put("users", users);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return post(url, json, new DefaultResponseTransformer<>(Result.class, gson));
    }

    @Override
    public Comments[] getBotComments() {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("bot")
                .addPathSegment(this.botId)
                .addPathSegment("comments")
                .build();

        return get(url, new DefaultResponseTransformer<>(Comments[].class, gson));
    }

    @Override
    public BotInfo getBotInformation(@NotNull String botId) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("bot")
                .addPathSegment(botId)
                .build();
        return get(url, new DefaultResponseTransformer<>(BotInfo.class, gson));
    }

    @Override
    public ServerInfo getServerInformation(@NotNull String botId) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("server")
                .addPathSegment(botId)
                .build();
        return get(url, new DefaultResponseTransformer<>(ServerInfo.class, gson));
    }

    @Override
    public Comments[] getServerComments(@NotNull String serverId) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("server")
                .addPathSegment(serverId)
                .addPathSegment("comments")
                .build();
        return get(url, new DefaultResponseTransformer<>(Comments[].class, gson));
    }

    @Override
    public GetShortLink[] getUserLinks(@NotNull String code) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("links")
                .addPathSegment("get")
                .build();

        JSONObject json = new JSONObject();

        json.put("code", code);

        return post(url, json, new DefaultResponseTransformer<>(GetShortLink[].class, gson));
    }

    @Override
    public GetShortLink[] getUserLinks() {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("links")
                .addPathSegment("get")
                .build();
        JSONObject json = new JSONObject();

        return post(url, json, new DefaultResponseTransformer<>(GetShortLink[].class, gson));
    }

    @Override
    public GetShortLink createShortLink(@NotNull String code, @NotNull String link, @NotNull Domain domain) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("links")
                .addPathSegment("create")
                .build();

        JSONObject json = new JSONObject();

        json.put("code", code);
        json.put("link", link);
        json.put("domain", domain.get());

        return post(url, json, new DefaultResponseTransformer<>(GetShortLink.class, gson));
    }

    @Override
    public GetShortLink createShortLink(@NotNull String code, @NotNull String link) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("links")
                .addPathSegment("create")
                .build();

        JSONObject json = new JSONObject();

        json.put("code", code);
        json.put("link", link);
        json.put("domain", 1);

        return post(url, json, new DefaultResponseTransformer<>(GetShortLink.class, gson));
    }

    @Override
    public Result deleteShortLink(@NotNull String code) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("links")
                .addPathSegment("delete")
                .build();

        JSONObject json = new JSONObject();
        json.put("code", code);

        return post(url, json, new DefaultResponseTransformer<>(Result.class, gson));
    }

    @Override
    public Result deleteShortLink(@NotNull String code, @NotNull Domain domain) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("links")
                .addPathSegment("delete")
                .build();

        JSONObject json = new JSONObject();

        json.put("code", code);
        json.put("domain", domain.get());

        return post(url, json, new DefaultResponseTransformer<>(Result.class, gson));
    }

    @Override
    public ResultServer setServerStats(@NotNull String serverId, int up, int status, @Nullable String serverName, @Nullable String serverAvatar, @Nullable String serverMembersAllCount, @Nullable String serverMembersOnlineCount, @Nullable String serverOwnerID) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("server")
                .build();

        JSONObject json = new JSONObject();

        try {

            json.put("serverID", serverId);
            json.put("up", up);
            json.put("status", status);

            if (serverName != null)
                json.put("serverName", serverName);

            if (serverAvatar != null)
                json.put("serverAvatar", serverAvatar);

            if (serverMembersAllCount != null)
                json.put("serverMembersAllCount", serverMembersAllCount);

            if (serverMembersOnlineCount != null)
                json.put("serverMembersOnlineCount", serverMembersOnlineCount);

            if (serverOwnerID != null)
                json.put("serverOwnerID", serverOwnerID);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return post(url, json, new DefaultResponseTransformer<>(ResultServer.class, gson));
    }

    @Override
    public DeveloperBots[] getDeveloperBots(String userId) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("bots")
                .addPathSegment(userId)
                .build();

        return get(url, new DefaultResponseTransformer<>(DeveloperBots[].class, gson));
    }

    @Override
    public UserComments getUserComments(String userId) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("profile")
                .addPathSegment(userId)
                .addPathSegment("comments")
                .build();

        return get(url, new DefaultResponseTransformer<>(UserComments.class, gson));
    }

    @Override
    public UserProfile getUserProfile(String userId) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("profile")
                .addPathSegment(userId)
                .build();

        return get(url, new DefaultResponseTransformer<>(UserProfile.class, gson));
    }

    private <E> E get(HttpUrl url, ResponseTransformer<E> responseTransformer) {
        HttpGet request = new HttpGet(url.uri());
        request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        request.addHeader(HttpHeaders.AUTHORIZATION, tokenHandler());

        return execute(request, responseTransformer);
    }

    private String tokenHandler() {
        if (tokenEnum != null) return tokenEnum.get() + this.token;
        return this.token;
    }

    private <E> E post(HttpUrl url, JSONObject jsonBody, ResponseTransformer<E> responseTransformer) {
        HttpPost request = new HttpPost(url.uri());
        request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        request.addHeader(HttpHeaders.AUTHORIZATION, tokenHandler());

        HttpEntity stringEntity = new StringEntity(jsonBody.toString(), ContentType.APPLICATION_JSON);
        request.setEntity(stringEntity);
        return execute(request, responseTransformer);
    }

    private <E> E execute(HttpRequestBase request, ResponseTransformer<E> responseTransformer) {
        HttpEntity entity;
        String body = null;
        try {
            CloseableHttpResponse response = httpClient.execute(request);

            // Get HttpResponse Status
//            System.out.println("Status: " + response.getStatusLine().getStatusCode() + " "
//                    + response.getStatusLine().getReasonPhrase());

            entity = response.getEntity();

            if (entity == null) {
                throw new NullResponseException();
            }

            body = EntityUtils.toString(entity);

//            System.out.println(body);
            if (response.getStatusLine().getStatusCode() == 401
                    || response.getStatusLine().getStatusCode() == 404
                    || response.getStatusLine().getStatusCode() == 403
                    || response.getStatusLine().getStatusCode() == 400) {
                ErrorResponse result = gson.fromJson(body, ErrorResponse.class);
                throw new UnsuccessfulHttpException(result.getError().getCode(), result.getError().getMessage());
            }
            if (response.getStatusLine().getStatusCode() == 429) {
                ErrorResponseToMany result = gson.fromJson(body, ErrorResponseToMany.class);
                throw new UnsuccessfulHttpException(result.getStatusCode(), result.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseTransformer.transform(body);
    }
}
