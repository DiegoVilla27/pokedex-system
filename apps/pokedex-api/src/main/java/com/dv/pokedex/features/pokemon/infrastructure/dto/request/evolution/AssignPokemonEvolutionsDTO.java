package com.dv.pokedex.features.pokemon.infrastructure.dto.request.evolution;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

@Schema(
        name = "AssignPokemonEvolutionsRequest",
        description = "Set of evolution transitions to assign to the Pokémon."
)
public record AssignPokemonEvolutionsDTO(
        @ArraySchema(
                arraySchema = @Schema(description = "Set of target evolutions with their order."),
                schema = @Schema(implementation = PokemonEvolutionDTO.class)
        )
        @NotEmpty(message = "Evolutions cannot be empty")
        Set<@Valid PokemonEvolutionDTO> evolutions
) {
}
