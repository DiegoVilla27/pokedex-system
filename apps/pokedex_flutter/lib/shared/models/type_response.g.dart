// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'type_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

TypeResponse _$TypeResponseFromJson(Map<String, dynamic> json) => TypeResponse(
  id: (json['id'] as num?)?.toInt(),
  name: json['name'] == null
      ? null
      : TypeName.fromJson(json['name'] as Map<String, dynamic>),
);

Map<String, dynamic> _$TypeResponseToJson(TypeResponse instance) =>
    <String, dynamic>{'id': instance.id, 'name': instance.name};
