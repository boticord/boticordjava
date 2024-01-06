package org.boticordjava.api.entity.api.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.boticordjava.api.entity.Errors;
import org.boticordjava.api.entity.servers.serverinfo.ServerInfo;
import org.boticordjava.api.impl.APIObject;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServerInfoResponse implements APIObject {

    @SerializedName("ok")
    private boolean ok;

    @SerializedName("result")
    private ServerInfo result;

    @SerializedName("service")
    private String service;

    @SerializedName("errors")
    private Errors[] errors;
}