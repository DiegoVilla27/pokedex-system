package com.dv.pokedex.features.stat.application.services;

import com.dv.pokedex.core.exceptions.exceptions.ResourceNotFoundException;
import com.dv.pokedex.features.stat.application.commands.StatCreateCommand;
import com.dv.pokedex.features.stat.application.commands.StatUpdateCommand;
import com.dv.pokedex.features.stat.application.ports.StatRepositoryPort;
import com.dv.pokedex.features.stat.domain.exceptions.StatAlreadyExists;
import com.dv.pokedex.features.stat.domain.model.Stat;
import com.dv.pokedex.features.stat.domain.vo.StatName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatService {

    private final StatRepositoryPort statRepositoryPort;

    public List<Stat> getStats() {
        return statRepositoryPort.getStats();
    }

    public Stat getById(Integer statId) {
        return statRepositoryPort
                .getById(statId)
                .orElseThrow(() -> new ResourceNotFoundException("Stat not found"));
    }

    public Stat createStat(StatCreateCommand command) {
        verifyNameIsAvailable(command.name());
        return statRepositoryPort.saveStat(Stat.create(StatName.create(command.name())));
    }

    public Stat updateStat(Integer statId, StatUpdateCommand command) {
        Stat stat = getById(statId);
        if (!stat.getName().getValue().equalsIgnoreCase(command.name().strip())
                && statRepositoryPort.existsByName(command.name().strip())) {
            throw new StatAlreadyExists();
        }

        stat.updateInformation(StatName.create(command.name()));
        return statRepositoryPort.saveStat(stat);
    }

    public void deleteStat(Integer statId) {
        Stat stat = getById(statId);
        statRepositoryPort.deleteStat(stat.getId());
    }

    private void verifyNameIsAvailable(String name) {
        if (statRepositoryPort.existsByName(name.strip())) {
            throw new StatAlreadyExists();
        }
    }
}
