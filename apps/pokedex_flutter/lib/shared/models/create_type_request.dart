// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'create_type_request.g.dart';

/// Payload required to create a new elemental Pokémon type.
@JsonSerializable()
class CreateTypeRequest {
  const CreateTypeRequest({
    required this.name,
  });
  
  factory CreateTypeRequest.fromJson(Map<String, Object?> json) => _$CreateTypeRequestFromJson(json);
  
  /// Unique name of the elemental type.
  final String name;

  Map<String, Object?> toJson() => _$CreateTypeRequestToJson(this);
}
