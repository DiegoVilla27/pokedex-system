package com.dv.pokedex.features.pokemon.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.BadRequestApiResponse;
import com.dv.pokedex.core.openapi.common.ConflictApiResponse;
import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.features.pokemon.infrastructure.dto.response.PokemonResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Create Pokemon</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Create a new Pokémon",
        description = "Registers a new Pokémon with physical dimensions, theme color, assigned types, and initial stats."
)
@ApiResponse(
        responseCode = "201",
        description = "Pokémon created successfully.",
        content =
                @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = PokemonResponseDto.class)))
@BadRequestApiResponse
@ConflictApiResponse
@InternalServerErrorApiResponse
public @interface CreatePokemonDocumentation {}
