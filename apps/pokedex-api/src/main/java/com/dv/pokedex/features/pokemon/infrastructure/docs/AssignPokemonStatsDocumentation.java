package com.dv.pokedex.features.pokemon.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.BadRequestApiResponse;
import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.core.openapi.common.NotFoundApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Assign Pokemon Stats</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Assign stats to Pokémon",
        description = "Replaces or updates combat stat assignments for the specified Pokémon."
)
@ApiResponse(
        responseCode = "204",
        description = "Stats assigned successfully.")
@BadRequestApiResponse
@NotFoundApiResponse
@InternalServerErrorApiResponse
public @interface AssignPokemonStatsDocumentation {}
