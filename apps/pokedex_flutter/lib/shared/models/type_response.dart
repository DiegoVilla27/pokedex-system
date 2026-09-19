// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

import 'type_name.dart';

part 'type_response.g.dart';

/// Global Pokémon elemental type definition.
@JsonSerializable()
class TypeResponse {
  const TypeResponse({
    this.id,
    this.name,
  });
  
  factory TypeResponse.fromJson(Map<String, Object?> json) => _$TypeResponseFromJson(json);
  
  /// Unique numeric identifier of the elemental type.
  final int? id;

  /// Elemental type name object.
  final TypeName? name;

  Map<String, Object?> toJson() => _$TypeResponseToJson(this);
}
