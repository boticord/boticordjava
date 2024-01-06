package org.boticordjava.api.entity.api.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.boticordjava.api.entity.Errors;
import org.boticordjava.api.entity.bot.botinfo.BotInfo;
import org.boticordjava.api.impl.APIObject;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BotInfoResponse implements APIObject {

    @SerializedName("ok")
    private boolean ok;

    @SerializedName("result")
    private BotInfo result;

    @SerializedName("service")
    private String service;

    @SerializedName("errors")
    private Errors[] errors;
}