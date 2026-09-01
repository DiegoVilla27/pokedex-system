package com.dv.pokedex.features.pokemon.domain.vo;

import com.dv.pokedex.utils.ValidateDataUtils;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PokemonName {
    private final String value;

    private PokemonName(String value) {
        this.value = value;
    }

    public static PokemonName create(String value) {
        value = ValidateDataUtils.required(value, 2, 50, "Name");
        return new PokemonName(value);
    }
}
