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
public class PokemonEvolutionKey implements Serializable {
    @Column(name = "from_pokemon_id")
    private Integer fromPokemonId;

    @Column(name = "to_pokemon_id")
    private Integer toPokemonId;
}
