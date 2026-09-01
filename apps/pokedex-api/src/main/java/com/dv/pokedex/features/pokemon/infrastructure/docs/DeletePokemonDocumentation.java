package com.dv.pokedex.features.pokemon.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.BadRequestApiResponse;
import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.core.openapi.common.NotFoundApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Delete Pokemon</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Delete Pokémon",
        description = "Removes a Pokémon and its associated stats, types, and evolution relationships from the Pokédex."
)
@ApiResponse(
        responseCode = "204",
        description = "Pokémon deleted successfully.")
@BadRequestApiResponse
@NotFoundApiResponse
@InternalServerErrorApiResponse
public @interface DeletePokemonDocumentation {}
