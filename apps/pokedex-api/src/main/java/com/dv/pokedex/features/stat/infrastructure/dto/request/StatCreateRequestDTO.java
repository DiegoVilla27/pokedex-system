package com.dv.pokedex.features.stat.infrastructure.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(
        name = "CreateStatRequest",
        description = "Payload required to register a new base combat statistic."
)
public record StatCreateRequestDTO(
        @Schema(
                description = "Name of the combat statistic.",
                example = "Speed",
                minLength = 2,
                maxLength = 15
        )
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 15, message = "Size must be 2 to 15 characters")
        String name
) {
}
