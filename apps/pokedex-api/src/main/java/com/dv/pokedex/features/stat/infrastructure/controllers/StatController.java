package com.dv.pokedex.features.stat.infrastructure.controllers;

import com.dv.pokedex.features.stat.application.commands.StatCreateCommand;
import com.dv.pokedex.features.stat.application.commands.StatUpdateCommand;
import com.dv.pokedex.features.stat.application.services.StatService;
import com.dv.pokedex.features.stat.domain.model.Stat;
import com.dv.pokedex.features.stat.infrastructure.docs.CreateStatDocumentation;
import com.dv.pokedex.features.stat.infrastructure.docs.DeleteStatDocumentation;
import com.dv.pokedex.features.stat.infrastructure.docs.GetStatsDocumentation;
import com.dv.pokedex.features.stat.infrastructure.docs.UpdateStatDocumentation;
import com.dv.pokedex.features.stat.infrastructure.dto.request.StatCreateRequestDTO;
import com.dv.pokedex.features.stat.infrastructure.dto.request.StatUpdateRequestDTO;
import com.dv.pokedex.features.stat.infrastructure.mappers.StatDtoMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Stats", description = "Operations for managing global Pokémon base combat statistics.")
@Validated
@RestController
@RequestMapping("/stats")
@AllArgsConstructor
public class StatController {

    private final StatService statService;
    private final StatDtoMapper statDtoMapper;

    @GetStatsDocumentation
    @GetMapping
    public ResponseEntity<List<Stat>> getStats() {
        List<Stat> stats = statService.getStats();
        return ResponseEntity.ok(stats);
    }

    @CreateStatDocumentation
    @PostMapping
    public ResponseEntity<Stat> createStat(
            @Valid @RequestBody StatCreateRequestDTO dto
    ) {
        StatCreateCommand command = statDtoMapper.createDtoToCommand(dto);
        Stat stat = statService.createStat(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(stat);
    }

    @UpdateStatDocumentation
    @PatchMapping("/{id}")
    public ResponseEntity<Stat> updateStat(
            @Parameter(description = "Unique numeric identifier of the combat statistic", example = "1", required = true)
            @PathVariable
            @Min(1)
            int id,
            @Valid @RequestBody StatUpdateRequestDTO dto
    ) {
        StatUpdateCommand command = statDtoMapper.updateDtoToCommand(dto);
        Stat stat = statService.updateStat(id, command);
        return ResponseEntity.ok(stat);
    }

    @DeleteStatDocumentation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStat(
            @Parameter(description = "Unique numeric identifier of the combat statistic to delete", example = "1", required = true)
            @PathVariable
            @Min(1)
            int id
    ) {
        statService.deleteStat(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
