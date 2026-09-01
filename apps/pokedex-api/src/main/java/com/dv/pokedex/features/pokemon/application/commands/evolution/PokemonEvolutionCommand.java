package com.dv.pokedex.features.pokemon.application.commands.evolution;

public record PokemonEvolutionCommand(
        Integer toPokemonId,
        Integer order
) {
}
