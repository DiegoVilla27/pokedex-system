package com.dv.pokedex.features.pokemon.infrastructure.entity;

import com.dv.pokedex.features.stat.infrastructure.entity.StatEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "pokemon_stat")
public class PokemonStatEntity {

    @EmbeddedId
    private PokemonStatKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pokemonId")
    @JoinColumn(name = "pokemon_id")
    private PokemonEntity pokemon;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("statId")
    @JoinColumn(name = "stat_id")
    private StatEntity stat;

    @Column(nullable = false)
    private Integer value;
}
