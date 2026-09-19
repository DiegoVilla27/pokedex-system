// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'pokemon_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PokemonResponse _$PokemonResponseFromJson(Map<String, dynamic> json) =>
    PokemonResponse(
      id: (json['id'] as num?)?.toInt(),
      name: json['name'] as String?,
      description: json['description'] as String?,
      avatar: json['avatar'] as String?,
      height: (json['height'] as num?)?.toDouble(),
      weight: (json['weight'] as num?)?.toDouble(),
      color: json['color'] == null
          ? null
          : PokemonColor.fromJson(json['color'] as Map<String, dynamic>),
      types: (json['types'] as List<dynamic>?)
          ?.map((e) => (e as num).toInt())
          .toList(),
      stats: (json['stats'] as List<dynamic>?)
          ?.map((e) => PokemonStat.fromJson(e as Map<String, dynamic>))
          .toList(),
      evolutions: (json['evolutions'] as List<dynamic>?)
          ?.map((e) => PokemonEvolution.fromJson(e as Map<String, dynamic>))
          .toList(),
    );

Map<String, dynamic> _$PokemonResponseToJson(PokemonResponse instance) =>
    <String, dynamic>{
      'id': instance.id,
      'name': instance.name,
      'description': instance.description,
      'avatar': instance.avatar,
      'height': instance.height,
      'weight': instance.weight,
      'color': instance.color,
      'types': instance.types,
      'stats': instance.stats,
      'evolutions': instance.evolutions,
    };
