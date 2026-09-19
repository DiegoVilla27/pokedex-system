import { apiConfig } from "./lintstaged/api.js";
import { backofficeConfig } from "./lintstaged/backoffice.js";
import { ionicConfig } from "./lintstaged/ionic.js";
import { flutterConfig } from "./lintstaged/flutter.js";

export default {
  ...apiConfig,
  ...backofficeConfig,
  ...ionicConfig,
  ...flutterConfig
};