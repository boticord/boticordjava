package org.boticordjava.api.io;

import com.google.gson.Gson;

public class DefaultWebSocketResponseTransformer<E> implements ResponseTransformer<E> {

    private final Gson gson;
    private final Class<E> resultClass;

    public DefaultWebSocketResponseTransformer(Gson gson, Class<E> resultClass) {
        this.gson = gson;
        this.resultClass = resultClass;
    }

    @Override
    public E transform(String response) {
        return gson.fromJson(response, resultClass);
    }
}
