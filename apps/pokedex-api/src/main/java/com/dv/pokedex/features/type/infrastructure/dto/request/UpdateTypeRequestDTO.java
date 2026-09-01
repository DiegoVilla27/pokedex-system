package com.dv.pokedex.features.type.infrastructure.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(
        name = "UpdateTypeRequest",
        description = "Payload required to update an existing elemental Pokémon type name."
)
public record UpdateTypeRequestDTO(
        @Schema(
                description = "Updated unique name of the elemental type.",
                example = "Fire",
                minLength = 2,
                maxLength = 15
        )
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 15, message = "Name must be in 2 to 15 characters")
        String name
) {
}
