package com.dv.pokedex.core.openapi.common;

import com.dv.pokedex.core.exceptions.dto.ErrorResponseDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Meta-annotation that defines a reusable OpenAPI {@code 405 Method Not Allowed} response.
 *
 * <p>Apply this annotation to endpoint-level documentation annotations to automatically include a
 * standardized method-not-allowed response with an example {@link ErrorResponseDTO} payload.
 *
 * @since 1.0.0
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ApiResponse(
        responseCode = "405",
        description = "The HTTP method used is not supported for this endpoint.",
        content =
                @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponseDTO.class),
                        examples =
                                @ExampleObject(
                                        name = "MethodNotAllowedResponse",
                                        summary = "HTTP method not allowed response",
                                        value =
                                                """
                                                {
                                                  "timestamp": "2026-08-25T10:00:00Z",
                                                  "status": 405,
                                                  "error": "Method Not Allowed",
                                                  "message": "The requested HTTP method is not allowed for this resource.",
                                                  "errors": [
                                                    {
                                                      "field": "method",
                                                      "value": "POST",
                                                      "message": "HTTP method not supported."
                                                    }
                                                  ]
                                                }
                                                """)))
public @interface MethodNotAllowedApiResponse {}
