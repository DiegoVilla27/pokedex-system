package com.dv.pokedex.features.pokemon.domain.vo;

import com.dv.pokedex.core.exceptions.exceptions.DomainException;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PokemonWeight {
    private final double value;

    private PokemonWeight(double value) {
        this.value = value;
    }

    public static PokemonWeight create(double value) {
        validate(value);
        return new PokemonWeight(value);
    }

    private static void validate(double value) {
        if (value <= 0) {
            throw new DomainException("Weight must be greater than 0");
        }
    }
}
