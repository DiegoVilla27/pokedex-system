// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'pokemon_color_request.g.dart';

/// RGB color definition for the Pokémon UI card theme.
@JsonSerializable()
class PokemonColorRequest {
  const PokemonColorRequest({
    required this.r,
    required this.g,
    required this.b,
  });
  
  factory PokemonColorRequest.fromJson(Map<String, Object?> json) => _$PokemonColorRequestFromJson(json);
  
  /// Red channel intensity (0-255).
  final int r;

  /// Green channel intensity (0-255).
  final int g;

  /// Blue channel intensity (0-255).
  final int b;

  Map<String, Object?> toJson() => _$PokemonColorRequestToJson(this);
}
