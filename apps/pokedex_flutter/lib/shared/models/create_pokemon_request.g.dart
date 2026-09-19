// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'create_pokemon_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CreatePokemonRequest _$CreatePokemonRequestFromJson(
  Map<String, dynamic> json,
) => CreatePokemonRequest(
  name: json['name'] as String,
  description: json['description'] as String,
  avatar: json['avatar'] as String,
  height: (json['height'] as num).toDouble(),
  weight: (json['weight'] as num).toDouble(),
  color: PokemonColorRequest.fromJson(json['color'] as Map<String, dynamic>),
  typeIds: (json['typeIds'] as List<dynamic>)
      .map((e) => (e as num).toInt())
      .toList(),
  stats: (json['stats'] as List<dynamic>)
      .map((e) => PokemonStatRequest.fromJson(e as Map<String, dynamic>))
      .toList(),
);

Map<String, dynamic> _$CreatePokemonRequestToJson(
  CreatePokemonRequest instance,
) => <String, dynamic>{
  'name': instance.name,
  'description': instance.description,
  'avatar': instance.avatar,
  'height': instance.height,
  'weight': instance.weight,
  'color': instance.color,
  'typeIds': instance.typeIds,
  'stats': instance.stats,
};
