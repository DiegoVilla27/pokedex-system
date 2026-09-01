package com.dv.pokedex.features.stat.domain.model;

import com.dv.pokedex.features.stat.domain.vo.StatName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

@Schema(
        name = "StatResponse",
        description = "Global Pokémon base combat statistic definition."
)
@ToString
@Getter
public class Stat {
    @Schema(description = "Unique numeric identifier of the combat statistic.", example = "1")
    private final Integer id;

    @Schema(description = "Combat statistic name object.")
    private StatName name;

    private Stat(Integer id, StatName name) {
        this.id = id;
        this.name = name;
    }

    public static Stat create(StatName name) {
        return new Stat(null, name);
    }

    public static Stat reconstruct(Integer id, StatName name) {
        return new Stat(id, name);
    }

    public void updateInformation(StatName name) {
        if (name != null) {
            this.name = name;
        }
    }
}
