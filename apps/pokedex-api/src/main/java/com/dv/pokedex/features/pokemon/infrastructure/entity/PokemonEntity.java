package com.dv.pokedex.features.pokemon.infrastructure.entity;

import com.dv.pokedex.features.type.infrastructure.entity.TypeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "pokemon")
public class PokemonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal height;

    @Column(nullable = false)
    private BigDecimal weight;

    @Column(nullable = false)
    private String avatar;

    @Column(name = "color_r", nullable = false)
    private Integer colorR;

    @Column(name = "color_g", nullable = false)
    private Integer colorG;

    @Column(name = "color_b", nullable = false)
    private Integer colorB;

    @ManyToMany
    @JoinTable(
            name = "pokemon_type",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    @Builder.Default
    private Set<TypeEntity> types = new HashSet<>();

    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<PokemonStatEntity> stats = new HashSet<>();

    @OneToMany(mappedBy = "pokemonFrom", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<PokemonEvolutionEntity> evolutions = new HashSet<>();
}
