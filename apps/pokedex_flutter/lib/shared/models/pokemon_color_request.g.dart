// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'pokemon_color_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PokemonColorRequest _$PokemonColorRequestFromJson(Map<String, dynamic> json) =>
    PokemonColorRequest(
      r: (json['r'] as num).toInt(),
      g: (json['g'] as num).toInt(),
      b: (json['b'] as num).toInt(),
    );

Map<String, dynamic> _$PokemonColorRequestToJson(
  PokemonColorRequest instance,
) => <String, dynamic>{'r': instance.r, 'g': instance.g, 'b': instance.b};
