// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

import 'pokemon_evolution_request.dart';

part 'assign_pokemon_evolutions_request.g.dart';

/// Set of evolution transitions to assign to the Pokémon.
@JsonSerializable()
class AssignPokemonEvolutionsRequest {
  const AssignPokemonEvolutionsRequest({
    required this.evolutions,
  });
  
  factory AssignPokemonEvolutionsRequest.fromJson(Map<String, Object?> json) => _$AssignPokemonEvolutionsRequestFromJson(json);
  
  /// Set of target evolutions with their order.
  final List<PokemonEvolutionRequest> evolutions;

  Map<String, Object?> toJson() => _$AssignPokemonEvolutionsRequestToJson(this);
}
