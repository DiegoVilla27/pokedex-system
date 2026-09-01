package com.dv.pokedex.features.pokemon.infrastructure.repository;

import com.dv.pokedex.features.pokemon.infrastructure.entity.PokemonEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonJpaRepository extends JpaRepository<PokemonEntity, Integer> {
    boolean existsByNameIgnoreCase(String name);

    @EntityGraph(attributePaths = {"types", "stats", "evolutions"})
    List<PokemonEntity> findAll();
}
