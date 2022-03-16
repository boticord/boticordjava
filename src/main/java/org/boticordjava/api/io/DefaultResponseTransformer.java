package org.boticordjava.api.io;

import com.google.gson.Gson;

import java.net.http.HttpResponse;

public class DefaultResponseTransformer<E> implements ResponseTransformer<E> {

    private final Class<E> aClass;
    private final Gson gson;

    public DefaultResponseTransformer(Class<E> aClass, Gson gson) {
        this.aClass = aClass;
        this.gson = gson;
    }

    @Override
    public E transform(HttpResponse<String> response) {
        return gson.fromJson(response.body(), aClass);
    }
}
