package org.boticordjava.api.entity.api.request;

public class GetServerInfoRequest extends APIRequest {

    public GetServerInfoRequest(String host, String serverId) {
        super(String.format("%s/servers/%s", host, serverId), RequestMethod.GET);
    }
}
