package com.dv.pokedex.features.type.domain.vo;

import com.dv.pokedex.utils.ValidateDataUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

@Schema(
        name = "TypeName",
        description = "Elemental type name representation."
)
@ToString
@Getter
public class TypeName {
    @Schema(description = "Elemental type name.", example = "grass")
    private final String value;

    private TypeName(String value) {
        this.value = value;
    }

    public static TypeName create(String value) {
        value = ValidateDataUtils.required(value, 2, 15, "Name");
        return new TypeName(value);
    }
}
