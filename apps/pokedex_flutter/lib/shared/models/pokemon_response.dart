// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

import 'pokemon_color.dart';
import 'pokemon_evolution.dart';
import 'pokemon_stat.dart';

part 'pokemon_response.g.dart';

/// Detailed profile and catalog information of a Pokémon.
@JsonSerializable()
class PokemonResponse {
  const PokemonResponse({
    this.id,
    this.name,
    this.description,
    this.avatar,
    this.height,
    this.weight,
    this.color,
    this.types,
    this.stats,
    this.evolutions,
  });
  
  factory PokemonResponse.fromJson(Map<String, Object?> json) => _$PokemonResponseFromJson(json);
  
  /// Unique numeric identifier of the Pokémon.
  final int? id;

  /// Name of the Pokémon.
  final String? name;

  /// Official lore and Pokédex entry description.
  final String? description;

  /// URL pointing to the official artwork or sprite.
  final String? avatar;

  /// Height of the Pokémon in meters.
  final double? height;

  /// Weight of the Pokémon in kilograms.
  final double? weight;

  /// RGB color profile used for UI theming.
  final PokemonColor? color;

  /// Set of assigned elemental type IDs.
  final List<int>? types;

  /// Set of base combat statistics assigned to this Pokémon.
  final List<PokemonStat>? stats;

  /// Set of forward evolution transitions available for this Pokémon.
  final List<PokemonEvolution>? evolutions;

  Map<String, Object?> toJson() => _$PokemonResponseToJson(this);
}
