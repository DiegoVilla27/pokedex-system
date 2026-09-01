package com.dv.pokedex.features.pokemon.domain.vo;

import com.dv.pokedex.core.exceptions.exceptions.DomainException;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PokemonHeight {
    private final double value;

    private PokemonHeight(double value) {
        this.value = value;
    }

    public static PokemonHeight create(double value) {
        validate(value);
        return new PokemonHeight(value);
    }

    private static void validate(double value) {
        if (value <= 0) {
            throw new DomainException("Height must be greater than 0");
        }
    }
}
