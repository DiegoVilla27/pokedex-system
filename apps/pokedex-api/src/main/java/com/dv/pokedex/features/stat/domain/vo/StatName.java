package com.dv.pokedex.features.stat.domain.vo;

import com.dv.pokedex.utils.ValidateDataUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

@Schema(
        name = "StatName",
        description = "Combat statistic name representation."
)
@ToString
@Getter
public class StatName {
    @Schema(description = "Combat statistic name.", example = "speed")
    private final String value;

    private StatName(String value) {
        this.value = value;
    }

    public static StatName create(String value) {
        value = ValidateDataUtils.required(value, 2, 15, "Name");
        return new StatName(value);
    }
}
