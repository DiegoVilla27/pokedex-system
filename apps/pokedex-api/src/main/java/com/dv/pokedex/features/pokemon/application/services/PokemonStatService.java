package com.dv.pokedex.features.pokemon.application.services;

import com.dv.pokedex.core.exceptions.exceptions.ResourceNotFoundException;
import com.dv.pokedex.features.pokemon.application.commands.stat.AssignPokemonStatsCommand;
import com.dv.pokedex.features.pokemon.application.ports.PokemonRepositoryPort;
import com.dv.pokedex.features.pokemon.domain.model.Pokemon;
import com.dv.pokedex.features.pokemon.domain.vo.PokemonStat;
import com.dv.pokedex.features.stat.application.services.StatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PokemonStatService {

    private final PokemonRepositoryPort pokemonRepositoryPort;
    private final PokemonService pokemonService;
    private final StatService statService;

    @Transactional
    public void assignPokemonStats(Integer pokemonId, AssignPokemonStatsCommand command) {
        Pokemon pokemon = pokemonService.getPokemonById(pokemonId);

        Set<PokemonStat> stats = command.stats()
                .stream()
                .map((stat) -> {
                    try {
                        statService.getById(stat.statId());
                        return PokemonStat.create(stat.statId(), stat.value());
                    } catch (ResourceNotFoundException ex) {
                        throw new ResourceNotFoundException("Stat with ID " + stat.statId() + " not found");
                    }
                })
                .collect(Collectors.toSet());
        pokemon.assignStats(stats);

        pokemonRepositoryPort.savePokemon(pokemon);
    }
}
