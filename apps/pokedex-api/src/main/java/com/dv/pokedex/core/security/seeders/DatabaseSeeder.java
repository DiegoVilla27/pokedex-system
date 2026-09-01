package com.dv.pokedex.core.security.seeders;

import com.dv.pokedex.core.security.seeders.dto.SeedPokemonEvolutionDTO;
import com.dv.pokedex.features.pokemon.application.commands.evolution.AssignPokemonEvolutionsCommand;
import com.dv.pokedex.features.pokemon.application.commands.pokemon.CreatePokemonCommand;
import com.dv.pokedex.features.pokemon.application.ports.PokemonRepositoryPort;
import com.dv.pokedex.features.pokemon.application.services.PokemonEvolutionService;
import com.dv.pokedex.features.pokemon.application.services.PokemonService;
import com.dv.pokedex.features.pokemon.infrastructure.dto.request.evolution.AssignPokemonEvolutionsDTO;
import com.dv.pokedex.features.pokemon.infrastructure.dto.request.pokemon.CreatePokemonDTO;
import com.dv.pokedex.features.pokemon.infrastructure.mappers.evolution.PokemonEvolutionDtoMapper;
import com.dv.pokedex.features.pokemon.infrastructure.mappers.pokemon.PokemonDtoMapper;
import com.dv.pokedex.features.stat.application.ports.StatRepositoryPort;
import com.dv.pokedex.features.stat.domain.model.Stat;
import com.dv.pokedex.features.stat.domain.vo.StatName;
import com.dv.pokedex.features.type.application.ports.TypeRepositoryPort;
import com.dv.pokedex.features.type.domain.model.Type;
import com.dv.pokedex.features.type.domain.vo.TypeName;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {
    private final StatRepositoryPort statRepositoryPort;
    private final TypeRepositoryPort typeRepositoryPort;
    private final PokemonRepositoryPort pokemonRepositoryPort;
    private final PokemonDtoMapper pokemonDtoMapper;
    private final PokemonEvolutionDtoMapper pokemonEvolutionDtoMapper;
    private final PokemonEvolutionService pokemonEvolutionService;
    private final PokemonService pokemonService;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String @NonNull ... args) {
//        seedTypes();
//        seedStats();
//        seedPokemon();
//        seedEvolutions();
    }

    public void seedTypes() {
        List<String> types = List.of(
                "grass", "poison", "fire", "flying", "water",
                "bug", "normal", "electric", "ground", "fairy",
                "steel", "fighting", "ghost", "psychic",
                "rock", "ice", "dragon", "dark");

        types.forEach(typeName -> {
            if (!typeRepositoryPort.existsByName(typeName)) {
                Type type = Type.create(TypeName.create(typeName));
                typeRepositoryPort.saveType(type);
            }
        });
    }

    public void seedStats() {
        List<String> stats = List.of(
                "hp", "attack", "defense",
                "special-attack", "special-defense", "speed");

        stats.forEach(statName -> {
            if (!statRepositoryPort.existsByName(statName)) {
                Stat stat = Stat.create(StatName.create(statName));
                statRepositoryPort.saveStat(stat);
            }
        });
    }

    public void seedPokemon() {
        if (pokemonRepositoryPort.count() > 0) {
            return; // Ya existen Pokémon, no hacemos nada
        }

        try (InputStream is = getClass().getResourceAsStream("/data/pokemons_151.json")) {
            if (is == null) {
                log.warn("Seeder file /data/pokemons_151.json not found in classpath.");
                return;
            }

            List<CreatePokemonDTO> dtoList = objectMapper.readValue(
                    is, new TypeReference<List<CreatePokemonDTO>>() {
                    }
            );

            dtoList.forEach(dto -> {
                CreatePokemonCommand command = pokemonDtoMapper.createDtoToCommand(dto);
                pokemonService.createPokemon(command);
            });
            log.info("Successfully seeded {} Pokémon into the database!", dtoList.size());
        } catch (Exception e) {
            log.error("Failed to seed Pokémon from JSON", e);
        }
    }

    public void seedEvolutions() {
        try (InputStream is = getClass().getResourceAsStream("/data/pokemon_evolutions.json")) {
            if (is == null) {
                log.warn("File /data/pokemon_evolutions.json not found.");
                return;
            }

            List<SeedPokemonEvolutionDTO> list = objectMapper.readValue(
                    is, new TypeReference<List<SeedPokemonEvolutionDTO>>() {
                    }
            );

            for (SeedPokemonEvolutionDTO item : list) {
                AssignPokemonEvolutionsCommand command = pokemonEvolutionDtoMapper
                        .assignPokemonEvolutionDtoToCommand(new AssignPokemonEvolutionsDTO(item.evolutions()));
                pokemonEvolutionService.assignEvolutions(item.pokemonId(), command);
            }

            log.info("Successfully seeded evolutions for {} Pokémon!", list.size());
        } catch (Exception e) {
            log.error("Failed to seed evolutions", e);
        }
    }
}
