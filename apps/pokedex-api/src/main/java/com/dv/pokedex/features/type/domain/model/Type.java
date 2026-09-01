package com.dv.pokedex.features.type.domain.model;

import com.dv.pokedex.features.type.domain.vo.TypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

@Schema(
        name = "TypeResponse",
        description = "Global Pokémon elemental type definition."
)
@ToString
@Getter
public class Type {
    @Schema(description = "Unique numeric identifier of the elemental type.", example = "1")
    private final Integer id;

    @Schema(description = "Elemental type name object.")
    private TypeName name;

    private Type(Integer id, TypeName name) {
        this.id = id;
        this.name = name;
    }

    public static Type create(TypeName name) {
        return new Type(null, name);
    }

    public static Type reconstruct(Integer id, TypeName name) {
        return new Type(id, name);
    }

    public void updateInformation(TypeName name) {
        if (name != null) {
            this.name = name;
        }
    }
}
