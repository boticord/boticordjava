package org.boticordjava.api.entity.api.request;

public class ApiKeyRequest extends APIRequest {

    public ApiKeyRequest(String host) {
        super(String.format("%s/search-key", host), RequestMethod.GET);
    }
}