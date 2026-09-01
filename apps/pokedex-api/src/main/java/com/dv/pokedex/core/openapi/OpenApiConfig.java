package com.dv.pokedex.core.openapi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configures the application's OpenAPI (Swagger) specification for Pokédex API.
 *
 * <p>This configuration registers the {@link OpenAPI} bean consumed by Springdoc to automatically
 * generate the API documentation exposed by the application.
 *
 * @author Diego Villa
 * @since 1.0.0
 */
@Configuration
public class OpenApiConfig {

    @Value("${application.version:1.0.0}")
    private String version;

    @Value("${application.name:Pokedex API}")
    private String name;

    /**
     * Creates the application's OpenAPI definition.
     *
     * <p>Builds the root {@link OpenAPI} object containing metadata, server definitions,
     * security schemes, descriptive tags, and documentation settings displayed by Swagger UI.
     *
     * @return a fully configured {@link OpenAPI} instance.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title(name)
                                .version(version)
                                .summary("RESTful API for Pokémon, Types, Stats and Evolutions management.")
                                .description(
                                        """
                                                # Pokédex REST API
                                                
                                                Welcome to the **Pokédex API** documentation. This service provides a complete,
                                                robust and reactive RESTful API for managing Pokémon catalog data, elemental types,
                                                base combat statistics, and complex multi-tier evolution chains.
                                                
                                                ### Key Features
                                                - **Pokémon Management:** Complete CRUD operations for Pokémon entities including physical dimensions, RGB display colors, and avatars.
                                                - **Elemental Types:** Cataloging and assigning elemental types (Fire, Water, Grass, etc.) with strict constraints.
                                                - **Combat Stats:** Granular base stat definitions (HP, Attack, Defense, Speed, etc.) and assignments to individual Pokémon.
                                                - **Evolution Chains:** Sequential evolution tracking with ordered progression requirements.
                                                
                                                ### Error Handling
                                                All endpoints follow a standardized, predictable error response format adhering to RFC 7807 principles, returning detailed field-level validation breakdowns where applicable.
                                                """)
                                .termsOfService("https://example.com/terms")
                                .contact(
                                        new Contact()
                                                .name("Diego Villa")
                                                .email("cabuweb.info@gmail.com")
                                                .url("https://github.com/DiegoVilla27"))
                                .license(
                                        new License()
                                                .name("Apache License 2.0")
                                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .servers(
                        List.of(
                                new Server()
                                        .url("http://localhost:8080/api/v1")
                                        .description("Local Development Environment")))
                .tags(
                        List.of(
                                new Tag().name("Pokemons").description("Operations for managing Pokémon profiles, creation, updates, and catalog queries."),
                                new Tag().name("Pokemon Types").description("Operations for assigning elemental types to Pokémon."),
                                new Tag().name("Pokemon Stats").description("Operations for assigning base stats and attribute values to Pokémon."),
                                new Tag().name("Pokemon Evolutions").description("Operations for managing evolution paths and relationships between Pokémon."),
                                new Tag().name("Types").description("Operations for managing global Pokémon elemental types."),
                                new Tag().name("Stats").description("Operations for managing global Pokémon base combat statistics.")
                        ))
                .externalDocs(
                        new ExternalDocumentation()
                                .description("Pokédex Project GitHub Repository")
                                .url("https://github.com/DiegoVilla27/pokedex"))
                .components(
                        new Components()
                                .addSecuritySchemes(
                                        "Bearer Authentication",
                                        new SecurityScheme()
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                                .description(
                                                        """
                                                                JSON Web Token (JWT) Bearer authentication.
                                                                Enter the token directly. The 'Bearer ' prefix is added automatically.
                                                                """)))
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"));
    }
}
