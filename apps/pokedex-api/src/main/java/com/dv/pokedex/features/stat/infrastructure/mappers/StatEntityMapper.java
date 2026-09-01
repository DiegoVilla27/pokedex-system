package com.dv.pokedex.features.stat.infrastructure.mappers;

import com.dv.pokedex.features.stat.domain.model.Stat;
import com.dv.pokedex.features.stat.domain.vo.StatName;
import com.dv.pokedex.features.stat.infrastructure.entity.StatEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StatEntityMapper {
    default Stat toModel(StatEntity entity) {
        if (entity == null) {
            return null;
        }
        return Stat.reconstruct(entity.getId(), StatName.create(entity.getName()));
    }

    @Mapping(target = "name", source = "name.value")
    StatEntity toEntity(Stat stat);
}
