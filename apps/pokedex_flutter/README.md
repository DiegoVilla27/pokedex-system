# 🦋 Pokédex Mobile Client (Flutter)

[![Flutter](https://img.shields.io/badge/Flutter-3.x-02569B?style=for-the-badge&logo=flutter&logoColor=white)](https://flutter.dev)
[![Dart](https://img.shields.io/badge/Dart-3.x-0175C2?style=for-the-badge&logo=dart&logoColor=white)](https://dart.dev)
[![RPS](https://img.shields.io/badge/RPS-Scripts_Runner-blueviolet?style=for-the-badge)](https://pub.dev/packages/rps)
[![OpenAPI 3.0](https://img.shields.io/badge/OpenAPI-3.0_CDD-6BA539?style=for-the-badge&logo=openapiinitiative&logoColor=white)](https://swagger.io/specification/)
[![Riverpod](https://img.shields.io/badge/Riverpod-2.x_Codegen-0553B1?style=for-the-badge)](https://riverpod.dev)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)

High-performance, cross-platform native mobile client for the **Pokédex System** built with **Flutter** and **Dart 3**. Powered by **RPS (Run Pubspec Scripts)** for streamlined developer orchestration, **Contract-Driven Development (CDD)** via **Swagger Parser**, **Riverpod 2.0 with Codegen** for state management, and full integration with the monorepo's **Multiplatform Design Token Engine** (`@pokedex/ui`).

---

## 📑 Table of Contents

- [Overview](#-overview)
- [⚡ Complete Guide to RPS (Run Pubspec Scripts)](#-complete-guide-to-rps-run-pubspec-scripts)
  - [What is RPS?](#what-is-rps)
  - [Why use RPS in Flutter?](#why-use-rps-in-flutter)
  - [Installation & Shell Setup](#installation--shell-setup)
  - [Configuration in `pubspec.yaml`](#configuration-in-pubspecyaml)
  - [Available Project Scripts & Examples](#available-project-scripts--examples)
  - [Advanced Features (Arguments, Interactive Menu, Chaining)](#advanced-features)
  - [Troubleshooting & Common Pitfalls](#troubleshooting--common-pitfalls)
- [📑 Contract-Driven Development (CDD) with OpenAPI](#-contract-driven-development-cdd-with-openapi)
  - [How CDD Works in Flutter](#how-cdd-works-in-flutter)
  - [Swagger Parser Configuration](#swagger-parser-configuration)
  - [Generating Typed Dart Models](#generating-typed-dart-models)
  - [Consuming Models in Code](#consuming-models-in-code)
- [🏗️ Architectural Standard & Tech Stack](#️-architectural-standard--tech-stack)
- [🎨 Integration with Multiplatform Design Tokens (`@pokedex/ui`)](#-integration-with-multiplatform-design-tokens-pokedexui)
  - [Dart Tokens](#dart-tokens)
  - [Shared SVG Assets](#shared-svg-assets)
- [⚙️ Prerequisites & Environment Setup](#️-prerequisites--environment-setup)
- [🚀 Running the Application](#-running-the-application)
- [📁 Project Structure](#-project-structure)

---

## 📖 Overview

`pokedex_flutter` provides a fluid native client for the Pokédex ecosystem. It is designed to consume:

1. **Contract-Driven API Models**: Automatically parsed from Spring Boot's OpenAPI contract (`/api/v1/api-docs`) via `swagger_parser` and serialized with `json_serializable`.
2. **Multiplatform Design Tokens**: Generated directly by `@pokedex/ui` as strongly typed Dart color constants (`PokedexTokens`).
3. **Centralized SVG Icons**: Shared single-source icons located in `libs/ui/assets/icons/`.
4. **Reactive State & Networking**: Driven by Riverpod 2.0 (`riverpod_generator`), Dio HTTP client, and GoRouter.

---

## ⚡ Complete Guide to RPS (Run Pubspec Scripts)

### What is RPS?

**RPS** ([`run_pubspec_scripts`](https://pub.dev/packages/rps)) is an open-source CLI script runner for Dart and Flutter projects. It brings the familiar and productive developer experience (DX) of `npm run` or `pnpm` scripts from the Node.js/JavaScript world directly into Flutter's `pubspec.yaml`.

Instead of memorizing long terminal commands, maintaining scattered `.sh` scripts, or setting up complex `Makefile`s, **RPS allows you to define custom lifecycle, compilation, device-targeting, code-generation, and cleanup scripts in `pubspec.yaml`** and run them with the concise `rps <script>` command.

```
┌────────────────────────────────────────────────────────┐
│                   pubspec.yaml                         │
│  scripts:                                              │
│    dev:ios: flutter run -d <IOS_DEVICE_UUID>          │
│    api:types: dart run swagger_parser                  │
│    generate: dart run build_runner build ...          │
│    clean:all: flutter clean && flutter pub get ...    │
└────────────────────────────────────────────────────────┘
                           │
                 [rps <script_name>]
                           │
                           ▼
          🚀 Executes underlying command(s)
```

---

### Why use RPS in Flutter?

1. **Short & Memorable Commands**: Replaces commands like `flutter run -d DF7E47CA-2BBD-42A2-AF30-4DBB8DC271C7` with simply `rps dev:ios`.
2. **Unified Monorepo Workflow**: Developers accustomed to `package.json` scripts in Angular or Ionic can use the same mental model in Flutter.
3. **No External Files Needed**: All automation lives directly inside `pubspec.yaml`, versioned and tracked alongside project dependencies.
4. **Command Chaining & Pipelines**: Combine multiple steps (e.g., cleaning, fetching packages, and generating code) into a single deterministic command.
5. **Interactive Script Selector**: Running `rps` without arguments provides an interactive menu to choose and run any configured script.
6. **Cross-Platform Compatibility**: Works consistently across macOS, Linux, and Windows terminal environments.

---

### Installation & Shell Setup

#### 1. Activate RPS Globally

Install the tool globally using Dart's package manager:

```bash
dart pub global activate rps
```

#### 2. Configure System `$PATH`

Ensure Dart's global binary directory is added to your shell configuration (`~/.zshrc` for macOS/zsh or `~/.bashrc` for bash):

```bash
# Add this to ~/.zshrc or ~/.bashrc
export PATH="$PATH":"$HOME/.pub-cache/bin"
```

Reload your terminal session:

```bash
source ~/.zshrc
```

Verify the installation:

```bash
rps --version
# Expected output: Run Pubspec Script (rps) v0.10.x
```

---

### Configuration in `pubspec.yaml`

In `apps/pokedex_flutter/pubspec.yaml`, scripts are defined under the root `scripts:` key:

```yaml
name: pokedex_flutter
description: 'Pokédex Flutter Mobile Client'
publish_to: 'none'
version: 0.1.0+1

# ⚡ Custom RPS Scripts Definition
scripts:
  # Run on a specific iOS Simulator UUID
  dev:ios: flutter run -d DF7E47CA-2BBD-42A2-AF30-4DBB8DC271C7

  # Run on the active Android Emulator or physical device
  dev:android: flutter run -d

  # Sincronizar tipos de OpenAPI (Swagger Parser)
  api:types: dart run swagger_parser

  # Code Generation con build_runner (JSON Serializable & Riverpod)
  generate: dart run build_runner build --delete-conflicting-outputs

  # Complete clean, package re-fetch, and cache flush
  clean:all: >
    flutter clean &&
    flutter pub get &&
    dart run build_runner clean

environment:
  sdk: ^3.11.1
```

---

### Available Project Scripts & Examples

| Script | Command | Purpose & Description |
| :--- | :--- | :--- |
| **`rps dev:ios`** | `flutter run -d <UUID>` | Launches the app in debug mode on target iOS Simulator (e.g., iPhone 17 Pro). Supports Hot Reload (`r`) and Hot Restart (`R`). |
| **`rps dev:android`** | `flutter run -d` | Launches the app on connected Android emulator or physical device. |
| **`rps api:types`** | `dart run swagger_parser` | Downloads the OpenAPI spec and generates strongly typed Dart DTOs in `lib/shared/models/`. |
| **`rps generate`** | `dart run build_runner build ...` | Runs `build_runner` for JSON serialization (`.g.dart`) and Riverpod provider code generation. |
| **`rps clean:all`** | `flutter clean && flutter pub get ...` | Deletes build artifacts, cleans `.dart_tool`, flushes Xcode/Gradle cache, and re-resolves dependencies. |
| **`rps ls`** | `rps ls` | Lists all defined scripts and their underlying commands. |
| **`rps`** | _(interactive)_ | Displays an interactive CLI menu to select and execute any script. |

#### Usage Examples:

```bash
# 📱 1. Run on iOS Simulator
rps dev:ios

# 🤖 2. Run on Android Emulator
rps dev:android

# 📑 3. Generate DTOs from OpenAPI backend
rps api:types

# ⚡ 4. Generate serialization (.g.dart) & providers
rps generate

# 🧹 5. Run complete cleanup pipeline
rps clean:all

# 📋 6. List all available scripts
rps ls
```

---

### Advanced Features

#### 1. Argument Forwarding

You can pass additional flags and arguments to any RPS script by appending them after the script name:

```bash
# Run iOS in release mode
rps dev:ios --release

# Run on a specific entrypoint with verbose logging
rps dev:ios -v --flavor production
```

#### 2. Interactive Selection Menu

Simply type `rps` in the project root to open an interactive prompt:

```bash
$ rps
? Select script to run:
❯ dev:ios (flutter run -d DF7E47CA-2BBD-42A2-AF30-4DBB8DC271C7)
  dev:android (flutter run -d)
  api:types (dart run swagger_parser)
  generate (dart run build_runner build --delete-conflicting-outputs)
  clean:all (flutter clean && flutter pub get ...)
```

#### 3. Chaining Multi-Line Commands

When chaining multiple commands, use YAML's folded block scalar `>` and combine with `&&`:

```yaml
scripts:
  clean:all: >
    flutter clean &&
    flutter pub get &&
    dart run build_runner clean
```

---

### Troubleshooting & Common Pitfalls

#### 1. `Cannot use type YamlList as a command`

- **Cause**: Defining scripts as a YAML list (e.g. `[flutter clean, flutter pub get]`).
- **Fix**: RPS expects string commands. Use `&&` with the folded block scalar `>` as shown above.

#### 2. `Could not find package build_runner`

- **Cause**: Running a build runner script when `build_runner` is not declared in `dev_dependencies`.
- **Fix**: Add `build_runner: ^2.4.13` to `dev_dependencies` in `pubspec.yaml` and execute `flutter pub get`.

#### 3. Exit Code 137 on `rps dev:ios`

- **Cause**: Exit code `137` occurs when a process is killed externally (e.g., stopping the process with `Ctrl+C` / `SIGKILL` or iOS Simulator process termination).
- **Fix**: Re-run `rps dev:ios` or restart the iOS Simulator via `Simulator > Quit Simulator` and relaunch.

#### 4. `command not found: rps`

- **Cause**: `~/.pub-cache/bin` is not in your shell's `$PATH`.
- **Fix**: Add `export PATH="$PATH":"$HOME/.pub-cache/bin"` to your `~/.zshrc` and run `source ~/.zshrc`.

---

## 📑 Contract-Driven Development (CDD) with OpenAPI

This Flutter application enforces **Contract-Driven Development**. The backend (Spring Boot `pokedex-api`) is the single source of truth, exposing an OpenAPI 3.0 specification at `http://localhost:8080/api/v1/api-docs`.

```
  [Spring Boot: pokedex-api]
             │ (/api/v1/api-docs)
             ▼
    [rps api:types (swagger_parser)]
             │ Generates Dart classes
             ▼
  [lib/shared/models/*.dart]
             │ Generates JSON serialization (_$FromJson / _$ToJson)
             ▼
    [rps generate (build_runner)]
             │
             ▼
  [Strongly-typed DTOs ready in Flutter]
```

### Swagger Parser Configuration

The generation settings are managed in [`swagger_parser.yaml`](file:///Users/diegovilla/Desktop/pokedex-system/apps/pokedex_flutter/swagger_parser.yaml):

```yaml
swagger_parser:
  schema_url: http://localhost:8080/api/v1/api-docs
  output_directory: lib/shared
  language: dart
  json_serializer: json_serializable
  root_client: false
  export_file: false
  generate_client: false
  put_clients_in_folder: true
  clients_folder: clients
```

### Generating Typed Dart Models

To update models when the backend changes:

```bash
# 1. Fetch OpenAPI schema and create Dart classes in lib/shared/models/
rps api:types

# 2. Run build_runner to generate .g.dart serialization files
rps generate
```

### Consuming Models in Code

The generated models are located in `lib/shared/models/` and include complete `fromJson` / `toJson` capabilities:

```dart
import 'package:pokedex_flutter/shared/models/pokemon_response.dart';
import 'package:pokedex_flutter/shared/models/create_pokemon_request.dart';

// Deserialization from API response:
final pokemon = PokemonResponse.fromJson(jsonResponse);
print('Pokemon name: ${pokemon.name}');
print('Base stats: ${pokemon.stats?.length}');

// Serialization to JSON for POST/PUT:
final request = CreatePokemonRequest(
  name: 'Pikachu',
  description: 'Electric mouse Pokémon',
  avatar: 'https://...',
  height: 0.4,
  weight: 6.0,
  typeIds: [1],
);
final jsonPayload = request.toJson();
```

---

## 🏗️ Architectural Standard & Tech Stack

Following the enterprise guidelines defined in [`.agents/AGENTS.md`](file:///Users/diegovilla/Desktop/pokedex-system/.agents/AGENTS.md):

* **Architecture**: Modular Feature-First Architecture (`lib/features/[feature_name]/`).
* **Language**: Dart 3 with sealed classes, exhaustive pattern matching, and null-safety.
* **State Management & DI**: **Riverpod 2.0** with code generation (`@riverpod`, `flutter_riverpod`, `riverpod_generator`).
* **Networking**: **Dio** (`^5.11.1`) with custom interceptors for authentication, retry policies, and error handling.
* **Navigation**: **GoRouter** (`^17.5.0`) for declarative routing, deep linking, and type-safe navigation.
* **Serialization**: `json_annotation` + `json_serializable` generated by `build_runner`.

---

## 🎨 Integration with Multiplatform Design Tokens (`@pokedex/ui`)

This Flutter application integrates directly with the monorepo's single source of truth design tokens.

### Dart Tokens

When `@pokedex/ui` is built via `pnpm --filter @pokedex/ui build`, it outputs:

- [`libs/ui/generated/flutter/pokedex_tokens.dart`](file:///Users/diegovilla/Desktop/pokedex-system/libs/ui/generated/flutter/pokedex_tokens.dart)

Use them in any Flutter widget:

```dart
import '../../../../libs/ui/generated/flutter/pokedex_tokens.dart';

Container(
  color: PokedexTokens.bgPrimary,
  child: Text(
    'Fire Type',
    style: TextStyle(color: PokedexTokens.typeFire),
  ),
)
```

### Shared SVG Assets

Shared SVGs from `libs/ui/assets/icons/` are registered in `pubspec.yaml`:

```yaml
flutter:
  assets:
    - ../../libs/ui/assets/icons/
```

---

## ⚙️ Prerequisites & Environment Setup

- **Flutter SDK**: `>= 3.24.x` / `3.27.x`
- **Dart SDK**: `^3.11.1`
- **Xcode** _(macOS)_: 15+ for iOS simulator and physical device builds.
- **Android Studio**: Android SDK & platform tools configured.
- **RPS**: Activated via `dart pub global activate rps`.

---

## 🚀 Running the Application

### Via RPS (Recommended)

```bash
cd apps/pokedex_flutter
rps dev:ios
```

### Via Nx (Monorepo Orchestration)

```bash
# From monorepo root:
pnpm nx dev pokedex_flutter
```

---

## 📁 Project Structure

```text
apps/pokedex_flutter/
├── android/                 # Native Android host configuration
├── ios/                     # Native iOS host configuration
├── lib/
│   ├── main.dart            # Flutter application entrypoint
│   └── shared/
│       └── models/          # OpenAPI auto-generated DTOs and .g.dart serializers
│           ├── pokemon_response.dart
│           ├── pokemon_response.g.dart
│           ├── create_pokemon_request.dart
│           └── ... (40+ auto-generated models)
├── swagger_parser.yaml      # OpenAPI contract generator configuration
├── pubspec.yaml             # Dependencies, assets & RPS scripts configuration
├── analysis_options.yaml    # Linter rules & static analysis settings
├── project.json             # Nx monorepo target mappings
└── README.md                # Project documentation & RPS guide
```

---

> This digital ecosystem has been designed, structured, and developed to high-performance standards by **[Cabuweb](https://cabuweb.com)** - **Software Developer: Diego Villa**.
