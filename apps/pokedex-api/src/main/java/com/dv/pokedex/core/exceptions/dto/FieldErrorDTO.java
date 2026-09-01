package com.dv.pokedex.core.exceptions.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Details of a specific field validation error.
 *
 * @param field   The name of the field that failed validation.
 * @param value   The invalid value provided in the request (may be null).
 * @param message The validation error message explaining why the value is invalid.
 */
@Schema(
        name = "FieldError",
        description = "Details about a specific field-level validation failure."
)
public record FieldErrorDTO(
        @Schema(
                description = "Name of the invalid property/field.",
                example = "name"
        )
        String field,

        @Schema(
                description = "The rejected invalid value supplied by the client.",
                example = "P"
        )
        Object value,

        @Schema(
                description = "Validation failure reason message.",
                example = "Name must be between 2 and 50 characters"
        )
        String message
) {
}