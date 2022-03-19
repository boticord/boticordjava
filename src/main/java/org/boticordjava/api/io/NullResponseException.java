package org.boticordjava.api.io;

public class NullResponseException extends Exception {

    public NullResponseException() {
        super("response is NULL");
    }
}
