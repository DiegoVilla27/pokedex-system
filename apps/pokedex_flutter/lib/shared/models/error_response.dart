// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

import 'field_error.dart';

part 'error_response.g.dart';

/// Standardized error response payload following RFC 7807 problem details structure.
@JsonSerializable()
class ErrorResponse {
  const ErrorResponse({
    this.timestamp,
    this.status,
    this.error,
    this.message,
    this.errors,
  });
  
  factory ErrorResponse.fromJson(Map<String, Object?> json) => _$ErrorResponseFromJson(json);
  
  /// UTC timestamp when the error occurred.
  final DateTime? timestamp;

  /// HTTP status code.
  final int? status;

  /// HTTP status reason phrase.
  final String? error;

  /// Human-readable description of the error.
  final String? message;

  /// Collection of field-level validation errors, if applicable.
  final List<FieldError>? errors;

  Map<String, Object?> toJson() => _$ErrorResponseToJson(this);
}
