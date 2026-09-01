package com.dv.pokedex.features.pokemon.infrastructure.mappers.evolution;

import com.dv.pokedex.features.pokemon.domain.vo.PokemonEvolution;
import com.dv.pokedex.features.pokemon.domain.vo.PokemonStat;
import com.dv.pokedex.features.pokemon.infrastructure.entity.PokemonEvolutionEntity;
import com.dv.pokedex.features.pokemon.infrastructure.entity.PokemonEvolutionKey;
import com.dv.pokedex.features.pokemon.infrastructure.entity.PokemonStatEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PokemonEvolutionEntityMapper {

    default PokemonEvolution toModel(PokemonEvolutionEntity entity) {
        if (entity == null) {
            return null;
        }
        return PokemonEvolution.create(entity.getPokemonTo().getId(), entity.getEvolutionOrder());
    }

    @Mapping(target = "evolutionOrder", source = "order")
    @Mapping(target = "pokemonTo.id", source = "toPokemonId")
    PokemonEvolutionEntity toEntity(PokemonEvolution evolution);
}
