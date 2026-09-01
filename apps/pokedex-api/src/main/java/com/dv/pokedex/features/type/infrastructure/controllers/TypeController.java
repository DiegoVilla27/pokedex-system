package com.dv.pokedex.features.type.infrastructure.controllers;

import com.dv.pokedex.features.type.application.commands.CreateTypeCommand;
import com.dv.pokedex.features.type.application.commands.UpdateTypeCommand;
import com.dv.pokedex.features.type.application.services.TypeService;
import com.dv.pokedex.features.type.domain.model.Type;
import com.dv.pokedex.features.type.infrastructure.docs.CreateTypeDocumentation;
import com.dv.pokedex.features.type.infrastructure.docs.DeleteTypeDocumentation;
import com.dv.pokedex.features.type.infrastructure.docs.GetTypesDocumentation;
import com.dv.pokedex.features.type.infrastructure.docs.UpdateTypeDocumentation;
import com.dv.pokedex.features.type.infrastructure.dto.request.CreateTypeRequestDTO;
import com.dv.pokedex.features.type.infrastructure.dto.request.UpdateTypeRequestDTO;
import com.dv.pokedex.features.type.infrastructure.mappers.TypeDtoMapper;
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

@Tag(name = "Types", description = "Operations for managing global Pokémon elemental types.")
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/types")
public class TypeController {
    private final TypeService typeService;
    private final TypeDtoMapper typeDtoMapper;

    @GetTypesDocumentation
    @GetMapping
    public ResponseEntity<List<Type>> getTypes() {
        return ResponseEntity.ok(typeService.getTypes());
    }

    @CreateTypeDocumentation
    @PostMapping
    public ResponseEntity<Type> createType(
            @Valid @RequestBody CreateTypeRequestDTO dto
    ) {
        CreateTypeCommand command = typeDtoMapper.createDtoToCommand(dto);
        Type type = typeService.createType(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(type);
    }

    @UpdateTypeDocumentation
    @PatchMapping("/{id}")
    public ResponseEntity<Type> updateType(
            @Parameter(description = "Unique numeric identifier of the elemental type", example = "13", required = true)
            @PathVariable @Min(1) Integer id,
            @Valid @RequestBody UpdateTypeRequestDTO dto
    ) {
        UpdateTypeCommand command = typeDtoMapper.updateDtoToCommand(dto);
        Type type = typeService.updateType(id, command);
        return ResponseEntity.ok(type);
    }

    @DeleteTypeDocumentation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(
            @Parameter(description = "Unique numeric identifier of the elemental type to delete", example = "13", required = true)
            @PathVariable @Min(1) Integer id
    ) {
        typeService.deleteType(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
