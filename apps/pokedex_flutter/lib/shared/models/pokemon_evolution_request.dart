// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'pokemon_evolution_request.g.dart';

/// Target Pokémon identifier and sequence order in the evolution line.
@JsonSerializable()
class PokemonEvolutionRequest {
  const PokemonEvolutionRequest({
    required this.toPokemonId,
    required this.order,
  });
  
  factory PokemonEvolutionRequest.fromJson(Map<String, Object?> json) => _$PokemonEvolutionRequestFromJson(json);
  
  /// Identifier of the target evolved Pokémon.
  final int toPokemonId;

  /// Progression order/stage in the evolution chain.
  final int order;

  Map<String, Object?> toJson() => _$PokemonEvolutionRequestToJson(this);
}
