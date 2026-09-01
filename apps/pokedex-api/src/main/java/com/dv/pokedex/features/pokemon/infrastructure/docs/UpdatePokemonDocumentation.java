package com.dv.pokedex.features.pokemon.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.BadRequestApiResponse;
import com.dv.pokedex.core.openapi.common.ConflictApiResponse;
import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.core.openapi.common.NotFoundApiResponse;
import com.dv.pokedex.features.pokemon.infrastructure.dto.response.PokemonResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Update Pokemon</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Update Pokémon details",
        description = "Partially updates general information (name, description, avatar, height, weight, color) of an existing Pokémon."
)
@ApiResponse(
        responseCode = "200",
        description = "Pokémon updated successfully.",
        content =
                @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = PokemonResponseDto.class)))
@BadRequestApiResponse
@NotFoundApiResponse
@ConflictApiResponse
@InternalServerErrorApiResponse
public @interface UpdatePokemonDocumentation {}
