package com.dv.pokedex.features.type.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.BadRequestApiResponse;
import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.core.openapi.common.NotFoundApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Delete Type</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Delete elemental type",
        description = "Deletes an elemental type from the system by its unique identifier."
)
@ApiResponse(
        responseCode = "204",
        description = "Elemental type deleted successfully.")
@BadRequestApiResponse
@NotFoundApiResponse
@InternalServerErrorApiResponse
public @interface DeleteTypeDocumentation {}
