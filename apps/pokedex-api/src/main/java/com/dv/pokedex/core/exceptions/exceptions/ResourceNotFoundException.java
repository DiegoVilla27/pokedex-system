package com.dv.pokedex.core.exceptions.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {

    /**
     * Creates a new exception with the specified detail message.
     *
     * @param message error description.
     */
    public ResourceNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
