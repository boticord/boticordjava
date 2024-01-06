package org.boticordjava.api.impl;

import org.boticordjava.api.utils.JsonUtil;

public interface APIRequestData {

    default String toJson() {
        return JsonUtil.toJson(this);
    }
}