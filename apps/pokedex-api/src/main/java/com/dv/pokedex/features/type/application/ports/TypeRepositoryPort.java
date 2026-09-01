package com.dv.pokedex.features.type.application.ports;

import com.dv.pokedex.features.type.domain.model.Type;

import java.util.List;
import java.util.Optional;

public interface TypeRepositoryPort {
    boolean existsByName(String name);
    Optional<Type> getTypeById(Integer typeId);
    List<Type> getTypes();
    Type saveType(Type type);
    void deleteType(Integer typeId);
}
