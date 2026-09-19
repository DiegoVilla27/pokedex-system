// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

import 'pokemon_color_request.dart';

part 'update_pokemon_request.g.dart';

/// Payload required to partially update Pokémon details. All fields are optional.
@JsonSerializable()
class UpdatePokemonRequest {
  const UpdatePokemonRequest({
    this.name,
    this.description,
    this.avatar,
    this.height,
    this.weight,
    this.color,
  });
  
  factory UpdatePokemonRequest.fromJson(Map<String, Object?> json) => _$UpdatePokemonRequestFromJson(json);
  
  /// Updated name of the Pokémon.
  final String? name;

  /// Updated Pokédex entry description.
  final String? description;

  /// Updated URL for the official artwork/sprite.
  final String? avatar;

  /// Updated height of the Pokémon in meters.
  final double? height;

  /// Updated weight of the Pokémon in kilograms.
  final double? weight;

  /// Updated RGB color profile.
  final PokemonColorRequest? color;

  Map<String, Object?> toJson() => _$UpdatePokemonRequestToJson(this);
}
