package com.dv.pokedex.features.pokemon.application.commands.pokemon;

import com.dv.pokedex.features.pokemon.application.commands.stat.PokemonStatCommand;

import java.math.BigDecimal;
import java.util.Set;

public record CreatePokemonCommand(
        String name,
        String description,
        String avatar,
        Double height,
        Double weight,
        PokemonColorCommand color,
        Set<Integer> typeIds,
        Set<PokemonStatCommand> stats
) {
}
