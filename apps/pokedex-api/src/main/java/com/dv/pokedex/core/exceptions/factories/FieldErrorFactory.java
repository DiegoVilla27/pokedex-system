package com.dv.pokedex.core.exceptions.factories;

import com.dv.pokedex.core.exceptions.dto.FieldErrorDTO;
import org.springframework.stereotype.Component;

@Component
public class FieldErrorFactory {

    /**
     * Creates a field-level validation error.
     *
     * @param field   name of the field that caused the error.
     * @param value   rejected value received from the client.
     * @param message human-readable description of the validation error.
     * @return a new {@link FieldErrorDTO}.
     */
    public FieldErrorDTO build(String field, Object value, String message) {

        return new FieldErrorDTO(field, value, message);
    }
}
