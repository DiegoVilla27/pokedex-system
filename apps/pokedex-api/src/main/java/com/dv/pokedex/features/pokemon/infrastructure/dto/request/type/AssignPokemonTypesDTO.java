package com.dv.pokedex.features.pokemon.infrastructure.dto.request.type;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Schema(
        name = "AssignPokemonTypesRequest",
        description = "Set of type IDs to assign to the Pokémon (replaces previous type assignments)."
)
public record AssignPokemonTypesDTO(
        @ArraySchema(
                arraySchema = @Schema(description = "Set of elemental Type IDs (1 to 2 allowed).", example = "[13, 3]"),
                schema = @Schema(description = "Type ID", example = "13")
        )
        @NotEmpty(message = "Pokemon must have at least 1 type")
        @Size(min = 1, max = 2, message = "Pokemon can have at most 2 types")
        Set<Integer> typeIds
) {
}
