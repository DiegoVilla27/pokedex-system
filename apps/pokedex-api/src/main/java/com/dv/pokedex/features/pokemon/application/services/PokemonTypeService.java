package com.dv.pokedex.features.pokemon.application.services;

import com.dv.pokedex.features.pokemon.application.commands.type.AssignPokemonTypesCommand;
import com.dv.pokedex.features.pokemon.application.ports.PokemonRepositoryPort;
import com.dv.pokedex.features.pokemon.domain.model.Pokemon;
import com.dv.pokedex.features.type.application.services.TypeService;
import com.dv.pokedex.features.type.domain.model.Type;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PokemonTypeService {

    private final TypeService typeService;
    private final PokemonService pokemonService;
    private final PokemonRepositoryPort pokemonRepositoryPort;

    @Transactional
    public void assignPokemonTypes(Integer pokemonId, AssignPokemonTypesCommand command) {
        Pokemon pokemon = pokemonService.getPokemonById(pokemonId);

        Set<Type> types = command.typeIds().stream().map(typeService::getById).collect(Collectors.toSet());
        pokemon.assignTypes(types);

        pokemonRepositoryPort.savePokemon(pokemon);
    }
}
