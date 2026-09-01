package com.dv.pokedex.features.pokemon.domain.vo;

import com.dv.pokedex.core.exceptions.exceptions.DomainException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Schema(
        name = "PokemonStat",
        description = "Assigned base combat statistic value."
)
@ToString
@Getter
@EqualsAndHashCode(of = "statId")
public class PokemonStat {
    @Schema(description = "Identifier of the combat statistic.", example = "1")
    private final Integer statId;

    @Schema(description = "Base stat value for this Pokémon (1-255).", example = "35")
    private final Integer value;

    private PokemonStat(Integer statId, Integer value) {
        this.statId = statId;
        this.value = value;
    }

    public static PokemonStat create(Integer statId, Integer value) {
        validate(statId, value);
        return new PokemonStat(statId, value);
    }

    private static void validate(Integer statId, Integer value) {
        if (statId == null || statId <= 0) {
            throw new DomainException("Stat ID must be valid and greater than 0");
        }
        if (value == null || value <= 0 || value > 255) {
            throw new DomainException("Stat value must be between 1 and 255");
        }
    }
}
