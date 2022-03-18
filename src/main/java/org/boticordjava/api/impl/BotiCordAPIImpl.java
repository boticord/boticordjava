package org.boticordjava.api.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.HttpUrl;
import org.boticordjava.api.BotiCordAPI;
import org.boticordjava.api.entity.ErrorResponse;
import org.boticordjava.api.entity.Result;
import org.boticordjava.api.entity.ResultServer;
import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.entity.bot.stats.BotStats;
import org.boticordjava.api.entity.comments.Comments;
import org.boticordjava.api.entity.servers.serverinfo.ServerInfo;
import org.boticordjava.api.entity.users.botslist.DeveloperBots;
import org.boticordjava.api.entity.users.profile.UserProfile;
import org.boticordjava.api.entity.users.usercomments.UserComments;
import org.boticordjava.api.io.DefaultResponseTransformer;
import org.boticordjava.api.io.ResponseTransformer;
import org.boticordjava.api.io.UnsuccessfulHttpException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BotiCordAPIImpl implements BotiCordAPI {

    private static final HttpUrl baseUrl = new HttpUrl.Builder()
            .scheme("https")
            .host("api.boticord.top")
            .addPathSegment("v1")
            .build();

    private final Gson gson;

    private final String token, botId;

    public BotiCordAPIImpl(String token, String botId) {
        this.token = token;
        this.botId = botId;

        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public Result setStats(int servers, int shards, int users) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("stats")
                .build();

        JSONObject json = new JSONObject()
                .put("servers", servers)
                .put("shards", shards)
                .put("users", users);

        return post(url, json, new DefaultResponseTransformer<>(Result.class, gson));
    }

    @Override
    public BotStats getBot(@NotNull String botId) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("bot")
                .addPathSegment(botId)
                .build();

        return get(url, new DefaultResponseTransformer<>(BotStats.class, gson));
    }

    @Override
    public Comments[] getBotComments() {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("bot")
                .addPathSegment(this.botId)
                .addPathSegment("comments")
                .build();

        System.out.println(url);

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
    public ResultServer setServerStats(@NotNull String serverId, int up, int status, @Nullable String serverName, @Nullable String serverAvatar, @Nullable String serverMembersAllCount, @Nullable String serverMembersOnlineCount, @Nullable String serverOwnerID) {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("server")
                .build();

        JSONObject json = new JSONObject();

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

            if (response.statusCode() == 401 || response.statusCode() == 404 || response.statusCode() == 403) {
                ErrorResponse result = gson.fromJson(response.body(), ErrorResponse.class);
                throw new UnsuccessfulHttpException(result.getError().getCode(), result.getError().getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseTransformer.transform(response);
    }
}
