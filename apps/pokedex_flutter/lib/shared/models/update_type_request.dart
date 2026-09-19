// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'update_type_request.g.dart';

/// Payload required to update an existing elemental Pokémon type name.
@JsonSerializable()
class UpdateTypeRequest {
  const UpdateTypeRequest({
    required this.name,
  });
  
  factory UpdateTypeRequest.fromJson(Map<String, Object?> json) => _$UpdateTypeRequestFromJson(json);
  
  /// Updated unique name of the elemental type.
  final String name;

  Map<String, Object?> toJson() => _$UpdateTypeRequestToJson(this);
}
