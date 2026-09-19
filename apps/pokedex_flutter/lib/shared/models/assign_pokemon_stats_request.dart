// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

import 'pokemon_stat_request.dart';

part 'assign_pokemon_stats_request.g.dart';

/// Set of combat stats to assign to the Pokémon (replaces previous stat values).
@JsonSerializable()
class AssignPokemonStatsRequest {
  const AssignPokemonStatsRequest({
    required this.stats,
  });
  
  factory AssignPokemonStatsRequest.fromJson(Map<String, Object?> json) => _$AssignPokemonStatsRequestFromJson(json);
  
  /// Set of stat ID and value mappings.
  final List<PokemonStatRequest> stats;

  Map<String, Object?> toJson() => _$AssignPokemonStatsRequestToJson(this);
}
