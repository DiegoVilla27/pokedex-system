// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'assign_pokemon_evolutions_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AssignPokemonEvolutionsRequest _$AssignPokemonEvolutionsRequestFromJson(
  Map<String, dynamic> json,
) => AssignPokemonEvolutionsRequest(
  evolutions: (json['evolutions'] as List<dynamic>)
      .map((e) => PokemonEvolutionRequest.fromJson(e as Map<String, dynamic>))
      .toList(),
);

Map<String, dynamic> _$AssignPokemonEvolutionsRequestToJson(
  AssignPokemonEvolutionsRequest instance,
) => <String, dynamic>{'evolutions': instance.evolutions};
