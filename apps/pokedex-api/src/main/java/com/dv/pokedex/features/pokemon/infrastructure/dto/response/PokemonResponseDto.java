package com.dv.pokedex.features.pokemon.infrastructure.dto.response;

import com.dv.pokedex.features.pokemon.domain.vo.PokemonColor;
import com.dv.pokedex.features.pokemon.domain.vo.PokemonEvolution;
import com.dv.pokedex.features.pokemon.domain.vo.PokemonStat;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

@Schema(
        name = "PokemonResponse",
        description = "Detailed profile and catalog information of a Pokémon."
)
public record PokemonResponseDto(
        @Schema(
                description = "Unique numeric identifier of the Pokémon.",
                example = "25"
        )
        Integer id,

        @Schema(
                description = "Name of the Pokémon.",
                example = "pikachu"
        )
        String name,

        @Schema(
                description = "Official lore and Pokédex entry description.",
                example = "When several of these Pokémon gather, their electricity could build and cause lightning storms."
        )
        String description,

        @Schema(
                description = "URL pointing to the official artwork or sprite.",
                example = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/25.png"
        )
        String avatar,

        @Schema(
                description = "Height of the Pokémon in meters.",
                example = "0.4"
        )
        Double height,

        @Schema(
                description = "Weight of the Pokémon in kilograms.",
                example = "6.0"
        )
        Double weight,

        @Schema(
                description = "RGB color profile used for UI theming."
        )
        PokemonColor color,

        @ArraySchema(
                arraySchema = @Schema(description = "Set of assigned elemental type IDs."),
                schema = @Schema(description = "Elemental type ID", example = "8")
        )
        Set<Integer> types,

        @ArraySchema(
                arraySchema = @Schema(description = "Set of base combat statistics assigned to this Pokémon.")
        )
        Set<PokemonStat> stats,

        @ArraySchema(
                arraySchema = @Schema(description = "Set of forward evolution transitions available for this Pokémon.")
        )
        Set<PokemonEvolution> evolutions
) {
}
