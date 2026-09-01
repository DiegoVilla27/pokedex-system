package com.dv.pokedex.features.pokemon.infrastructure.adapters;

import com.dv.pokedex.features.pokemon.application.ports.PokemonRepositoryPort;
import com.dv.pokedex.features.pokemon.domain.model.Pokemon;
import com.dv.pokedex.features.pokemon.infrastructure.entity.PokemonEntity;
import com.dv.pokedex.features.pokemon.infrastructure.mappers.pokemon.PokemonEntityMapper;
import com.dv.pokedex.features.pokemon.infrastructure.repository.PokemonJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class PokemonRepositoryAdapter implements PokemonRepositoryPort {

    private final PokemonJpaRepository pokemonJpaRepository;
    private final PokemonEntityMapper pokemonEntityMapper;

    @Override
    public boolean existsPokemonByName(String name) {
        return pokemonJpaRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonJpaRepository.findAll()
                .stream()
                .map(pokemonEntityMapper::toModel)
                .toList();
    }

    @Override
    public Optional<Pokemon> getPokemonById(Integer pokemonId) {
        return pokemonJpaRepository.findById(pokemonId).map(pokemonEntityMapper::toModel);
    }

    @Override
    public Pokemon savePokemon(Pokemon pokemon) {
        PokemonEntity entity = pokemonEntityMapper.toEntity(pokemon);
        return pokemonEntityMapper.toModel(pokemonJpaRepository.saveAndFlush(entity));
    }

    @Override
    public void deletePokemon(Integer pokemonId) {
        pokemonJpaRepository.deleteById(pokemonId);
        pokemonJpaRepository.flush();
    }

    @Override
    public long count() {
        return pokemonJpaRepository.count();
    }
}
