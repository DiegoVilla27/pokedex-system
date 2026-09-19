// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'field_error.g.dart';

/// Details about a specific field-level validation failure.
@JsonSerializable()
class FieldError {
  const FieldError({
    this.field,
    this.value,
    this.message,
  });
  
  factory FieldError.fromJson(Map<String, Object?> json) => _$FieldErrorFromJson(json);
  
  /// Name of the invalid property/field.
  final String? field;

  /// The rejected invalid value supplied by the client.
  final dynamic value;

  /// Validation failure reason message.
  final String? message;

  Map<String, Object?> toJson() => _$FieldErrorToJson(this);
}
