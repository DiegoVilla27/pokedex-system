package com.dv.pokedex.features.stat.application.ports;

import com.dv.pokedex.features.stat.domain.model.Stat;

import java.util.List;
import java.util.Optional;

public interface StatRepositoryPort {
    boolean existsByName(String name);
    Optional<Stat> getById(Integer statId);
    List<Stat> getStats();
    Stat saveStat(Stat stat);
    void deleteStat(Integer statId);
}
