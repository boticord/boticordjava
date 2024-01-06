package org.boticordjava.api.entity.api.request;

public class GetUserProfileRequest extends APIRequest {

    public GetUserProfileRequest(String host, String userId) {
        super(String.format("%s/users/%s", host, userId), RequestMethod.GET);
    }
}
