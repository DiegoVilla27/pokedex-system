package com.dv.pokedex.features.pokemon.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PokemonStatKey implements Serializable {
    @Column(name = "pokemon_id")
    private Integer pokemonId;

    @Column(name = "stat_id")
    private Integer statId;
}
