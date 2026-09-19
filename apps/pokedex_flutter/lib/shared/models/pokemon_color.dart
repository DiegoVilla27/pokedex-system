// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'pokemon_color.g.dart';

/// RGB color profile used for UI theming.
@JsonSerializable()
class PokemonColor {
  const PokemonColor({
    this.red,
    this.green,
    this.blue,
  });
  
  factory PokemonColor.fromJson(Map<String, Object?> json) => _$PokemonColorFromJson(json);
  
  /// Red channel intensity (0-255).
  final int? red;

  /// Green channel intensity (0-255).
  final int? green;

  /// Blue channel intensity (0-255).
  final int? blue;

  Map<String, Object?> toJson() => _$PokemonColorToJson(this);
}
