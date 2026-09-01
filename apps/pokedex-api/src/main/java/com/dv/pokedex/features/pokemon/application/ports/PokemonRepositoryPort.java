package com.dv.pokedex.features.pokemon.application.ports;

import com.dv.pokedex.features.pokemon.domain.model.Pokemon;

import java.util.List;
import java.util.Optional;

public interface PokemonRepositoryPort {
    boolean existsPokemonByName(String name);
    List<Pokemon> getAllPokemon();
    Optional<Pokemon> getPokemonById(Integer pokemonId);
    Pokemon savePokemon(Pokemon pokemon);
    void deletePokemon(Integer pokemonId);
    long count();
}
