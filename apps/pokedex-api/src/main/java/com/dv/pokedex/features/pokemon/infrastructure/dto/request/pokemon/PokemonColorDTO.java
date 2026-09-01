package com.dv.pokedex.features.pokemon.infrastructure.dto.request.pokemon;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(
        name = "PokemonColorRequest",
        description = "RGB color definition for the Pokémon UI card theme."
)
public record PokemonColorDTO(
        @Schema(
                description = "Red channel intensity (0-255).",
                example = "255",
                minimum = "0",
                maximum = "255"
        )
        @NotNull(message = "Color RED is required")
        @Min(value = 0, message = "Color RED must be at least 0")
        @Max(value = 255, message = "Color RED must be at most 255")
        Integer r,

        @Schema(
                description = "Green channel intensity (0-255).",
                example = "204",
                minimum = "0",
                maximum = "255"
        )
        @NotNull(message = "Color GREEN is required")
        @Min(value = 0, message = "Color GREEN must be at least 0")
        @Max(value = 255, message = "Color GREEN must be at most 255")
        Integer g,

        @Schema(
                description = "Blue channel intensity (0-255).",
                example = "0",
                minimum = "0",
                maximum = "255"
        )
        @NotNull(message = "Color BLUE is required")
        @Min(value = 0, message = "Color BLUE must be at least 0")
        @Max(value = 255, message = "Color BLUE must be at most 255")
        Integer b
) {
}
