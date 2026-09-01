package com.dv.pokedex.features.stat.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.BadRequestApiResponse;
import com.dv.pokedex.core.openapi.common.ConflictApiResponse;
import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.features.stat.domain.model.Stat;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Create Stat</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Create a new combat stat",
        description = "Registers a unique base combat statistic (e.g. Special Attack, Defense) in the Pokédex system."
)
@ApiResponse(
        responseCode = "201",
        description = "Combat stat created successfully.",
        content =
                @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Stat.class)))
@BadRequestApiResponse
@ConflictApiResponse
@InternalServerErrorApiResponse
public @interface CreateStatDocumentation {}
