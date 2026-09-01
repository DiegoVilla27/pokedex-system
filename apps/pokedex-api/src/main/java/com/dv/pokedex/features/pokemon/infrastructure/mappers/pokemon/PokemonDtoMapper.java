package com.dv.pokedex.features.pokemon.infrastructure.mappers.pokemon;

import com.dv.pokedex.features.pokemon.application.commands.pokemon.CreatePokemonCommand;
import com.dv.pokedex.features.pokemon.application.commands.pokemon.UpdatePokemonCommand;
import com.dv.pokedex.features.pokemon.domain.model.Pokemon;
import com.dv.pokedex.features.pokemon.infrastructure.dto.request.pokemon.CreatePokemonDTO;
import com.dv.pokedex.features.pokemon.infrastructure.dto.request.pokemon.UpdatePokemonDTO;
import com.dv.pokedex.features.pokemon.infrastructure.dto.response.PokemonResponseDto;
import com.dv.pokedex.features.type.domain.model.Type;
import org.mapstruct.Mapper;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PokemonDtoMapper {
    CreatePokemonCommand createDtoToCommand(CreatePokemonDTO dto);
    UpdatePokemonCommand updateDtoToCommand(UpdatePokemonDTO dto);

    default PokemonResponseDto modelToPokemonResponseDto(Pokemon pokemon) {
        return new PokemonResponseDto(
                pokemon.getId(),
                pokemon.getName().getValue(),
                pokemon.getDescription().getValue(),
                pokemon.getAvatar().getValue(),
                pokemon.getHeight().getValue(),
                pokemon.getWeight().getValue(),
                pokemon.getColor(),
                pokemon.getTypes().stream().map(Type::getId).collect(Collectors.toSet()),
                pokemon.getStats(),
                pokemon.getEvolutions()
        );
    }
}
