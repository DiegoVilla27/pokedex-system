package com.dv.pokedex.features.pokemon.domain.model;

import com.dv.pokedex.core.exceptions.exceptions.DomainException;
import com.dv.pokedex.features.pokemon.domain.vo.*;
import com.dv.pokedex.features.type.domain.model.Type;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
public class Pokemon {
    private final Integer id;
    private PokemonName name;
    private PokemonDescription description;
    private PokemonAvatar avatar;
    private PokemonHeight height;
    private PokemonWeight weight;
    private PokemonColor color;
    private Set<Type> types;
    private Set<PokemonStat> stats;
    private Set<PokemonEvolution> evolutions;

    private Pokemon(
            Integer id,
            PokemonName name,
            PokemonDescription description,
            PokemonAvatar avatar,
            PokemonHeight height,
            PokemonWeight weight,
            PokemonColor color,
            Set<Type> types,
            Set<PokemonStat> stats,
            Set<PokemonEvolution> evolutions
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.avatar = avatar;
        this.height = height;
        this.weight = weight;
        this.color = color;
        this.types = types != null ? new HashSet<>(types) : new HashSet<>();
        this.stats = stats != null ? new HashSet<>(stats) : new HashSet<>();
        this.evolutions = evolutions != null ? new HashSet<>(evolutions) : new HashSet<>();
    }

    public static Pokemon create(
            PokemonName name,
            PokemonDescription description,
            PokemonAvatar avatar,
            PokemonHeight height,
            PokemonWeight weight,
            PokemonColor color,
            Set<Type> types,
            Set<PokemonStat> stats
    ) {
        Pokemon pokemon = new Pokemon(
                null,
                name,
                description,
                avatar,
                height,
                weight,
                color,
                null,
                null,
                null
        );
        pokemon.assignTypes(types);
        pokemon.assignStats(stats);

        return pokemon;
    }

    public static Pokemon reconstruct(
            Integer id,
            PokemonName name,
            PokemonDescription description,
            PokemonAvatar avatar,
            PokemonHeight height,
            PokemonWeight weight,
            PokemonColor color,
            Set<Type> types,
            Set<PokemonStat> stats,
            Set<PokemonEvolution> evolutions
    ) {
        return new Pokemon(
                id,
                name,
                description,
                avatar,
                height,
                weight,
                color,
                types,
                stats,
                evolutions
        );
    }

    public void updateInformation(
            PokemonName name,
            PokemonDescription description,
            PokemonAvatar avatar,
            PokemonHeight height,
            PokemonWeight weight,
            PokemonColor color
    ) {
        if (name != null) this.name = name;
        if (description != null) this.description = description;
        if (avatar != null) this.avatar = avatar;
        if (height != null) this.height = height;
        if (weight != null) this.weight = weight;
        if (color != null) this.color = color;
    }

    public void assignTypes(Set<Type> types) {
        if (types == null || types.isEmpty()) {
            throw new DomainException("Pokemon must have at least 1 type");
        }
        if (types.size() > 2) {
            throw new DomainException("Pokemon cannot have more than 2 types");
        }
        this.types = new HashSet<>(types);
    }

    public void assignStats(Set<PokemonStat> stats) {
        this.stats = (stats != null) ? new HashSet<>(stats) : new HashSet<>();
    }

    public void assignEvolutions(Set<PokemonEvolution> evolutions) {
        this.evolutions = (evolutions != null) ? new HashSet<>(evolutions) : new HashSet<>();
    }
}
