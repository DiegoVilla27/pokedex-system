// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'pokemon_stat_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PokemonStatRequest _$PokemonStatRequestFromJson(Map<String, dynamic> json) =>
    PokemonStatRequest(
      statId: (json['statId'] as num).toInt(),
      value: (json['value'] as num).toInt(),
    );

Map<String, dynamic> _$PokemonStatRequestToJson(PokemonStatRequest instance) =>
    <String, dynamic>{'statId': instance.statId, 'value': instance.value};
