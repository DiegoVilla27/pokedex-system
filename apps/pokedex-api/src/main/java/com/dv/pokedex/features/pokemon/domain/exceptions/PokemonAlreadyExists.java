package com.dv.pokedex.features.pokemon.domain.exceptions;

import com.dv.pokedex.core.exceptions.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class PokemonAlreadyExists extends ApiException {
    public PokemonAlreadyExists() {
        super(HttpStatus.CONFLICT, "A Pokemon with this name already exists.");
    }
}
