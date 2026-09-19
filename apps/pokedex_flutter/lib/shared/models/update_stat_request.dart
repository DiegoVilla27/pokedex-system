// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'update_stat_request.g.dart';

/// Payload required to update an existing combat statistic name.
@JsonSerializable()
class UpdateStatRequest {
  const UpdateStatRequest({
    required this.name,
  });
  
  factory UpdateStatRequest.fromJson(Map<String, Object?> json) => _$UpdateStatRequestFromJson(json);
  
  /// Updated name of the combat statistic.
  final String name;

  Map<String, Object?> toJson() => _$UpdateStatRequestToJson(this);
}
