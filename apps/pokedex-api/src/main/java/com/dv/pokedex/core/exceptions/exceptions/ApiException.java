package com.dv.pokedex.core.exceptions.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ApiException extends RuntimeException {
    /**
     * HTTP status associated with the exception.
     */
    private final HttpStatus httpStatus;

    /**
     * Creates a new business exception.
     *
     * @param httpStatus HTTP status that should be returned to the client.
     * @param message    human-readable description of the error.
     */
    protected ApiException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
