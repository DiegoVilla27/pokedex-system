package com.dv.pokedex.core.security.seeders.dto;

import com.dv.pokedex.features.pokemon.infrastructure.dto.request.evolution.PokemonEvolutionDTO;

import java.util.Set;

public record SeedPokemonEvolutionDTO(
        Integer pokemonId,
        Set<PokemonEvolutionDTO> evolutions
) {
}