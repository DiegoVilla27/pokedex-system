// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'pokemon_color.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PokemonColor _$PokemonColorFromJson(Map<String, dynamic> json) => PokemonColor(
  red: (json['red'] as num?)?.toInt(),
  green: (json['green'] as num?)?.toInt(),
  blue: (json['blue'] as num?)?.toInt(),
);

Map<String, dynamic> _$PokemonColorToJson(PokemonColor instance) =>
    <String, dynamic>{
      'red': instance.red,
      'green': instance.green,
      'blue': instance.blue,
    };
