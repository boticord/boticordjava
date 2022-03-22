package org.boticordjava.api.io;

public interface ResponseTransformer<E> {

    E transform(String response);
}