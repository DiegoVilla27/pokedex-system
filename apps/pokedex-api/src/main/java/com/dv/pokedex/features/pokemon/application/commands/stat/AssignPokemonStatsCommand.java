package com.dv.pokedex.features.pokemon.application.commands.stat;

import java.util.Set;

public record AssignPokemonStatsCommand(
        Set<PokemonStatCommand> stats
) {
}
