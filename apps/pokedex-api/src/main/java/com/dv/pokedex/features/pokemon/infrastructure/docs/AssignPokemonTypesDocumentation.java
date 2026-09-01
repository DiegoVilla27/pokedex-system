package com.dv.pokedex.features.pokemon.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.BadRequestApiResponse;
import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.core.openapi.common.NotFoundApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Assign Pokemon Types</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Assign elemental types to Pokémon",
        description = "Replaces the elemental types assigned to the specified Pokémon (1 or 2 types allowed)."
)
@ApiResponse(
        responseCode = "204",
        description = "Types assigned successfully.")
@BadRequestApiResponse
@NotFoundApiResponse
@InternalServerErrorApiResponse
public @interface AssignPokemonTypesDocumentation {}
