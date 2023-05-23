package org.boticordjava.api.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.boticordjava.api.ResponseHandler;

import java.lang.reflect.Type;

public class DefaultResponseTransformer<T> implements ResponseTransformer<ResponseHandler<T>> {

    private final Gson gson;
    private final Class<T> resultClass;

    public DefaultResponseTransformer(Gson gson, Class<T> resultClass) {
        this.gson = gson;
        this.resultClass = resultClass;
    }

    @Override
    public ResponseHandler<T> transform(String response) {
        Type responseType = TypeToken.getParameterized(ResponseHandler.class, resultClass).getType();
        return gson.fromJson(response, responseType);
    }
}