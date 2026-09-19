// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'assign_pokemon_stats_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AssignPokemonStatsRequest _$AssignPokemonStatsRequestFromJson(
  Map<String, dynamic> json,
) => AssignPokemonStatsRequest(
  stats: (json['stats'] as List<dynamic>)
      .map((e) => PokemonStatRequest.fromJson(e as Map<String, dynamic>))
      .toList(),
);

Map<String, dynamic> _$AssignPokemonStatsRequestToJson(
  AssignPokemonStatsRequest instance,
) => <String, dynamic>{'stats': instance.stats};
