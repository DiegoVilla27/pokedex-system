package com.dv.pokedex.features.pokemon.application.commands.pokemon;

public record UpdatePokemonCommand(
        String name,
        String description,
        String avatar,
        Double height,
        Double weight,
        PokemonColorCommand color
) {
}
