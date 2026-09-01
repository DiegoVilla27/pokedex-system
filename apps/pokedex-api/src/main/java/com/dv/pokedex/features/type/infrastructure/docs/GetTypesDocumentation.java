package com.dv.pokedex.features.type.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.features.type.domain.model.Type;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Get All Types</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Retrieve all elemental types",
        description = "Fetches the full catalog of registered Pokémon elemental types."
)
@ApiResponse(
        responseCode = "200",
        description = "List of elemental types retrieved successfully.",
        content =
                @Content(
                        mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = Type.class))))
@InternalServerErrorApiResponse
public @interface GetTypesDocumentation {}
