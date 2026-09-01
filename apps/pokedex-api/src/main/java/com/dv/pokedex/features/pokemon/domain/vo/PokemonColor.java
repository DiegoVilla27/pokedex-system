package com.dv.pokedex.features.pokemon.domain.vo;

import com.dv.pokedex.core.exceptions.exceptions.DomainException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

@Schema(
        name = "PokemonColor",
        description = "RGB color profile used for UI theming."
)
@ToString
@Getter
public class PokemonColor {
    @Schema(description = "Red channel intensity (0-255).", example = "246")
    private final int red;

    @Schema(description = "Green channel intensity (0-255).", example = "211")
    private final int green;

    @Schema(description = "Blue channel intensity (0-255).", example = "5")
    private final int blue;

    private PokemonColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public static PokemonColor create(int red, int green, int blue) {
        validate(red, "Red");
        validate(green, "Green");
        validate(blue, "Blue");

        return new PokemonColor(red, green, blue);
    }

    public static void validate(int value, String fieldName) {
        if (value < 0 || value > 255) {
            throw new DomainException(fieldName + " must be between 0 and 255");
        }
    }
}
