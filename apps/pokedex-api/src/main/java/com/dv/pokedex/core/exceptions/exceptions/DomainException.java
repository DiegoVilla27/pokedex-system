package com.dv.pokedex.core.exceptions.exceptions;

import org.springframework.http.HttpStatus;

public class DomainException extends ApiException {

    /**
     * Creates a new domain exception with the specified detail message.
     *
     * @param message human-readable description of the violated invariant.
     */
    public DomainException(String message) {
        super(HttpStatus.UNPROCESSABLE_CONTENT, message);
    }
}
