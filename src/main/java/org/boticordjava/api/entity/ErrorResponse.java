package org.boticordjava.api.entity;

public class ErrorResponse {

    Errors error;

    public ErrorResponse(Errors error) {
        this.error = error;
    }

    public Errors getError() {
        return error;
    }
}
