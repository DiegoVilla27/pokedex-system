package com.dv.pokedex.features.pokemon.infrastructure.dto.request.stat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(
        name = "PokemonStatRequest",
        description = "Stat identifier and value assigned to a Pokémon."
)
public record PokemonStatDTO(
        @Schema(
                description = "Identifier of the base combat stat.",
                example = "1",
                minimum = "1"
        )
        @NotNull(message = "Stat ID is required")
        @Min(value = 1, message = "Stat ID must be at least 1")
        Integer statId,

        @Schema(
                description = "Base stat value for this Pokémon (1-255).",
                example = "35",
                minimum = "1",
                maximum = "255"
        )
        @NotNull(message = "Stat Value is required")
        @Min(value = 1, message = "Stat Value must be at least 1")
        @Max(value = 255, message = "Stat Value must be at most 255")
        Integer value
) {
}
