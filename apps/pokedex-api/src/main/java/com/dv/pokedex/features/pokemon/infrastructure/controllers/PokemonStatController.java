package com.dv.pokedex.features.pokemon.infrastructure.controllers;

import com.dv.pokedex.features.pokemon.application.commands.stat.AssignPokemonStatsCommand;
import com.dv.pokedex.features.pokemon.application.services.PokemonStatService;
import com.dv.pokedex.features.pokemon.infrastructure.docs.AssignPokemonStatsDocumentation;
import com.dv.pokedex.features.pokemon.infrastructure.dto.request.stat.AssignPokemonStatsDTO;
import com.dv.pokedex.features.pokemon.infrastructure.mappers.stat.PokemonStatDtoMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pokemon Stats", description = "Operations for assigning base stats and attribute values to Pokémon.")
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/pokemons/{pokemonId}/stats")
public class PokemonStatController {

    private final PokemonStatDtoMapper pokemonStatDtoMapper;
    private final PokemonStatService pokemonStatService;

    @AssignPokemonStatsDocumentation
    @PatchMapping
    public ResponseEntity<Void> assignPokemonStats(
            @Parameter(description = "Unique numeric identifier of the Pokémon", example = "25", required = true)
            @PathVariable
            Integer pokemonId,
            @Valid
            @RequestBody
            AssignPokemonStatsDTO dto
    ) {
        AssignPokemonStatsCommand command = pokemonStatDtoMapper.assignPokemonStatDtoToCommand(dto);
        pokemonStatService.assignPokemonStats(pokemonId, command);
        return ResponseEntity.noContent().build();
    }
}
