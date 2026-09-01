package com.dv.pokedex.features.pokemon.application.commands.evolution;

import java.util.Set;

public record AssignPokemonEvolutionsCommand(
        Set<PokemonEvolutionCommand> evolutions
) {
}
