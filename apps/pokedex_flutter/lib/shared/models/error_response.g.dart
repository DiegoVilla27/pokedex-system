// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'error_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ErrorResponse _$ErrorResponseFromJson(Map<String, dynamic> json) =>
    ErrorResponse(
      timestamp: json['timestamp'] == null
          ? null
          : DateTime.parse(json['timestamp'] as String),
      status: (json['status'] as num?)?.toInt(),
      error: json['error'] as String?,
      message: json['message'] as String?,
      errors: (json['errors'] as List<dynamic>?)
          ?.map((e) => FieldError.fromJson(e as Map<String, dynamic>))
          .toList(),
    );

Map<String, dynamic> _$ErrorResponseToJson(ErrorResponse instance) =>
    <String, dynamic>{
      'timestamp': instance.timestamp?.toIso8601String(),
      'status': instance.status,
      'error': instance.error,
      'message': instance.message,
      'errors': instance.errors,
    };
