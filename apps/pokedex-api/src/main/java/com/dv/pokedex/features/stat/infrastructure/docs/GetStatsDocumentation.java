package com.dv.pokedex.features.stat.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.features.stat.domain.model.Stat;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Get All Stats</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Retrieve all combat stats",
        description = "Fetches the full catalog of registered Pokémon combat statistics (e.g. HP, Attack, Defense, Speed)."
)
@ApiResponse(
        responseCode = "200",
        description = "List of combat stats retrieved successfully.",
        content =
                @Content(
                        mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = Stat.class))))
@InternalServerErrorApiResponse
public @interface GetStatsDocumentation {}
