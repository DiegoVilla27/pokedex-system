// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

import 'stat_name.dart';

part 'stat_response.g.dart';

/// Global Pokémon base combat statistic definition.
@JsonSerializable()
class StatResponse {
  const StatResponse({
    this.id,
    this.name,
  });
  
  factory StatResponse.fromJson(Map<String, Object?> json) => _$StatResponseFromJson(json);
  
  /// Unique numeric identifier of the combat statistic.
  final int? id;

  /// Combat statistic name object.
  final StatName? name;

  Map<String, Object?> toJson() => _$StatResponseToJson(this);
}
