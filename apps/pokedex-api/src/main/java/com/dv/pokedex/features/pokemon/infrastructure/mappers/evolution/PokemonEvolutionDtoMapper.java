package com.dv.pokedex.features.pokemon.infrastructure.mappers.evolution;

import com.dv.pokedex.features.pokemon.application.commands.evolution.AssignPokemonEvolutionsCommand;
import com.dv.pokedex.features.pokemon.infrastructure.dto.request.evolution.AssignPokemonEvolutionsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonEvolutionDtoMapper {
    AssignPokemonEvolutionsCommand assignPokemonEvolutionDtoToCommand(AssignPokemonEvolutionsDTO dto);
}
