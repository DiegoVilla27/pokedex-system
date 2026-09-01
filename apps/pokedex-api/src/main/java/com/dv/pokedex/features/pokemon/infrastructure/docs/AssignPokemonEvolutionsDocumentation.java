package com.dv.pokedex.features.pokemon.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.BadRequestApiResponse;
import com.dv.pokedex.core.openapi.common.ConflictApiResponse;
import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.core.openapi.common.NotFoundApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Assign Pokemon Evolutions</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Assign evolutions to Pokémon",
        description = "Configures forward evolution paths and target Pokémon IDs for the specified Pokémon."
)
@ApiResponse(
        responseCode = "204",
        description = "Evolutions assigned successfully.")
@BadRequestApiResponse
@NotFoundApiResponse
@ConflictApiResponse
@InternalServerErrorApiResponse
public @interface AssignPokemonEvolutionsDocumentation {}
