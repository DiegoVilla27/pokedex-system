// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint, unused_import, invalid_annotation_target, unnecessary_import

import 'package:json_annotation/json_annotation.dart';

part 'create_stat_request.g.dart';

/// Payload required to register a new base combat statistic.
@JsonSerializable()
class CreateStatRequest {
  const CreateStatRequest({
    required this.name,
  });
  
  factory CreateStatRequest.fromJson(Map<String, Object?> json) => _$CreateStatRequestFromJson(json);
  
  /// Name of the combat statistic.
  final String name;

  Map<String, Object?> toJson() => _$CreateStatRequestToJson(this);
}
