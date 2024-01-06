package org.boticordjava.api.entity.api.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.boticordjava.api.entity.Errors;
import org.boticordjava.api.entity.users.profile.UserProfile;
import org.boticordjava.api.impl.APIObject;
import org.boticordjava.api.utils.SearchKey;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchApiKeyResponse implements APIObject {

    @SerializedName("ok")
    private boolean ok;

    @SerializedName("result")
    private SearchKey result;

    @SerializedName("service")
    private String service;

    @SerializedName("errors")
    private Errors[] errors;
}