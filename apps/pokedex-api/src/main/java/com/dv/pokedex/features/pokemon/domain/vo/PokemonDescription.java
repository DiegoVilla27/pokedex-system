package com.dv.pokedex.features.pokemon.domain.vo;

import com.dv.pokedex.utils.ValidateDataUtils;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PokemonDescription {
    private final String value;

    private PokemonDescription(String value) {
        this.value = value;
    }

    public static PokemonDescription create(String value) {
        value = ValidateDataUtils.required(value, 2, 500, "Description");
        return new PokemonDescription(value);
    }
}
