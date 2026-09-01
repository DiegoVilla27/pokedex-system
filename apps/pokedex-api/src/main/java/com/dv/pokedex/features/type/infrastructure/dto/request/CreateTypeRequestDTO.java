package com.dv.pokedex.features.type.infrastructure.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(
        name = "CreateTypeRequest",
        description = "Payload required to create a new elemental Pokémon type."
)
public record CreateTypeRequestDTO(
        @Schema(
                description = "Unique name of the elemental type.",
                example = "Electric",
                minLength = 2,
                maxLength = 15
        )
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 15, message = "Name must be in 2 to 15 characters")
        String name
) {
}
