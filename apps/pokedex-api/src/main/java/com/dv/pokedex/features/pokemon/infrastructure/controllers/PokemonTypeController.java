package com.dv.pokedex.features.pokemon.infrastructure.controllers;

import com.dv.pokedex.features.pokemon.application.commands.type.AssignPokemonTypesCommand;
import com.dv.pokedex.features.pokemon.application.services.PokemonTypeService;
import com.dv.pokedex.features.pokemon.infrastructure.docs.AssignPokemonTypesDocumentation;
import com.dv.pokedex.features.pokemon.infrastructure.dto.request.type.AssignPokemonTypesDTO;
import com.dv.pokedex.features.pokemon.infrastructure.mappers.type.PokemonTypeDtoMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pokemon Types", description = "Operations for assigning elemental types to Pokémon.")
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/pokemons/{pokemonId}/types")
public class PokemonTypeController {

    private final PokemonTypeService pokemonTypeService;
    private final PokemonTypeDtoMapper pokemonTypeDtoMapper;

    @AssignPokemonTypesDocumentation
    @PatchMapping
    public ResponseEntity<Void> assignPokemonTypes(
            @Parameter(description = "Unique numeric identifier of the Pokémon", example = "25", required = true)
            @PathVariable
            Integer pokemonId,
            @Valid
            @RequestBody
            AssignPokemonTypesDTO dto
    ) {
        AssignPokemonTypesCommand command = pokemonTypeDtoMapper.assignPokemonTypesDtoToCommand(dto);
        pokemonTypeService.assignPokemonTypes(pokemonId, command);
        return ResponseEntity.noContent().build();
    }
}
