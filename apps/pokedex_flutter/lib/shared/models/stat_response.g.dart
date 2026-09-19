// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'stat_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

StatResponse _$StatResponseFromJson(Map<String, dynamic> json) => StatResponse(
  id: (json['id'] as num?)?.toInt(),
  name: json['name'] == null
      ? null
      : StatName.fromJson(json['name'] as Map<String, dynamic>),
);

Map<String, dynamic> _$StatResponseToJson(StatResponse instance) =>
    <String, dynamic>{'id': instance.id, 'name': instance.name};
