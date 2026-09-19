// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'pokemon_evolution.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

PokemonEvolution _$PokemonEvolutionFromJson(Map<String, dynamic> json) =>
    PokemonEvolution(
      toPokemonId: (json['toPokemonId'] as num?)?.toInt(),
      order: (json['order'] as num?)?.toInt(),
    );

Map<String, dynamic> _$PokemonEvolutionToJson(PokemonEvolution instance) =>
    <String, dynamic>{
      'toPokemonId': instance.toPokemonId,
      'order': instance.order,
    };
