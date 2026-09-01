package com.dv.pokedex.features.pokemon.application.commands.pokemon;

import java.math.BigDecimal;

public record UpdatePokemonCommand(
        String name,
        String description,
        String avatar,
        Double height,
        Double weight,
        PokemonColorCommand color
) {
}
