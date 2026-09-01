package com.dv.pokedex.core.openapi.common;

import com.dv.pokedex.core.exceptions.dto.ErrorResponseDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Meta-annotation that defines a reusable OpenAPI {@code 409 Conflict} response.
 *
 * <p>Apply this annotation to endpoint-level documentation annotations to automatically include a
 * standardized conflict response with an example {@link ErrorResponseDTO} payload when a resource
 * already exists or violates a uniqueness rule.
 *
 * @since 1.0.0
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ApiResponse(
        responseCode = "409",
        description = "The request conflicts with the current state of the resource (e.g. unique constraint violation).",
        content =
                @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponseDTO.class),
                        examples =
                                @ExampleObject(
                                        name = "ConflictResponse",
                                        summary = "Resource already exists response",
                                        value =
                                                """
                                                {
                                                  "timestamp": "2026-08-25T10:00:00Z",
                                                  "status": 409,
                                                  "error": "Conflict",
                                                  "message": "Pokemon with name 'Pikachu' already exists",
                                                  "errors": []
                                                }
                                                """)))
public @interface ConflictApiResponse {}
