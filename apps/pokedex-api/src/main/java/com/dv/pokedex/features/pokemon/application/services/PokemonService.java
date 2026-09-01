package com.dv.pokedex.features.pokemon.application.services;

import com.dv.pokedex.core.exceptions.exceptions.ResourceNotFoundException;
import com.dv.pokedex.features.pokemon.application.commands.pokemon.CreatePokemonCommand;
import com.dv.pokedex.features.pokemon.application.commands.pokemon.UpdatePokemonCommand;
import com.dv.pokedex.features.pokemon.application.ports.PokemonRepositoryPort;
import com.dv.pokedex.features.pokemon.domain.exceptions.PokemonAlreadyExists;
import com.dv.pokedex.features.pokemon.domain.model.Pokemon;
import com.dv.pokedex.features.pokemon.domain.vo.*;
import com.dv.pokedex.features.stat.application.services.StatService;
import com.dv.pokedex.features.stat.domain.model.Stat;
import com.dv.pokedex.features.type.application.services.TypeService;
import com.dv.pokedex.features.type.domain.model.Type;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PokemonService {
    private final PokemonRepositoryPort pokemonRepositoryPort;
    private final TypeService typeService;
    private final StatService statService;

    public Pokemon getPokemonById(Integer pokemonId) {
        return pokemonRepositoryPort
                .getPokemonById(pokemonId)
                .orElseThrow(() -> new ResourceNotFoundException("Pokemon not found"));
    }

    public List<Pokemon> getAllPokemon() {
        return pokemonRepositoryPort.getAllPokemon();
    }

    @Transactional
    public Pokemon createPokemon(CreatePokemonCommand command) {
        verifyNameExists(command.name());

        // GET TYPES
        Set<Type> types = command.typeIds()
                .stream()
                .map(typeService::getById).collect(Collectors.toSet());

        // CREATE STATS
        Set<PokemonStat> stats = command.stats()
                .stream()
                .map((stat) -> {
                    Stat statFound = statService.getById(stat.statId());
                    return PokemonStat.create(statFound.getId(), stat.value());
                })
                .collect(Collectors.toSet());

        // CREATE POKEMON
        Pokemon pokemon = Pokemon.create(
                PokemonName.create(command.name()),
                PokemonDescription.create(command.description()),
                PokemonAvatar.create(command.avatar()),
                PokemonHeight.create(command.height()),
                PokemonWeight.create(command.weight()),
                PokemonColor.create(
                        command.color().r(),
                        command.color().g(),
                        command.color().b()
                ),
                types,
                stats
        );
        return pokemonRepositoryPort.savePokemon(pokemon);
    }

    @Transactional
    public Pokemon updatePokemon(Integer pokemonId, UpdatePokemonCommand command) {
        Pokemon pokemon = getPokemonById(pokemonId);

        if (command.name() != null
                && !pokemon.getName().getValue().equalsIgnoreCase(command.name().strip())
                && pokemonRepositoryPort.existsPokemonByName(command.name().strip())) {
            throw new PokemonAlreadyExists();
        }

        PokemonName name = command.name() != null ? PokemonName.create(command.name()) : null;
        PokemonDescription description = command.description() != null ? PokemonDescription.create(command.description()) : null;
        PokemonAvatar avatar = command.avatar() != null ? PokemonAvatar.create(command.avatar()) : null;
        PokemonHeight height = command.height() != null ? PokemonHeight.create(command.height()) : null;
        PokemonWeight weight = command.weight() != null ? PokemonWeight.create(command.weight()) : null;
        PokemonColor color = command.color() != null ? PokemonColor.create(
                command.color().r(),
                command.color().g(),
                command.color().b()
        ) : null;
        pokemon.updateInformation(name, description, avatar, height, weight, color);

        return pokemonRepositoryPort.savePokemon(pokemon);
    }

    @Transactional
    public void deletePokemon(Integer pokemonId) {
        Pokemon pokemon = getPokemonById(pokemonId);
        pokemonRepositoryPort.deletePokemon(pokemon.getId());
    }

    private void verifyNameExists(String name) {
        if (pokemonRepositoryPort.existsPokemonByName(name.strip())) {
            throw new PokemonAlreadyExists();
        }
    }
}
