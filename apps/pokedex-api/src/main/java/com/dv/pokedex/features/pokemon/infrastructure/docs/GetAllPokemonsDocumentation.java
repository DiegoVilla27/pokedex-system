package com.dv.pokedex.features.pokemon.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.features.pokemon.infrastructure.dto.response.PokemonResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Get All Pokemons</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Retrieve all Pokémon",
        description = "Fetches a complete list of all registered Pokémon along with their types, stats, and evolutions."
)
@ApiResponse(
        responseCode = "200",
        description = "List of Pokémon retrieved successfully.",
        content =
                @Content(
                        mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = PokemonResponseDto.class))))
@InternalServerErrorApiResponse
public @interface GetAllPokemonsDocumentation {}
