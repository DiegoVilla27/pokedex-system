package com.dv.pokedex.features.pokemon.application.services;

import com.dv.pokedex.core.exceptions.exceptions.ResourceNotFoundException;
import com.dv.pokedex.features.pokemon.application.commands.evolution.AssignPokemonEvolutionsCommand;
import com.dv.pokedex.features.pokemon.application.ports.PokemonRepositoryPort;
import com.dv.pokedex.features.pokemon.domain.model.Pokemon;
import com.dv.pokedex.features.pokemon.domain.vo.PokemonEvolution;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PokemonEvolutionService {

    private final PokemonRepositoryPort pokemonRepositoryPort;
    private final PokemonService pokemonService;

    @Transactional
    public void assignEvolutions(Integer pokemonId, AssignPokemonEvolutionsCommand command) {
        Pokemon pokemon = pokemonService.getPokemonById(pokemonId);

        Set<PokemonEvolution> evolutions = command.evolutions()
                .stream()
                .map((evo) -> {
                    try {
                        pokemonService.getPokemonById(evo.toPokemonId());
                        return PokemonEvolution.create(evo.toPokemonId(), evo.order());
                    } catch (ResourceNotFoundException ex) {
                        throw new ResourceNotFoundException("Evolution with ID " + evo.toPokemonId() + " not found");
                    }
                })
                .collect(Collectors.toSet());
        pokemon.assignEvolutions(evolutions);

        pokemonRepositoryPort.savePokemon(pokemon);
    }
}
