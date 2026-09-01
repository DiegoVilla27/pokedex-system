package com.dv.pokedex.features.pokemon.application.commands.type;

import java.util.Set;

public record AssignPokemonTypesCommand(
        Set<Integer> typeIds
) {
}
