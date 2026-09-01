package com.dv.pokedex.features.pokemon.infrastructure.dto.request.pokemon;

import com.dv.pokedex.features.pokemon.infrastructure.dto.request.stat.PokemonStatDTO;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Set;

@Schema(
        name = "CreatePokemonRequest",
        description = "Payload required to register a new Pokémon profile."
)
public record CreatePokemonDTO(
        @Schema(
                description = "Name of the Pokémon.",
                example = "Pikachu",
                minLength = 2,
                maxLength = 50
        )
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        String name,

        @Schema(
                description = "Detailed lore and Pokédex entry description.",
                example = "When it smashes its foes with its tail, it releases strong electric shocks.",
                minLength = 2,
                maxLength = 500
        )
        @NotBlank(message = "Description is required")
        @Size(min = 2, max = 500, message = "Description must be between 2 and 500 characters")
        String description,

        @Schema(
                description = "URL pointing to the Pokémon official artwork or sprite.",
                example = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png",
                minLength = 2,
                maxLength = 200
        )
        @NotBlank(message = "Avatar is required")
        @Size(min = 2, max = 200, message = "Avatar must be between 2 and 200 characters")
        String avatar,

        @Schema(
                description = "Height of the Pokémon in meters.",
                example = "0.4",
                minimum = "0.1"
        )
        @NotNull(message = "Height is required")
        @DecimalMin(value = "0.1", message = "Height must be greater than 0")
        Double height,

        @Schema(
                description = "Weight of the Pokémon in kilograms.",
                example = "6.0",
                minimum = "0.1"
        )
        @NotNull(message = "Weight is required")
        @DecimalMin(value = "0.1", message = "Weight must be greater than 0")
        Double weight,

        @Schema(
                description = "Color configuration (RGB) for Pokémon theme."
        )
        @NotNull(message = "Color is required")
        @Valid
        PokemonColorDTO color,

        @ArraySchema(
                arraySchema = @Schema(description = "Set of elemental Type IDs (between 1 and 2 types allowed).", example = "[13]"),
                schema = @Schema(description = "Type ID", example = "13")
        )
        @NotEmpty(message = "Pokemon must have at least 1 type")
        @Size(min = 1, max = 2, message = "Pokemon can have at most 2 types")
        Set<Integer> typeIds,

        @ArraySchema(
                arraySchema = @Schema(description = "Set of initial combat stat assignments."),
                schema = @Schema(implementation = PokemonStatDTO.class)
        )
        @NotEmpty(message = "Pokemon must have stats")
        Set<@Valid PokemonStatDTO> stats
) {
}
