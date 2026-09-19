// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'update_pokemon_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

UpdatePokemonRequest _$UpdatePokemonRequestFromJson(
  Map<String, dynamic> json,
) => UpdatePokemonRequest(
  name: json['name'] as String?,
  description: json['description'] as String?,
  avatar: json['avatar'] as String?,
  height: (json['height'] as num?)?.toDouble(),
  weight: (json['weight'] as num?)?.toDouble(),
  color: json['color'] == null
      ? null
      : PokemonColorRequest.fromJson(json['color'] as Map<String, dynamic>),
);

Map<String, dynamic> _$UpdatePokemonRequestToJson(
  UpdatePokemonRequest instance,
) => <String, dynamic>{
  'name': instance.name,
  'description': instance.description,
  'avatar': instance.avatar,
  'height': instance.height,
  'weight': instance.weight,
  'color': instance.color,
};
