// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'pokemon_stat_request.g.dart';

/// Stat identifier and value assigned to a Pokémon.
@JsonSerializable()
class PokemonStatRequest {
  const PokemonStatRequest({
    required this.statId,
    required this.value,
  });
  
  factory PokemonStatRequest.fromJson(Map<String, Object?> json) => _$PokemonStatRequestFromJson(json);
  
  /// Identifier of the base combat stat.
  final int statId;

  /// Base stat value for this Pokémon (1-255).
  final int value;

  Map<String, Object?> toJson() => _$PokemonStatRequestToJson(this);
}
