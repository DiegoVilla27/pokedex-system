package com.dv.pokedex.features.stat.infrastructure.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(
        name = "UpdateStatRequest",
        description = "Payload required to update an existing combat statistic name."
)
public record StatUpdateRequestDTO(
        @Schema(
                description = "Updated name of the combat statistic.",
                example = "Attack",
                minLength = 2,
                maxLength = 15
        )
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 15, message = "Size must be 2 to 15 characters")
        String name
) {
}
