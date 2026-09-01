package com.dv.pokedex.core.openapi.common;

import com.dv.pokedex.core.exceptions.dto.ErrorResponseDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Meta-annotation that defines a reusable OpenAPI {@code 400 Bad Request} response.
 *
 * <p>Apply this annotation to endpoint-level documentation annotations to automatically include a
 * standardized bad-request response with an example {@link ErrorResponseDTO} payload containing
 * field-level validation errors or invalid parameter details.
 *
 * @since 1.0.0
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ApiResponse(
        responseCode = "400",
        description = "The request is invalid, contains malformed JSON, or fails field-level validation constraints.",
        content =
                @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponseDTO.class),
                        examples =
                                @ExampleObject(
                                        name = "BadRequestResponse",
                                        summary = "Validation error response",
                                        value =
                                                """
                                                {
                                                  "timestamp": "2026-08-25T10:00:00Z",
                                                  "status": 400,
                                                  "error": "Bad Request",
                                                  "message": "The request contains validation errors",
                                                  "errors": [
                                                    {
                                                      "field": "name",
                                                      "value": "P",
                                                      "message": "Name must be between 2 and 50 characters"
                                                    },
                                                    {
                                                      "field": "height",
                                                      "value": 0,
                                                      "message": "Height must be greater than 0"
                                                    }
                                                  ]
                                                }
                                                """)))
public @interface BadRequestApiResponse {}
