package com.dv.pokedex.features.pokemon.infrastructure.mappers.stat;

import com.dv.pokedex.features.pokemon.application.commands.stat.AssignPokemonStatsCommand;
import com.dv.pokedex.features.pokemon.infrastructure.dto.request.stat.AssignPokemonStatsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonStatDtoMapper {
    AssignPokemonStatsCommand assignPokemonStatDtoToCommand(AssignPokemonStatsDTO dto);
}
