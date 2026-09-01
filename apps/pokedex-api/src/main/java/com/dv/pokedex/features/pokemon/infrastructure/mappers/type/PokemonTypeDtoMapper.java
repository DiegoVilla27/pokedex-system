package com.dv.pokedex.features.pokemon.infrastructure.mappers.type;

import com.dv.pokedex.features.pokemon.application.commands.type.AssignPokemonTypesCommand;
import com.dv.pokedex.features.pokemon.infrastructure.dto.request.type.AssignPokemonTypesDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonTypeDtoMapper {
    AssignPokemonTypesCommand assignPokemonTypesDtoToCommand(AssignPokemonTypesDTO dto);
}
