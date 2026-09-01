package com.dv.pokedex.features.type.domain.exceptions;

import com.dv.pokedex.core.exceptions.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class TypeAlreadyExists extends ApiException {
    public TypeAlreadyExists() {
        super(HttpStatus.CONFLICT, "A pokemon type with this name already exists.");
    }
}
