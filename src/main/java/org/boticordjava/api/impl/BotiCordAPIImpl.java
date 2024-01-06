package org.boticordjava.api.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.Config;
import com.meilisearch.sdk.Index;
import com.meilisearch.sdk.SearchRequest;
import com.meilisearch.sdk.exceptions.MeilisearchException;
import com.meilisearch.sdk.model.SearchResult;
import com.meilisearch.sdk.model.Searchable;
import okhttp3.*;
import org.apache.hc.core5.http.HttpHeaders;
import org.boticordjava.api.entity.api.request.*;
import org.boticordjava.api.entity.api.response.*;
import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.entity.bot.botssearch.BotsSearch;
import org.boticordjava.api.entity.bot.stats.BotStats;
import org.boticordjava.api.entity.servers.serverinfo.ServerInfo;
import org.boticordjava.api.entity.servers.serverssearch.ServersSearch;
import org.boticordjava.api.entity.users.profile.UserProfile;
import org.boticordjava.api.entity.users.usercommentsearch.UsersCommentSearch;
import org.boticordjava.api.utils.JsonUtil;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class BotiCordAPIImpl implements BotiCordAPI {

    private static final OkHttpClient CLIENT = new OkHttpClient();
    private final String SEARCH_URL = "https://api.boticord.top/search/";
    private final String HOST = "https://api.boticord.top/v3";
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    private final Gson gson = new Gson();
    private final String token;
    private String searchApiKey = null;
    private final boolean devMode;

    protected BotiCordAPIImpl(String token, boolean devMode) {
        this.token = token;
        this.devMode = devMode;
    }

    private String getSearchApiKey() throws IOException {
        SearchApiKeyResponse setBotStatsResponse = parseResponse(SearchApiKeyResponse.class, new ApiKeyRequest(HOST));
        return setBotStatsResponse.getResult().getKey();
    }

    @Override
    public BotInfo setBotStats(@NotNull String botId, BotStats botStats) throws IOException {
        SetBotStatsResponse setBotStatsResponse = parseResponse(SetBotStatsResponse.class, new SetBotStatsRequest(HOST, botId, botStats));
        return setBotStatsResponse.getResult();
    }

    @Override
    public BotInfo getBotInfo(@NotNull String botId) throws IOException {
        BotInfoResponse botInfoResponse = parseResponse(BotInfoResponse.class, new GetBotInfoRequest(HOST, botId));
        return botInfoResponse.getResult();
    }

    @Override
    public ServerInfo getServerInfo(@NotNull String serverId) throws IOException {
        ServerInfoResponse serverInfoResponse = parseResponse(ServerInfoResponse.class, new GetServerInfoRequest(HOST, serverId));
        return serverInfoResponse.getResult();
    }

    @Override
    public UserProfile getUserProfile(@NotNull String userId) throws IOException {
        GetUserProfileResponse serverInfoResponse = parseResponse(GetUserProfileResponse.class, new GetUserProfileRequest(HOST, userId));
        return serverInfoResponse.getResult();
    }

    private void getApiSearchKey() {
        try {
            if (searchApiKey == null) {
                this.searchApiKey = getSearchApiKey();
                System.out.println(searchApiKey);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ServersSearch> searchServers(@NotNull String text) throws MeilisearchException, IllegalArgumentException, JsonProcessingException {
        getApiSearchKey();
        Client client = new Client(new Config(SEARCH_URL, searchApiKey));
        Index index = client.index("servers");
        SearchResult searchResult = index.search(text);
        ArrayList<HashMap<String, Object>> hits = searchResult.getHits();
        List<ServersSearch> serverInfoList = new ArrayList<>(hits.size() + 1);
        for (HashMap<String, Object> hit : hits) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(hit);
            ServersSearch serverInfo = gson.fromJson(json, ServersSearch.class);
            serverInfoList.add(serverInfo);
        }
        return serverInfoList;
    }

    @Override
    public List<BotsSearch> searchBots(@NotNull String text) throws MeilisearchException, IllegalArgumentException, JsonProcessingException {
        getApiSearchKey();
        Client client = new Client(new Config(SEARCH_URL, searchApiKey));
        Index index = client.index("bots");
        SearchResult searchResult = index.search(text);
        ArrayList<HashMap<String, Object>> hits = searchResult.getHits();
        List<BotsSearch> botsSearchList = new ArrayList<>(hits.size() + 1);
        for (HashMap<String, Object> hit : hits) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(hit);
            System.out.println(json);
            BotsSearch botsSearch = gson.fromJson(json, BotsSearch.class);
            botsSearchList.add(botsSearch);
        }
        return botsSearchList;
    }

    @Override
    public List<UsersCommentSearch> searchUserComments(@NotNull String resourceId) throws MeilisearchException, IllegalArgumentException, JsonProcessingException {
        getApiSearchKey();
        Client client = new Client(new Config(SEARCH_URL, searchApiKey));
        String format = String.format("resource = %s", resourceId);
        String[] filter = new String[]{format};
        SearchRequest searchRequest = SearchRequest.builder()
                .filter(filter)
                .q("")
                .build();
        Index index = client.index("comments");
        Searchable searchResult = index.search(searchRequest);
        ArrayList<HashMap<String, Object>> hits = searchResult.getHits();
        List<UsersCommentSearch> usersCommentSearchesList = new ArrayList<>(hits.size() + 1);
        for (HashMap<String, Object> hit : hits) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(hit);
            UsersCommentSearch usersCommentSearch = gson.fromJson(json, UsersCommentSearch.class);
            usersCommentSearchesList.add(usersCommentSearch);
        }
        return usersCommentSearchesList;
    }

    private <T extends APIObject> T parseResponse(Class<T> tClass, @NotNull APIRequest apiRequest) throws IOException {
        Request.Builder requestBuilder = new Request.Builder()
                .url(apiRequest.getUrl())
                .addHeader("Content-Type", "application/json")
                .addHeader(HttpHeaders.AUTHORIZATION, token);

        if (apiRequest.getRequestMethod() == APIRequest.RequestMethod.GET) {
            requestBuilder = requestBuilder.get();
        } else if (apiRequest.getRequestMethod() == APIRequest.RequestMethod.POST) {
            if (apiRequest.getData() != null) {
                requestBuilder.post(RequestBody.create(apiRequest.getData().toJson(), MEDIA_TYPE_JSON));
            } else {
                requestBuilder.post(RequestBody.create("{}", MEDIA_TYPE_JSON));
            }
        }

        Request request = requestBuilder.build();

        try (Response response = CLIENT.newCall(request).execute()) {
            String responseBody = Objects.requireNonNull(response.body()).string();
            logResponse(responseBody);
            return JsonUtil.fromJson(responseBody, tClass);
        }
    }

    private void logResponse(String body) {
        if (devMode) System.out.printf("Body: %s%n", body);
    }
}