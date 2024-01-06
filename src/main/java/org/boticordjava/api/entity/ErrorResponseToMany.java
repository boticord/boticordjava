package org.boticordjava.api.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseToMany {

    private int statusCode;
    private String error;
    private String message;

}