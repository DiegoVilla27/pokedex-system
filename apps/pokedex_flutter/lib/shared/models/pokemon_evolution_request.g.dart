// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'pokemon_evolution_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PokemonEvolutionRequest _$PokemonEvolutionRequestFromJson(
  Map<String, dynamic> json,
) => PokemonEvolutionRequest(
  toPokemonId: (json['toPokemonId'] as num).toInt(),
  order: (json['order'] as num).toInt(),
);

Map<String, dynamic> _$PokemonEvolutionRequestToJson(
  PokemonEvolutionRequest instance,
) => <String, dynamic>{
  'toPokemonId': instance.toPokemonId,
  'order': instance.order,
};
