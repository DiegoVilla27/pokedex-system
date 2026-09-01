package com.dv.pokedex.features.pokemon.infrastructure.dto.request.evolution;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(
        name = "PokemonEvolutionRequest",
        description = "Target Pokémon identifier and sequence order in the evolution line."
)
public record PokemonEvolutionDTO(
        @Schema(
                description = "Identifier of the target evolved Pokémon.",
                example = "26",
                minimum = "1"
        )
        @NotNull(message = "Target Pokemon ID is required")
        @Positive(message = "Target Pokemon ID must be positive")
        Integer toPokemonId,

        @Schema(
                description = "Progression order/stage in the evolution chain.",
                example = "1",
                minimum = "1"
        )
        @NotNull(message = "Evolution order is required")
        @Min(value = 1, message = "Evolution order must be at least 1")
        Integer order
) {
}
