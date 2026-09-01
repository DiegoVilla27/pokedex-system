package com.dv.pokedex.features.pokemon.infrastructure.mappers.stat;

import com.dv.pokedex.features.pokemon.domain.vo.PokemonStat;
import com.dv.pokedex.features.pokemon.infrastructure.entity.PokemonStatEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PokemonStatEntityMapper {

    default PokemonStat toModel(PokemonStatEntity entity) {
        if (entity == null) {
            return null;
        }
        return PokemonStat.create(entity.getStat().getId(), entity.getValue());
    }

    @Mapping(target = "stat.id", source = "stat.statId")
    PokemonStatEntity toEntity(PokemonStat stat);
}
