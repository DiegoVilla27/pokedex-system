package com.dv.pokedex.features.pokemon.infrastructure.controllers;

import com.dv.pokedex.features.pokemon.application.commands.pokemon.CreatePokemonCommand;
import com.dv.pokedex.features.pokemon.application.commands.pokemon.UpdatePokemonCommand;
import com.dv.pokedex.features.pokemon.application.services.PokemonService;
import com.dv.pokedex.features.pokemon.domain.model.Pokemon;
import com.dv.pokedex.features.pokemon.infrastructure.docs.*;
import com.dv.pokedex.features.pokemon.infrastructure.dto.request.pokemon.CreatePokemonDTO;
import com.dv.pokedex.features.pokemon.infrastructure.dto.request.pokemon.UpdatePokemonDTO;
import com.dv.pokedex.features.pokemon.infrastructure.dto.response.PokemonResponseDto;
import com.dv.pokedex.features.pokemon.infrastructure.mappers.pokemon.PokemonDtoMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pokemons", description = "Operations for managing Pokémon profiles, creation, updates, and catalog queries.")
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;
    private final PokemonDtoMapper pokemonDtoMapper;

    @GetAllPokemonsDocumentation
    @GetMapping
    public ResponseEntity<List<PokemonResponseDto>> getAllPokemon() {
        return ResponseEntity.ok(
                pokemonService.getAllPokemon()
                        .stream()
                        .map(pokemonDtoMapper::modelToPokemonResponseDto)
                        .toList()
        );
    }

    @GetPokemonByIdDocumentation
    @GetMapping("/{id}")
    public ResponseEntity<PokemonResponseDto> getById(
            @Parameter(description = "Unique numeric identifier of the Pokémon", example = "25", required = true)
            @PathVariable
            Integer id
    ) {
        Pokemon pokemon = pokemonService.getPokemonById(id);
        return ResponseEntity.ok(pokemonDtoMapper.modelToPokemonResponseDto(pokemon));
    }

    @CreatePokemonDocumentation
    @PostMapping
    public ResponseEntity<PokemonResponseDto> createPokemon(
            @Valid
            @RequestBody
            CreatePokemonDTO dto
    ) {
        CreatePokemonCommand command = pokemonDtoMapper.createDtoToCommand(dto);
        Pokemon pokemon = pokemonService.createPokemon(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                pokemonDtoMapper.modelToPokemonResponseDto(pokemon)
        );
    }

    @UpdatePokemonDocumentation
    @PatchMapping("/{id}")
    public ResponseEntity<PokemonResponseDto> updatePokemon(
            @Parameter(description = "Unique numeric identifier of the Pokémon to update", example = "25", required = true)
            @PathVariable
            Integer id,
            @Valid
            @RequestBody
            UpdatePokemonDTO dto
    ) {
        UpdatePokemonCommand command = pokemonDtoMapper.updateDtoToCommand(dto);
        return ResponseEntity.ok(
                pokemonDtoMapper.modelToPokemonResponseDto(pokemonService.updatePokemon(id, command))
        );
    }

    @DeletePokemonDocumentation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(
            @Parameter(description = "Unique numeric identifier of the Pokémon to delete", example = "25", required = true)
            @PathVariable
            Integer id
    ) {
        pokemonService.deletePokemon(id);
        return ResponseEntity.noContent().build();
    }
}
