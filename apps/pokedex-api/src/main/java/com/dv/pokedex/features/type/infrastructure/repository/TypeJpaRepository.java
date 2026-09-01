package com.dv.pokedex.features.type.infrastructure.repository;

import com.dv.pokedex.features.type.infrastructure.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeJpaRepository extends JpaRepository<TypeEntity, Integer> {
    boolean existsByNameIgnoreCase(String name);
}
