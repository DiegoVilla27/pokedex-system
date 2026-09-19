// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'stat_name.g.dart';

/// Combat statistic name representation.
@JsonSerializable()
class StatName {
  const StatName({
    this.value,
  });
  
  factory StatName.fromJson(Map<String, Object?> json) => _$StatNameFromJson(json);
  
  /// Combat statistic name.
  final String? value;

  Map<String, Object?> toJson() => _$StatNameToJson(this);
}
