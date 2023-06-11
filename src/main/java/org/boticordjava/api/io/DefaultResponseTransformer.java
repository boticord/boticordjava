package org.boticordjava.api.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.boticordjava.api.ResponseHandler;

import java.lang.reflect.Type;

public class DefaultResponseTransformer<E> implements ResponseTransformer<ResponseHandler<E>> {

    private final Gson gson;
    private final Class<E> resultClass;

    public DefaultResponseTransformer(Gson gson, Class<E> resultClass) {
        this.gson = gson;
        this.resultClass = resultClass;
    }

    @Override
    public ResponseHandler<E> transform(String response) {
        Type responseType = TypeToken.getParameterized(ResponseHandler.class, resultClass).getType();
        return gson.fromJson(response, responseType);
    }
}