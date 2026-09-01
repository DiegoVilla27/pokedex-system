package com.dv.pokedex.features.pokemon.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.BadRequestApiResponse;
import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.core.openapi.common.NotFoundApiResponse;
import com.dv.pokedex.features.pokemon.infrastructure.dto.response.PokemonResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Get Pokemon by ID</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Get Pokémon by ID",
        description = "Retrieves a single Pokémon profile by its unique integer identifier."
)
@ApiResponse(
        responseCode = "200",
        description = "Pokémon found and retrieved successfully.",
        content =
                @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = PokemonResponseDto.class)))
@BadRequestApiResponse
@NotFoundApiResponse
@InternalServerErrorApiResponse
public @interface GetPokemonByIdDocumentation {}
