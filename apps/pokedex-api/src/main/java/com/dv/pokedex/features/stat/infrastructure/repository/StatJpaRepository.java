package com.dv.pokedex.features.stat.infrastructure.repository;

import com.dv.pokedex.features.stat.infrastructure.entity.StatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatJpaRepository extends JpaRepository<StatEntity, Integer> {

    boolean existsByNameIgnoreCase(String name);
}
