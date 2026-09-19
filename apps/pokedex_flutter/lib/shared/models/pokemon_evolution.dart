// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'pokemon_evolution.g.dart';

/// Evolution relationship target and progression sequence.
@JsonSerializable()
class PokemonEvolution {
  const PokemonEvolution({
    this.toPokemonId,
    this.order,
  });
  
  factory PokemonEvolution.fromJson(Map<String, Object?> json) => _$PokemonEvolutionFromJson(json);
  
  /// Identifier of the target evolved Pokémon.
  final int? toPokemonId;

  /// Progression order/stage in the evolution chain.
  final int? order;

  Map<String, Object?> toJson() => _$PokemonEvolutionToJson(this);
}
