package org.boticordjava.api.entity;

public class ErrorResponse {

    private String ok;
    private String service;
    private Errors[] errors;

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Errors[] getErrors() {
        return errors;
    }

    public void setErrors(Errors[] errors) {
        this.errors = errors;
    }
}
