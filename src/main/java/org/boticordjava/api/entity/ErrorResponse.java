package org.boticordjava.api.entity;

public class ErrorResponse {

    public Errors error;

    public ErrorResponse(Errors error) {
        this.error = error;
    }

    public Errors getError() {
        return error;
    }
}
