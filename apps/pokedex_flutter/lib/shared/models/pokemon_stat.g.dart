// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'pokemon_stat.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PokemonStat _$PokemonStatFromJson(Map<String, dynamic> json) => PokemonStat(
  statId: (json['statId'] as num?)?.toInt(),
  value: (json['value'] as num?)?.toInt(),
);

Map<String, dynamic> _$PokemonStatToJson(PokemonStat instance) =>
    <String, dynamic>{'statId': instance.statId, 'value': instance.value};
