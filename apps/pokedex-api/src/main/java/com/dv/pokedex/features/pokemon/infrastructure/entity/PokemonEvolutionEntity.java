package com.dv.pokedex.features.pokemon.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "pokemon_evolution")
public class PokemonEvolutionEntity {

    @EmbeddedId
    private PokemonEvolutionKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("fromPokemonId")
    @JoinColumn(name = "from_pokemon_id")
    private PokemonEntity pokemonFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("toPokemonId")
    @JoinColumn(name = "to_pokemon_id")
    private PokemonEntity pokemonTo;

    @Column(name = "evolution_order", nullable = false)
    private Integer evolutionOrder;
}
