package com.dv.pokedex.features.pokemon.infrastructure.dto.request.pokemon;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

@Schema(
        name = "UpdatePokemonRequest",
        description = "Payload required to partially update Pokémon details. All fields are optional."
)
public record UpdatePokemonDTO(
        @Schema(
                description = "Updated name of the Pokémon.",
                example = "Raichu",
                minLength = 2,
                maxLength = 50,
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        String name,

        @Schema(
                description = "Updated Pokédex entry description.",
                example = "Its long tail serves as a ground to protect itself from its own high-voltage power.",
                minLength = 2,
                maxLength = 500,
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        @Size(min = 2, max = 500, message = "Description must be between 2 and 500 characters")
        String description,

        @Schema(
                description = "Updated URL for the official artwork/sprite.",
                example = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/26.png",
                minLength = 2,
                maxLength = 200,
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        @Size(min = 2, max = 200, message = "Avatar must be between 2 and 200 characters")
        String avatar,

        @Schema(
                description = "Updated height of the Pokémon in meters.",
                example = "0.8",
                minimum = "0.1",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        @DecimalMin(value = "0.1", message = "Height must be greater than 0")
        Double height,

        @Schema(
                description = "Updated weight of the Pokémon in kilograms.",
                example = "30.0",
                minimum = "0.1",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        @DecimalMin(value = "0.1", message = "Weight must be greater than 0")
        Double weight,

        @Schema(
                description = "Updated RGB color profile.",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        @Valid
        PokemonColorDTO color
) {
}
