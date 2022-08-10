package org.boticordjava.api;

import org.boticordjava.api.entity.Enums.Endpoints;
import org.boticordjava.api.entity.Enums.TokenEnum;

import java.util.Arrays;
import java.util.Map;

public final class BoticordUtils {

    public static final Map<Endpoints, TokenEnum[]> accessMap = Map.ofEntries(
            Map.entry(Endpoints.GET_BOT_INFO, new TokenEnum[]{TokenEnum.BOT, TokenEnum.PRIVATE_BOT, TokenEnum.PROFILE, TokenEnum.NONE}),
            Map.entry(Endpoints.GET_BOT_COMMENTS, new TokenEnum[]{TokenEnum.BOT, TokenEnum.PRIVATE_BOT, TokenEnum.PROFILE}),
            Map.entry(Endpoints.POST_BOT_STATS, new TokenEnum[]{TokenEnum.BOT}),

            Map.entry(Endpoints.GET_SERVER_INFO, new TokenEnum[]{TokenEnum.BOT, TokenEnum.PRIVATE_BOT, TokenEnum.PROFILE, TokenEnum.NONE}),
            Map.entry(Endpoints.GET_SERVER_COMMENTS, new TokenEnum[]{TokenEnum.BOT, TokenEnum.PRIVATE_BOT, TokenEnum.PROFILE}),
            Map.entry(Endpoints.POST_SERVER_STATS, new TokenEnum[]{TokenEnum.BOT, TokenEnum.PRIVATE_BOT}),

            Map.entry(Endpoints.POST_LINKS_GET, new TokenEnum[]{TokenEnum.PROFILE}),
            Map.entry(Endpoints.POST_LINKS_CREATE, new TokenEnum[]{TokenEnum.PROFILE}),
            Map.entry(Endpoints.POST_LINKS_DELETE, new TokenEnum[]{TokenEnum.PROFILE}),

            Map.entry(Endpoints.GET_USER_INFO, new TokenEnum[]{TokenEnum.BOT, TokenEnum.PRIVATE_BOT, TokenEnum.PROFILE, TokenEnum.NONE}),
            Map.entry(Endpoints.GET_USER_COMMENTS, new TokenEnum[]{TokenEnum.BOT, TokenEnum.PRIVATE_BOT, TokenEnum.PROFILE}),
            Map.entry(Endpoints.GET_USER_BOTS, new TokenEnum[]{TokenEnum.BOT, TokenEnum.PRIVATE_BOT, TokenEnum.PROFILE}));


    public static boolean CanSendRequestToEndpoint(Endpoints endpoint, TokenEnum tokenEnum) {
        return Arrays.asList(accessMap.get(endpoint)).contains(tokenEnum);
    }
}