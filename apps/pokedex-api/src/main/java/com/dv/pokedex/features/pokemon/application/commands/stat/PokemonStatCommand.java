package com.dv.pokedex.features.pokemon.application.commands.stat;

public record PokemonStatCommand(
        Integer statId,
        Integer value
) {
}
