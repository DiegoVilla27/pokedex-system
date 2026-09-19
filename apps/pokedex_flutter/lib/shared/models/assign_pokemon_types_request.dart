// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'assign_pokemon_types_request.g.dart';

/// Set of type IDs to assign to the Pokémon (replaces previous type assignments).
@JsonSerializable()
class AssignPokemonTypesRequest {
  const AssignPokemonTypesRequest({
    required this.typeIds,
  });
  
  factory AssignPokemonTypesRequest.fromJson(Map<String, Object?> json) => _$AssignPokemonTypesRequestFromJson(json);
  
  /// Set of elemental Type IDs (1 to 2 allowed).
  final List<int> typeIds;

  Map<String, Object?> toJson() => _$AssignPokemonTypesRequestToJson(this);
}
