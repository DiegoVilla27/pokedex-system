package com.dv.pokedex.core.openapi.common;

import com.dv.pokedex.core.exceptions.dto.ErrorResponseDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Meta-annotation that defines a reusable OpenAPI {@code 404 Not Found} response.
 *
 * <p>Apply this annotation to endpoint-level documentation annotations to automatically include a
 * standardized not-found response with an example {@link ErrorResponseDTO} payload.
 *
 * @since 1.0.0
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ApiResponse(
        responseCode = "404",
        description = "The requested resource could not be found.",
        content =
                @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponseDTO.class),
                        examples =
                                @ExampleObject(
                                        name = "NotFoundResponse",
                                        summary = "Resource not found response",
                                        value =
                                                """
                                                {
                                                  "timestamp": "2026-08-25T10:00:00Z",
                                                  "status": 404,
                                                  "error": "Not Found",
                                                  "message": "Resource with identifier '25' was not found",
                                                  "errors": []
                                                }
                                                """)))
public @interface NotFoundApiResponse {}
