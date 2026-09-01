package com.dv.pokedex.features.stat.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.BadRequestApiResponse;
import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.core.openapi.common.NotFoundApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Delete Stat</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Delete combat stat",
        description = "Deletes a combat statistic from the system by its unique identifier."
)
@ApiResponse(
        responseCode = "204",
        description = "Combat stat deleted successfully.")
@BadRequestApiResponse
@NotFoundApiResponse
@InternalServerErrorApiResponse
public @interface DeleteStatDocumentation {}
