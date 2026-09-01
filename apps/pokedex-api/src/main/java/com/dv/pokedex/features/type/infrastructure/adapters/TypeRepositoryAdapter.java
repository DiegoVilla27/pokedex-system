package com.dv.pokedex.features.type.infrastructure.adapters;

import com.dv.pokedex.features.type.application.ports.TypeRepositoryPort;
import com.dv.pokedex.features.type.domain.model.Type;
import com.dv.pokedex.features.type.infrastructure.entity.TypeEntity;
import com.dv.pokedex.features.type.infrastructure.mappers.TypeEntityMapper;
import com.dv.pokedex.features.type.infrastructure.repository.TypeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TypeRepositoryAdapter implements TypeRepositoryPort {
    private final TypeJpaRepository typeJpaRepository;
    private final TypeEntityMapper typeEntityMapper;

    @Override
    public boolean existsByName(String name) {
        return typeJpaRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public Optional<Type> getTypeById(Integer typeId) {
        return typeJpaRepository
                .findById(typeId).map(typeEntityMapper::toModel);
    }

    @Override
    public List<Type> getTypes() {
        return typeJpaRepository
                .findAll()
                .stream()
                .map(typeEntityMapper::toModel)
                .toList();
    }

    @Override
    public Type saveType(Type type) {
        TypeEntity typeEntity = typeEntityMapper.toEntity(type);
        TypeEntity typeSaved = typeJpaRepository.save(typeEntity);
        return typeEntityMapper.toModel(typeSaved);
    }

    @Override
    public void deleteType(Integer typeId) {
        typeJpaRepository.deleteById(typeId);
    }
}
