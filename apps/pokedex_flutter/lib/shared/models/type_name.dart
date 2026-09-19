// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'type_name.g.dart';

/// Elemental type name representation.
@JsonSerializable()
class TypeName {
  const TypeName({
    this.value,
  });
  
  factory TypeName.fromJson(Map<String, Object?> json) => _$TypeNameFromJson(json);
  
  /// Elemental type name.
  final String? value;

  Map<String, Object?> toJson() => _$TypeNameToJson(this);
}
