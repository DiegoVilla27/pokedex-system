// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'pokemon_stat.g.dart';

/// Assigned base combat statistic value.
@JsonSerializable()
class PokemonStat {
  const PokemonStat({
    this.statId,
    this.value,
  });
  
  factory PokemonStat.fromJson(Map<String, Object?> json) => _$PokemonStatFromJson(json);
  
  /// Identifier of the combat statistic.
  final int? statId;

  /// Base stat value for this Pokémon (1-255).
  final int? value;

  Map<String, Object?> toJson() => _$PokemonStatToJson(this);
}
