# 🦋 Pokédex Mobile Client (Flutter)

[![Flutter](https://img.shields.io/badge/Flutter-3.x-02569B?style=for-the-badge&logo=flutter&logoColor=white)](https://flutter.dev)
[![Dart](https://img.shields.io/badge/Dart-3.x-0175C2?style=for-the-badge&logo=dart&logoColor=white)](https://dart.dev)
[![RPS](https://img.shields.io/badge/RPS-Scripts_Runner-blueviolet?style=for-the-badge)](https://pub.dev/packages/rps)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)

High-performance, cross-platform mobile client for the **Pokédex System** built with **Flutter** and **Dart 3**, powered by **RPS (Run Pubspec Scripts)** for seamless developer script orchestration and integrated with the monorepo's **Multiplatform Design Token Engine** (`@pokedex/ui`).

---

## 📑 Table of Contents

- [Overview](#-overview)
- [⚡ Complete Guide to RPS (Run Pubspec Scripts)](#-complete-guide-to-rps-run-pubspec-scripts)
  - [What is RPS?](#what-is-rps)
  - [Why use RPS in Flutter?](#why-use-rps-in-flutter)
  - [Installation & Shell Setup](#installation--shell-setup)
  - [Configuration in `pubspec.yaml`](#configuration-in-pubspecyaml)
  - [Available Project Scripts & Examples](#available-project-scripts--examples)
  - [Advanced Features (Arguments, Interactive Mode, Chaining)](#advanced-features)
  - [Troubleshooting & Common Pitfalls](#troubleshooting--common-pitfalls)
- [🎨 Integration with Multiplatform Design Tokens (`@pokedex/ui`)](#-integration-with-multiplatform-design-tokens-pokedexui)
- [⚙️ Prerequisites & Environment Setup](#️-prerequisites--environment-setup)
- [🚀 Running the Application](#-running-the-application)
- [📁 Project Structure](#-project-structure)

---

## 📖 Overview

`pokedex_flutter` provides a fluid native client for the Pokédex ecosystem. It is designed to consume:
1. **Multiplatform Design Tokens**: Generated directly by `@pokedex/ui` as strongly typed Dart color constants (`PokedexTokens`).
2. **Centralized SVG Icons**: Shared single-source icons located in `libs/ui/assets/icons/`.
3. **High-Throughput Backend**: Communicating with the Spring Boot `pokedex-api` (`http://localhost:8080/api/v1`).

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
description: "Pokédex Flutter Mobile Client"
publish_to: "none"
version: 0.1.0+1

# ⚡ Custom RPS Scripts Definition
scripts:
  # Run on a specific iOS Simulator UUID
  dev:ios: flutter run -d DF7E47CA-2BBD-42A2-AF30-4DBB8DC271C7

  # Run on the active Android Emulator or physical device
  dev:android: flutter run -d

  # Code Generation with Build Runner
  gen: dart run build_runner build --delete-conflicting-outputs

  # Complete clean, package re-fetch, and cache flush
  clean:all: >
    flutter clean &&
    flutter pub get &&
    dart run build_runner clean

environment:
  sdk: ^3.11.1

dependencies:
  flutter:
    sdk: flutter

dev_dependencies:
  flutter_test:
    sdk: flutter
  flutter_lints: ^6.0.0

flutter:
  uses-material-design: true
  assets:
    - ../../libs/ui/assets/icons/
```

---

### Available Project Scripts & Examples

| Script | Command | Purpose & Description |
| :--- | :--- | :--- |
| **`rps dev:ios`** | `flutter run -d <UUID>` | Launches the app in debug mode on the target iOS Simulator (e.g., iPhone 17 Pro). Supports Hot Reload (`r`) and Hot Restart (`R`). |
| **`rps dev:android`** | `flutter run -d` | Launches the app on the connected Android emulator or physical device. |
| **`rps gen`** | `dart run build_runner build ...` | Runs code generation for JSON serialization, Freezed models, or Riverpod providers. |
| **`rps clean:all`** | `flutter clean && flutter pub get ...` | Deletes build artifacts, cleans `.dart_tool`, flushes Xcode/Gradle cache, and re-resolves dependencies. |
| **`rps ls`** | `rps ls` | Lists all defined scripts and their underlying commands. |
| **`rps`** | *(interactive)* | Displays an interactive CLI menu to select and execute any script. |

#### Usage Examples:

```bash
# 📱 1. Run on iOS Simulator
rps dev:ios

# 🤖 2. Run on Android Emulator
rps dev:android

# 🧹 3. Run complete cleanup pipeline
rps clean:all

# 📋 4. List all available scripts
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
  gen (dart run build_runner build --delete-conflicting-outputs)
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
- **Fix**: Add `build_runner: ^2.4.0` to `dev_dependencies` in `pubspec.yaml` and execute `flutter pub get`.

#### 3. Exit Code 137 on `rps dev:ios`
- **Cause**: Exit code `137` occurs when a process is killed externally (e.g., stopping the process with `Ctrl+C` / `SIGKILL` or iOS Simulator process termination).
- **Fix**: Re-run `rps dev:ios` or restart the iOS Simulator via `Simulator > Quit Simulator` and relaunch.

#### 4. `command not found: rps`
- **Cause**: `~/.pub-cache/bin` is not in your shell's `$PATH`.
- **Fix**: Add `export PATH="$PATH":"$HOME/.pub-cache/bin"` to your `~/.zshrc` and run `source ~/.zshrc`.

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
- **Xcode** *(macOS)*: 15+ for iOS simulator and physical device builds.
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
│   └── main.dart            # Flutter application entrypoint
├── pubspec.yaml             # Dependencies, assets & RPS scripts configuration
├── analysis_options.yaml    # Linter rules & static analysis settings
├── project.json             # Nx monorepo target mappings
└── README.md                # Project documentation & RPS guide
```

---

> This digital ecosystem has been designed, structured, and developed to high-performance standards by **[Cabuweb](https://cabuweb.com)** - **Software Developer: Diego Villa**.
