package com.dv.pokedex.core.exceptions.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.List;

/**
 * Standardized error response payload returned by the API when an exception occurs.
 *
 * @param timestamp UTC timestamp when the error occurred.
 * @param status    HTTP status code (e.g., 400, 404, 409, 500).
 * @param error     Short name/reason of the HTTP status (e.g., "Bad Request", "Not Found").
 * @param message   Human-readable explanation of what caused the error.
 * @param errors    List of specific field validation errors, or empty list if not applicable.
 */
@Schema(
        name = "ErrorResponse",
        description = "Standardized error response payload following RFC 7807 problem details structure."
)
public record ErrorResponseDTO(
        @Schema(
                description = "UTC timestamp when the error occurred.",
                example = "2026-08-25T10:00:00Z"
        )
        Instant timestamp,

        @Schema(
                description = "HTTP status code.",
                example = "400"
        )
        Integer status,

        @Schema(
                description = "HTTP status reason phrase.",
                example = "Bad Request"
        )
        String error,

        @Schema(
                description = "Human-readable description of the error.",
                example = "The request contains validation errors"
        )
        String message,

        @Schema(
                description = "Collection of field-level validation errors, if applicable."
        )
        List<FieldErrorDTO> errors
) {
}
