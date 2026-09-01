package com.dv.pokedex.features.pokemon.domain.vo;

import com.dv.pokedex.utils.ValidateDataUtils;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PokemonAvatar {
    private final String value;

    private PokemonAvatar(String value) {
        this.value = value;
    }

    public static PokemonAvatar create(String value) {
        value = ValidateDataUtils.required(value, 2, 200, "Avatar");
        return new PokemonAvatar(value);
    }
}
