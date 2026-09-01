# 📱 Pokédex Mobile App (Ionic + Capacitor)

[![Ionic](https://img.shields.io/badge/Ionic-9.0-3880FF?style=for-the-badge&logo=ionic&logoColor=white)](https://ionicframework.com/)
[![Angular](https://img.shields.io/badge/Angular-22-DD0031?style=for-the-badge&logo=angular&logoColor=white)](https://angular.dev)
[![Capacitor](https://img.shields.io/badge/Capacitor-8.5-119EFF?style=for-the-badge&logo=capacitor&logoColor=white)](https://capacitorjs.com/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)

A modern, responsive, and high-performance cross-platform Pokédex mobile application built with **Ionic 9**, **Angular 22** (Signals & Standalone Components), and **Capacitor 8** for iOS, Android, and Web.

---

## 📑 Table of Contents

- [Overview](#-overview)
- [🚀 Core Technologies](#-core-technologies)
- [✨ Key Features](#-key-features)
- [📸 Screenshots](#-screenshots)
- [🎨 Design System Integration (`@pokedex/ui`)](#-design-system-integration-pokedexui)
- [📋 Prerequisites](#-prerequisites)
- [🛠️ Web Installation & Quickstart](#️-web-installation--quickstart)
- [📱 Native Platforms Deployment (iOS & Android)](#-native-platforms-deployment-ios--android)
  - [🍎 iOS Setup & Live Reload](#-ios-setup--live-reload)
  - [🤖 Android Setup & Live Reload](#-android-setup--live-reload)
  - [🔄 Asset Synchronization Workflow](#-asset-synchronization-workflow)
- [📜 Available Scripts Reference](#-available-scripts-reference)
- [📂 Project Structure](#-project-structure)

---

## 📖 Overview

The **Pokédex Mobile App** provides an immersive mobile experience for discovering, filtering, inspecting, and favoriting Pokémon. It features native hardware acceleration, haptic feedback, fluid micro-animations, and offline storage synchronization across iOS, Android, and Web.

---

## 🚀 Core Technologies

- **Frontend Framework:** [Angular 22](https://angular.dev/) (Standalone Components, Signals & Modern Control Flow `@if/@for`)
- **Mobile UI Components:** [Ionic 9](https://ionicframework.com/) (Web Components with native look & feel)
- **Native Bridge:** [Capacitor 8](https://capacitorjs.com/) (iOS & Android native runtime)
- **Design Tokens:** `@pokedex/ui` (Multiplatform W3C design tokens and SVG icons)
- **Local Persistence:** `@ionic/storage-angular` (IndexedDB / SQLite local database)
- **Native Plugins:** `@capacitor/haptics`, `@capacitor/keyboard`, `@capacitor/status-bar`, `@capacitor/app`

---

## ✨ Key Features

- ⚡ **Infinite Exploration:** High-performance Pokémon grid with virtual scrolling and smooth on-demand pagination.
- 🔍 **Real-Time Search & Filtering:** Filter simultaneously by query string and elemental types (`fire`, `water`, `grass`, `dragon`, etc.).
- 📊 **Detailed Combat Stats Visualizer:** Color-coded stat bars normalized against maximum base statistics.
- 🌳 **Adaptive Evolution Tree:** Supports linear 3-stage evolutions as well as branching trees (e.g., Eevee with 8 evolution pathways).
- ❤️ **Persistent Favorites:** Reactive favorites management with instant cross-view synchronization.
- 📳 **Native Haptics & Glassmorphism:** Micro-interactions and backdrop blur filters optimized for 60fps/120fps displays.

---

## 📸 Screenshots

| Pokédex (Grid) | Detail (Stats) | Detail (Evolutions) | Favorites |
| :---: | :---: | :---: | :---: |
| <img src="docs/screenshots/pokedex_home.png" width="200" alt="Pokédex Home" /> | <img src="docs/screenshots/pokemon_detail_stats.png" width="200" alt="Pokémon Stats" /> | <img src="docs/screenshots/pokemon_detail_evolutions.png" width="200" alt="Pokémon Evolutions" /> | <img src="docs/screenshots/favorites_empty.png" width="200" alt="Favorites" /> |

---

## 🎨 Design System Integration (`@pokedex/ui`)

`pokedex-ionic` imports typography, color variables, and SVG icons from the monorepo's shared design core:

```scss
// src/global.scss
@import "@pokedex/ui/fonts.css";
@import "@pokedex/ui/tokens.css";
```

---

## 📋 Prerequisites

- **Node.js:** `>= 20.x` or `>= 22.x`
- **pnpm:** `>= 9.x`
- **Ionic CLI:** `npm install -g @ionic/cli`
- **macOS + Xcode 15+** *(for iOS Simulator / physical device)*
- **Android Studio + Android SDK** *(for Android Emulator / physical device)*

---

## 🛠️ Web Installation & Quickstart

### 1. Install dependencies
```bash
# From workspace root
pnpm install
```

### 2. Run Web Development Server
```bash
# Run via Nx
pnpm nx dev pokedex-ionic

# Or run via Ionic CLI directly in apps/pokedex-ionic
cd apps/pokedex-ionic
pnpm dev
```
The web app will be available at: **`http://localhost:8100/`**.

---

## 📱 Native Platforms Deployment (iOS & Android)

### 🍎 iOS Setup & Live Reload

```bash
cd apps/pokedex-ionic

# 1. Build web bundle
ionic build

# 2. Synchronize web assets to native iOS project
npx cap sync ios

# 3. Open project in Xcode
npx cap open ios

# 4. Run with Live Reload on Simulator:
pnpm dev:ios
# Equivalent to: ionic capacitor run ios -l --external
```

#### List available iOS simulator devices:
```bash
xcrun simctl list devices available
```

---

### 🤖 Android Setup & Live Reload

```bash
cd apps/pokedex-ionic

# 1. Build web bundle
ionic build

# 2. Synchronize web assets to native Android project
npx cap sync android

# 3. Open project in Android Studio
npx cap open android

# 4. Run with Live Reload on Emulator / Device:
pnpm dev:android
# Equivalent to: ionic capacitor run android -l --external
```

#### List connected Android devices:
```bash
adb devices
```

---

### 🔄 Asset Synchronization Workflow

Whenever frontend code or assets change and you are not using Live Reload:

```bash
# Compile web bundle and copy to ios/ and android/
ionic build
npx cap sync
```

---

## 📜 Available Scripts Reference

| Command | Description |
| :--- | :--- |
| `pnpm dev` | Starts local web dev server (`ng serve` on port 8100) |
| `pnpm dev:ios` | Runs application on iOS Simulator with Live Reload |
| `pnpm dev:android` | Runs application on Android Emulator with Live Reload |
| `pnpm build` | Compiles production web bundle to `/www` |
| `pnpm test` | Runs unit test suite with Vitest |
| `pnpm lint` | Runs ESLint static code analysis |

---

## 📂 Project Structure

```text
apps/pokedex-ionic/
├── src/
│   ├── app/
│   │   ├── app.component.ts       # Root Ionic component
│   │   ├── app.routes.ts          # Route definitions and tab layout
│   │   ├── features/
│   │   │   ├── pokedex/           # Pokédex exploration, cards, detail & evolutions
│   │   │   └── favorites/         # Favorites management & reactive storage
│   │   └── shared/
│   │       ├── layout/            # Header, Navigation Tabs, and Drawers
│   │       ├── services/          # StorageService & core utilities
│   │       └── utils/             # Type colors, icons & stat configurations
│   ├── assets/                    # Graphical assets and fallbacks
│   ├── global.scss                # Global styles & design token bindings
│   └── theme/                     # Ionic color variables
├── ios/                           # Capacitor native iOS project
├── android/                       # Capacitor native Android project
├── capacitor.config.ts            # Capacitor runtime settings
├── project.json                   # Nx monorepo target mappings
└── package.json                   # Mobile application dependencies
```

---

> This digital ecosystem has been designed, structured, and developed to high-performance standards by **[Cabuweb](https://cabuweb.com)** - **Software Developer: Diego Villa**.
