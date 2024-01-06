package org.boticordjava.api.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private String ok;
    private String service;
    private Errors[] errors;

}