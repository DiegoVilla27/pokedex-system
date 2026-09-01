package com.dv.pokedex.features.stat.domain.exceptions;

import com.dv.pokedex.core.exceptions.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class StatAlreadyExists extends ApiException {

    /**
     * Creates a new exception with a standard conflict message.
     */
    public StatAlreadyExists() {
        super(HttpStatus.CONFLICT, "A stats with this name already exists.");
    }
}