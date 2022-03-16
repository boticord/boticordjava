package org.boticordjava.api.io;

import java.net.http.HttpResponse;

public interface ResponseTransformer<E> {

    E transform(HttpResponse<String> response);
}