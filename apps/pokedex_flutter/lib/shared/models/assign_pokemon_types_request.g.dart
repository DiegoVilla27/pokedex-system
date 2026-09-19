// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'assign_pokemon_types_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

AssignPokemonTypesRequest _$AssignPokemonTypesRequestFromJson(
  Map<String, dynamic> json,
) => AssignPokemonTypesRequest(
  typeIds: (json['typeIds'] as List<dynamic>)
      .map((e) => (e as num).toInt())
      .toList(),
);

Map<String, dynamic> _$AssignPokemonTypesRequestToJson(
  AssignPokemonTypesRequest instance,
) => <String, dynamic>{'typeIds': instance.typeIds};
