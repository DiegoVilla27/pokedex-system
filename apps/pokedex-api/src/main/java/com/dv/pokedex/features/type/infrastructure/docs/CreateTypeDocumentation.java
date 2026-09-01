package com.dv.pokedex.features.type.infrastructure.docs;

import com.dv.pokedex.core.openapi.common.BadRequestApiResponse;
import com.dv.pokedex.core.openapi.common.ConflictApiResponse;
import com.dv.pokedex.core.openapi.common.InternalServerErrorApiResponse;
import com.dv.pokedex.features.type.domain.model.Type;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.*;

/**
 * Aggregates OpenAPI metadata for the <em>Create Type</em> endpoint.
 *
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(
        summary = "Create a new elemental type",
        description = "Registers a unique elemental type (e.g. Electric, Water, Fire) in the system."
)
@ApiResponse(
        responseCode = "201",
        description = "Elemental type created successfully.",
        content =
                @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Type.class)))
@BadRequestApiResponse
@ConflictApiResponse
@InternalServerErrorApiResponse
public @interface CreateTypeDocumentation {}
