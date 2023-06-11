package org.boticordjava.api;

public class ResponseHandler<E> {

    private String ok;
    private E result;
    private String service;

    public String getOk() {
        return ok;
    }

    public E getResult() {
        return result;
    }

    public String getService() {
        return service;
    }
}