package org.boticordjava.api.entity.api.request;

public class GetBotInfoRequest extends APIRequest {

    public GetBotInfoRequest(String host, String botId) {
        super(String.format("%s/bots/%s", host, botId), RequestMethod.GET);
    }
}