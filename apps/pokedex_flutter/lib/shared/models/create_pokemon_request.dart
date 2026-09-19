// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

import 'pokemon_color_request.dart';
import 'pokemon_stat_request.dart';

part 'create_pokemon_request.g.dart';

/// Payload required to register a new Pokémon profile.
@JsonSerializable()
class CreatePokemonRequest {
  const CreatePokemonRequest({
    required this.name,
    required this.description,
    required this.avatar,
    required this.height,
    required this.weight,
    required this.color,
    required this.typeIds,
    required this.stats,
  });
  
  factory CreatePokemonRequest.fromJson(Map<String, Object?> json) => _$CreatePokemonRequestFromJson(json);
  
  /// Name of the Pokémon.
  final String name;

  /// Detailed lore and Pokédex entry description.
  final String description;

  /// URL pointing to the Pokémon official artwork or sprite.
  final String avatar;

  /// Height of the Pokémon in meters.
  final double height;

  /// Weight of the Pokémon in kilograms.
  final double weight;

  /// Color configuration (RGB) for Pokémon theme.
  final PokemonColorRequest color;

  /// Set of elemental Type IDs (between 1 and 2 types allowed).
  final List<int> typeIds;

  /// Set of initial combat stat assignments.
  final List<PokemonStatRequest> stats;

  Map<String, Object?> toJson() => _$CreatePokemonRequestToJson(this);
}
