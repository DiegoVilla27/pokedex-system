package com.dv.pokedex.features.pokemon.infrastructure.dto.request.stat;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

@Schema(
        name = "AssignPokemonStatsRequest",
        description = "Set of combat stats to assign to the Pokémon (replaces previous stat values)."
)
public record AssignPokemonStatsDTO(
        @ArraySchema(
                arraySchema = @Schema(description = "Set of stat ID and value mappings."),
                schema = @Schema(implementation = PokemonStatDTO.class)
        )
        @NotEmpty(message = "Pokemon must have stats")
        Set<@Valid PokemonStatDTO> stats
) {
}
