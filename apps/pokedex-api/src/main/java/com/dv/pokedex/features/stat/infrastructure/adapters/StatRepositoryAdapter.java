package com.dv.pokedex.features.stat.infrastructure.adapters;

import com.dv.pokedex.features.stat.application.ports.StatRepositoryPort;
import com.dv.pokedex.features.stat.domain.model.Stat;
import com.dv.pokedex.features.stat.infrastructure.entity.StatEntity;
import com.dv.pokedex.features.stat.infrastructure.mappers.StatEntityMapper;
import com.dv.pokedex.features.stat.infrastructure.repository.StatJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class StatRepositoryAdapter implements StatRepositoryPort {

    private final StatJpaRepository statJpaRepository;
    private final StatEntityMapper statEntityMapper;

    @Override
    public boolean existsByName(String name) {
        return statJpaRepository.existsByNameIgnoreCase(name);
    }

    @Override
    public Optional<Stat> getById(Integer statId) {
        return statJpaRepository.findById(statId).map(statEntityMapper::toModel);
    }

    @Override
    public List<Stat> getStats() {
        List<StatEntity> statsEntity = statJpaRepository.findAll();
        return statsEntity
                .stream()
                .map(statEntityMapper::toModel)
                .toList();
    }

    @Override
    public Stat saveStat(Stat stat) {
        StatEntity statNew = statEntityMapper.toEntity(stat);
        StatEntity statSaved = statJpaRepository.save(statNew);
        return statEntityMapper.toModel(statSaved);
    }

    @Override
    public void deleteStat(Integer statId) {
        statJpaRepository.deleteById(statId);
    }
}
