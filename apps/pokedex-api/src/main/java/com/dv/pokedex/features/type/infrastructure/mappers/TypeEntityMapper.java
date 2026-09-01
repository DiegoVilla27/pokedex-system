package com.dv.pokedex.features.type.infrastructure.mappers;

import com.dv.pokedex.features.type.domain.model.Type;
import com.dv.pokedex.features.type.domain.vo.TypeName;
import com.dv.pokedex.features.type.infrastructure.entity.TypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TypeEntityMapper {
    default Type toModel(TypeEntity entity) {
        if (entity == null) {
            return null;
        }
        return Type.reconstruct(
                entity.getId(),
                TypeName.create(entity.getName()));
    }

    @Mapping(target = "name", source = "name.value")
    TypeEntity toEntity(Type model);
}
