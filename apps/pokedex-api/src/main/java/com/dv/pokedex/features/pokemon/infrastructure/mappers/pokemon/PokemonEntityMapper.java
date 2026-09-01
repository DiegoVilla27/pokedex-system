package com.dv.pokedex.features.pokemon.infrastructure.mappers.pokemon;

import com.dv.pokedex.features.pokemon.domain.model.Pokemon;
import com.dv.pokedex.features.pokemon.domain.vo.*;
import com.dv.pokedex.features.pokemon.infrastructure.entity.*;
import com.dv.pokedex.features.pokemon.infrastructure.mappers.evolution.PokemonEvolutionEntityMapper;
import com.dv.pokedex.features.pokemon.infrastructure.mappers.stat.PokemonStatEntityMapper;
import com.dv.pokedex.features.type.domain.model.Type;
import com.dv.pokedex.features.type.infrastructure.entity.TypeEntity;
import com.dv.pokedex.features.type.infrastructure.mappers.TypeEntityMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {
        TypeEntityMapper.class,
        PokemonStatEntityMapper.class
})
public abstract class PokemonEntityMapper {
    @Autowired
    protected TypeEntityMapper typeEntityMapper;
    @Autowired
    protected PokemonStatEntityMapper pokemonStatEntityMapper;
    @Autowired
    protected PokemonEvolutionEntityMapper pokemonEvolutionEntityMapper;

    public Pokemon toModel(PokemonEntity entity) {
        if (entity == null) {
            return null;
        }

        Set<Type> types = entity.getTypes() == null ? Set.of() :
                entity.getTypes().stream().map(typeEntityMapper::toModel)
                        .collect(Collectors.toSet());

        Set<PokemonStat> stats = entity.getStats() == null ? Set.of() :
                entity.getStats().stream().map((stat) -> PokemonStat.create(
                                stat.getStat().getId(),
                                stat.getValue()
                        ))
                        .collect(Collectors.toSet());

        Set<PokemonEvolution> evolutions = entity.getEvolutions() == null ? Set.of() :
                entity.getEvolutions().stream().map((evolution) -> PokemonEvolution.create(
                                evolution.getPokemonTo().getId(),
                                evolution.getEvolutionOrder()
                        ))
                        .collect(Collectors.toSet());

        return Pokemon.reconstruct(
                entity.getId(),
                PokemonName.create(entity.getName()),
                PokemonDescription.create(entity.getDescription()),
                PokemonAvatar.create(entity.getAvatar()),
                PokemonHeight.create(entity.getHeight().doubleValue()),
                PokemonWeight.create(entity.getWeight().doubleValue()),
                PokemonColor.create(entity.getColorR(), entity.getColorG(), entity.getColorB()),
                types,
                stats,
                evolutions
        );
    }

    public PokemonEntity toEntity(Pokemon pokemon) {
        if (pokemon == null) {
            return null;
        }

        PokemonEntity pokemonEntity = PokemonEntity.builder()
                .id(pokemon.getId())
                .name(pokemon.getName().getValue())
                .description(pokemon.getDescription().getValue())
                .avatar(pokemon.getAvatar().getValue())
                .height(BigDecimal.valueOf(pokemon.getHeight().getValue()))
                .weight(BigDecimal.valueOf(pokemon.getWeight().getValue()))
                .colorR(pokemon.getColor().getRed())
                .colorG(pokemon.getColor().getGreen())
                .colorB(pokemon.getColor().getBlue())
                .build();

        if (pokemon.getTypes() != null) {
            Set<TypeEntity> types = pokemon.getTypes()
                    .stream().map(typeEntityMapper::toEntity).collect(Collectors.toSet());
            pokemonEntity.setTypes(types);
        }

        if (pokemon.getStats() != null) {
            Set<PokemonStatEntity> stats = pokemon.getStats()
                    .stream().map((stat) -> {
                        PokemonStatEntity statEntity = pokemonStatEntityMapper.toEntity(stat);
                        statEntity.setPokemon(pokemonEntity);
                        statEntity.setId(
                                new PokemonStatKey(pokemonEntity.getId(), stat.getStatId())
                        );
                        return statEntity;
                    }).collect(Collectors.toSet());
            pokemonEntity.setStats(stats);
        }

        if (pokemon.getEvolutions() != null) {
            Set<PokemonEvolutionEntity> evolutions = pokemon.getEvolutions()
                    .stream().map((evo) -> {
                        PokemonEvolutionEntity evolutionEntity = pokemonEvolutionEntityMapper.toEntity(evo);
                        evolutionEntity.setPokemonFrom(pokemonEntity);
                        evolutionEntity.setId(
                                new PokemonEvolutionKey(pokemon.getId(), evo.getToPokemonId())
                        );
                        return evolutionEntity;
                    }).collect(Collectors.toSet());
            pokemonEntity.setEvolutions(evolutions);
        }

        return pokemonEntity;
    }
}
