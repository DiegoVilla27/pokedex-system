package com.dv.pokedex.features.pokemon.domain.vo;

import com.dv.pokedex.core.exceptions.exceptions.DomainException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Schema(
        name = "PokemonEvolution",
        description = "Evolution relationship target and progression sequence."
)
@ToString
@Getter
@EqualsAndHashCode(of = "toPokemonId")
public class PokemonEvolution {
    @Schema(description = "Identifier of the target evolved Pokémon.", example = "26")
    private final Integer toPokemonId;

    @Schema(description = "Progression order/stage in the evolution chain.", example = "1")
    private final Integer order;

    private PokemonEvolution(Integer toPokemonId, Integer order) {
        this.toPokemonId = toPokemonId;
        this.order = order;
    }

    public static PokemonEvolution create(Integer toPokemonId, Integer order) {
        validate(toPokemonId, order);
        return new PokemonEvolution(toPokemonId, order);
    }

    private static void validate(Integer toPokemonId, Integer order) {
        if (toPokemonId == null || toPokemonId <= 0) {
            throw new DomainException("Target Pokemon ID must be valid and greater than 0");
        }
        if (order == null || order <= 0) {
            throw new DomainException("Evolution order must be greater than 0");
        }
    }
}
