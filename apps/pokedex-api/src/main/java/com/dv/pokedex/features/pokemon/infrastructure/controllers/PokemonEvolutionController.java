package com.dv.pokedex.features.pokemon.infrastructure.controllers;

import com.dv.pokedex.features.pokemon.application.commands.evolution.AssignPokemonEvolutionsCommand;
import com.dv.pokedex.features.pokemon.application.services.PokemonEvolutionService;
import com.dv.pokedex.features.pokemon.infrastructure.docs.AssignPokemonEvolutionsDocumentation;
import com.dv.pokedex.features.pokemon.infrastructure.dto.request.evolution.AssignPokemonEvolutionsDTO;
import com.dv.pokedex.features.pokemon.infrastructure.mappers.evolution.PokemonEvolutionDtoMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pokemon Evolutions", description = "Operations for managing evolution paths and relationships between Pokémon.")
@Validated
@RestController
@RequestMapping("/pokemons/{pokemonId}/evolutions")
@AllArgsConstructor
public class PokemonEvolutionController {

    private final PokemonEvolutionService pokemonEvolutionService;
    private final PokemonEvolutionDtoMapper pokemonEvolutionDtoMapper;

    @AssignPokemonEvolutionsDocumentation
    @PatchMapping
    public ResponseEntity<Void> assignEvolutions(
            @Parameter(description = "Unique numeric identifier of the base Pokémon", example = "25", required = true)
            @PathVariable
            Integer pokemonId,
            @Valid
            @RequestBody
            AssignPokemonEvolutionsDTO dto
    ) {
        AssignPokemonEvolutionsCommand command = pokemonEvolutionDtoMapper.assignPokemonEvolutionDtoToCommand(dto);
        pokemonEvolutionService.assignEvolutions(pokemonId, command);
        return ResponseEntity.noContent().build();
    }
}
