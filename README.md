# 🌐 Pokédex System — Enterprise Monorepo

[![Nx](https://img.shields.io/badge/Nx-23.1-143055?style=for-the-badge&logo=nx&logoColor=white)](https://nx.dev)
[![pnpm](https://img.shields.io/badge/pnpm-Workspaces-F69220?style=for-the-badge&logo=pnpm&logoColor=white)](https://pnpm.io)
[![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1.1-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Angular](https://img.shields.io/badge/Angular-22-DD0031?style=for-the-badge&logo=angular&logoColor=white)](https://angular.dev)
[![Ionic](https://img.shields.io/badge/Ionic-9.0-3880FF?style=for-the-badge&logo=ionic&logoColor=white)](https://ionicframework.com/)
[![Flutter](https://img.shields.io/badge/Flutter-3.x-02569B?style=for-the-badge&logo=flutter&logoColor=white)](https://flutter.dev)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)

Enterprise-grade, multi-application monorepo powered by **Nx** and **pnpm workspaces**, architected around **Java 21 / Spring Boot 3.x / 4.x**, **Angular 22** standalone components with Signal reactivity, **Ionic 9 / Capacitor 8+** for cross-platform hybrid mobile delivery, **Flutter 3.x (Dart 3)** with **RPS (Run Pubspec Scripts)**, and a **Multiplatform Design Token Engine** (`@pokedex/ui`).

---

## 📖 Core Abstract & Functional Overview

The **Pokédex System** is an end-to-end digital ecosystem for Pokémon cataloging, administrative management, and multiplatform distribution. Built with a **Single Version Policy (SVP)**, the monorepo guarantees seamless version alignment, eliminates runtime dependency duplication, and enables maximum code and asset sharing across Web, iOS, Android, and Flutter.

### Feature & Workspace Matrix

| Workspace Target | Type | Primary Technology | Description | Status | Documentation Link | Default Port / Target |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **`pokedex-api`** | Backend REST API | Java 21 / Spring Boot 3.x / PostgreSQL | High-throughput REST API with PostgreSQL persistence, JPA queries, and Swagger OpenAPI documentation. | 🟢 Active | [API Documentation](file:///Users/diegovilla/Desktop/pokedex-system/apps/pokedex-api/README.md) | `http://localhost:8080/api/v1` |
| **`pokedex-backoffice`** | Web Application | Angular `v22.1.4` (Standalone) | Administrative dashboard for managing Pokémon data, icon galleries, and catalog metadata with Signals. | 🟢 Active | [Backoffice Documentation](file:///Users/diegovilla/Desktop/pokedex-system/apps/pokedex-backoffice/README.md) | `http://localhost:4200` |
| **`pokedex-ionic`** | Hybrid Mobile & Web | Ionic 9 / Angular `v22.1.4` / Capacitor 8+ | Native cross-platform application for iOS, Android, and Web with local storage and fluid micro-interactions. | 🟢 Active | [Ionic Documentation](file:///Users/diegovilla/Desktop/pokedex-system/apps/pokedex-ionic/README.md) | `http://localhost:8100` / iOS / Android |
| **`pokedex_flutter`** | Native Mobile Client | Flutter 3.x / Dart 3 / RPS | Native mobile client with custom RPS (Run Pubspec Scripts) automation and design token bindings. | 🟢 Active | [Flutter & RPS Documentation](file:///Users/diegovilla/Desktop/pokedex-system/apps/pokedex_flutter/README.md) | iOS Simulator / Android |
| **`@pokedex/ui`** | Shared Design Core | TypeScript / CSS / Dart / W3C Tokens | Multiplatform design system compiling W3C tokens and SVGs to Web (CSS/TS) and Flutter (Dart). | 🟢 Active | [UI Design Token Documentation](file:///Users/diegovilla/Desktop/pokedex-system/libs/ui/README.md) | Subpath exports (`@pokedex/ui/*`) |
| **`.agents/`** | Architecture | Custom AI Rules & Skills | Enterprise engineering standards for Angular, Ionic, Spring Boot, Flutter, and Performance. | 🟢 Active | [Master Architecture Protocol](file:///Users/diegovilla/Desktop/pokedex-system/.agents/AGENTS.md) | Monorepo Governance |

---

## 🚀 Architectural Runtime Flow

```mermaid
graph TD
    subgraph Clients [Clients & Applications]
        Backoffice["💻 Backoffice Web<br/>(Angular 22 Standalone)"]
        IonicApp["📱 Mobile App iOS / Android / Web<br/>(Ionic 9 + Capacitor 8+)"]
        FlutterApp["🦋 Mobile App iOS / Android<br/>(Flutter 3.x + RPS)"]
    end

    subgraph DesignCore ["libs/ui (@pokedex/ui Design Token Engine)"]
        TokensSource["tokens.json<br/>(W3C Standard Colors)"]
        IconsSource["assets/icons/*.svg<br/>(Single Source SVGs)"]
        BuildScript["build-tokens.ts<br/>(Token Compiler)"]
        
        TokensSource --> BuildScript
        IconsSource --> BuildScript
        BuildScript --> GeneratedWeb["generated/web/<br/>(tokens.css, tokens.ts, icons.ts)"]
        BuildScript --> GeneratedFlutter["generated/flutter/<br/>(pokedex_tokens.dart)"]
    end

    subgraph BackendServices [Backend & Persistence Layer]
        API["☕ pokedex-api<br/>(Spring Boot / Java 21)"]
        Postgres[("🐘 PostgreSQL Database<br/>(localhost:5432/pokemon_db)")]
        Swagger["📑 Swagger UI / OpenAPI 3.0<br/>(/api/v1/swagger-ui.html)"]
        
        API --> Postgres
        API --> Swagger
    end

    GeneratedWeb -->|Theme & Icons| Backoffice
    GeneratedWeb -->|Theme & Icons| IonicApp
    GeneratedFlutter -->|Dart Tokens| FlutterApp
    IconsSource -->|Asset Bundle| FlutterApp

    Backoffice -->|HTTP / REST API| API
    IonicApp -->|HTTP / REST API| API
    FlutterApp -->|HTTP / REST API| API
```

---

## 📁 Directory Tree

```text
pokedex-system/
├── .agents/                               # Enterprise Architecture protocols and AI Skills
│   ├── AGENTS.md                          # Master architectural protocol & coding standards
│   └── skills/                            # Domain-specific engineering skills
├── apps/
│   ├── pokedex-api/                       # Spring Boot 3.x / Java 21 REST API
│   │   ├── src/
│   │   │   └── main/
│   │   │       ├── java/com/dv/pokedex/   # Domain entities, repositories, and controllers
│   │   │       └── resources/             # application.properties, data seeders & SQL
│   │   ├── pom.xml                        # Maven dependency configuration
│   │   ├── project.json                   # Nx project target definitions
│   │   └── README.md                      # Backend API documentation
│   ├── pokedex-backoffice/                # Standalone Angular 22 Backoffice Web Application
│   │   ├── src/
│   │   │   ├── app/
│   │   │   │   ├── features/pokedex/      # Feature-first catalog module with Signals
│   │   │   │   ├── shared/pipes/          # SafeHtmlPipe for trusted SVG rendering
│   │   │   │   ├── app.config.ts          # Angular providers & router configuration
│   │   │   │   └── app.routes.ts          # Lazy-loaded route definitions
│   │   │   ├── main.ts                    # Standalone bootstrapping entrypoint
│   │   │   └── styles.scss                # Global styles with @pokedex/ui imports
│   │   ├── angular.json                   # Angular workspace configuration
│   │   ├── project.json                   # Nx project target definitions
│   │   ├── package.json                   # Backoffice workspace dependencies
│   │   └── README.md                      # Backoffice application documentation
│   ├── pokedex-ionic/                     # Ionic 9 + Capacitor 8+ Cross-Platform Mobile App
│   │   ├── src/
│   │   │   ├── app/
│   │   │   │   ├── features/              # Feature modules (pokedex, favorites)
│   │   │   │   ├── shared/                # Layout, components, and storage service
│   │   │   │   ├── app.component.ts       # Root Ionic component
│   │   │   │   └── app.routes.ts          # Mobile navigation routes
│   │   │   ├── main.ts                    # Standalone bootstrap with Ionic & Router providers
│   │   │   ├── global.scss                # Global stylesheets with @pokedex/ui tokens
│   │   │   └── theme/                     # Ionic theme variables
│   │   ├── ios/                           # Capacitor iOS native project
│   │   ├── android/                       # Capacitor Android native project
│   │   ├── capacitor.config.ts            # Capacitor runtime configuration
│   │   ├── project.json                   # Nx project target definitions
│   │   ├── package.json                   # Mobile-specific dependencies
│   │   └── README.md                      # Ionic app documentation
│   └── pokedex_flutter/                   # Flutter 3.x / Dart 3 Mobile Client (with RPS)
│       ├── ios/                           # Native iOS project
│       ├── android/                       # Native Android project
│       ├── lib/
│       │   └── main.dart                  # Flutter entrypoint
│       ├── pubspec.yaml                   # Dependencies & RPS scripts configuration
│       ├── project.json                   # Nx project target definitions
│       └── README.md                      # Flutter app documentation & exhaustive RPS guide
├── libs/
│   └── ui/                                # Multiplatform Design Token Engine
│       ├── assets/
│       │   └── icons/                     # Clean, standalone SVG icons (Single Source of Truth)
│       ├── src/
│       │   ├── tokens.json                # Standard W3C color tokens
│       │   └── fonts.css                  # Typography CDN & font-family definitions
│       ├── scripts/
│       │   └── build-tokens.ts            # Cross-platform compiler (generates Web & Flutter outputs)
│       ├── generated/                     # Compiled outputs
│       │   ├── web/                       # tokens.css, tokens.ts, icons.ts (Angular, Ionic, React)
│       │   └── flutter/                   # pokedex_tokens.dart (Flutter)
│       ├── package.json                   # Subpath exports definition
│       └── README.md                      # UI Library documentation & integration guide
├── docker-compose.yml                     # Local PostgreSQL and container definitions
├── nx.json                                # Nx build system and task graph caching
├── package.json                           # Monorepo root configuration (Single Version Policy)
├── pnpm-workspace.yaml                    # Workspace packages topology
└── tsconfig.base.json                     # Shared TypeScript compiler settings
```

---

## 🛠️ Technical Stack & Dependencies

### Monorepo Core Platform (Single Version Policy)

All shared web dependencies are hoisted and managed at the root [package.json](file:///Users/diegovilla/Desktop/pokedex-system/package.json) to eliminate dependency duplication across workspace applications:

| Dependency | Category | Exact Version | Purpose |
| :--- | :--- | :--- | :--- |
| **`nx`** | Build Orchestration | `23.1.2` | Smart monorepo task runner, computation caching, and project dependency graph |
| **`@angular/core`** | Frontend Framework | `^22.1.4` | Modern Angular with Signals, OnPush change detection, and Standalone components |
| **`@angular/common`** | Framework Utilities | `^22.1.4` | Core directives, pipes, and common browser abstractions |
| **`@angular/router`** | Routing Engine | `^22.1.4` | Component input binding and granular lazy-loading |
| **`@angular/forms`** | Forms Management | `^22.1.4` | Strictly typed reactive forms |
| **`@angular/platform-browser`** | Browser Platform | `^22.1.4` | DOM rendering and browser execution layer |
| **`@angular/cli` / `@angular/build`** | Build Engine | `^22.1.4` | Vite/esbuild application bundler and development server |
| **`rxjs`** | Reactive Streams | `~7.8.0` | Asynchronous stream processing and state orchestration |
| **`zone.js`** | Runtime Tracking | `~0.15.0` | Execution context tracking |
| **`typescript`** | Language | `~6.0.3` | Strict static typing and modern ECMAScript compilation |
| **`prettier`** | Code Quality | `^3.8.1` | Automated and unified code formatting |

### Backend API (`apps/pokedex-api`)
- **Java**: `21` (LTS)
- **Spring Boot**: `3.x` / `4.1.1`
- **Spring Data JPA**: PostgreSQL persistence and Specification queries
- **Springdoc OpenAPI**: Automated Swagger 3.0 UI generation
- **HikariCP**: High-performance database connection pooling

### Mobile & Hybrid Application (`apps/pokedex-ionic`)
- **Ionic Framework**: `@ionic/angular` `^9.0.0` (Standalone native Web Components)
- **Capacitor**: `@capacitor/core`, `@capacitor/ios`, `@capacitor/android` `^8.5.0`
- **Native Plugins**: `@capacitor/haptics`, `@capacitor/keyboard`, `@capacitor/status-bar`, `@capacitor/app`
- **Local Persistence**: `@ionic/storage-angular` `^4.0.0`

### Mobile Client (`apps/pokedex_flutter`)
- **Flutter**: `3.x`
- **Dart**: `^3.11.1`
- **RPS (Run Pubspec Scripts)**: `^0.10.x` for custom pubspec script orchestration
- **Shared Tokens**: Bound to `@pokedex/ui` compiled Dart tokens

---

## ⚙️ Provisioning & Setup Guide

### Prerequisites
- **Node.js**: `>= 20.x` or `>= 22.x`
- **pnpm**: `>= 9.x` (`npm install -g pnpm`)
- **Java JDK**: `21` (for `pokedex-api`)
- **Docker**: For running PostgreSQL database container
- **Flutter SDK**: `>= 3.24.x` / `3.27.x`
- **RPS CLI**: `dart pub global activate rps`
- **Xcode** *(macOS)*: For running `pokedex-ionic` and `pokedex_flutter` on iOS Simulator
- **Android Studio**: For running on Android Emulator

---

### 1. Repository Installation

```bash
# Clone the repository
git clone https://github.com/DiegoVilla27/pokedex-system.git
cd pokedex-system

# Install all workspace dependencies
pnpm install
```

---

### 2. Database Setup (Docker PostgreSQL)

Start the PostgreSQL database container:

```bash
# Start PostgreSQL on port 5432
docker compose up -d
```

Database connection parameters:
- **Host**: `localhost:5432`
- **Database**: `pokemon_db`
- **Username**: `pokemon_user`
- **Password**: `pokemon_pass`

---

### 3. Running Applications

You can start all applications simultaneously or target them individually:

```bash
# 🚀 Start all web development servers simultaneously (API + Backoffice + Ionic)
pnpm dev

# ☕ Start only the Spring Boot Backend API
pnpm nx dev pokedex-api

# 💻 Start only the Angular Backoffice
pnpm nx dev pokedex-backoffice

# 📱 Start the Ionic Mobile App (iOS Live-Reload)
pnpm nx dev pokedex-ionic

# 🦋 Start the Flutter Mobile App (via Nx or RPS)
pnpm nx dev pokedex_flutter
# Or inside apps/pokedex_flutter:
cd apps/pokedex_flutter && rps dev:ios
```

---

### 4. Compiling Multiplatform Design Tokens (`@pokedex/ui`)

When modifying `tokens.json` or adding SVG icons to `libs/ui/assets/icons/`, recompile the tokens:

```bash
# Recompile design tokens to Web (CSS/TS) and Flutter (Dart)
pnpm --filter @pokedex/ui build
```

---

### 5. Build, Test & Maintenance Scripts

```bash
# Build all workspace applications for production
pnpm build

# Execute unit tests across the monorepo
pnpm test

# Visualize the interactive Nx Project Graph
pnpm graph

# Deep clean node_modules and local cache artifacts
pnpm clean
```

---

## 📈 Performance & Architecture Highlights

- **⚡ Single Version Policy (SVP)**: Guarantees zero duplicate Angular instances in memory, eliminating runtime dependency mismatch errors (`NG0203`).
- **🛡️ Signal-Driven Reactivity & OnPush**: Components utilize Angular Signals (`signal()`, `computed()`, `input()`) with `ChangeDetectionStrategy.OnPush` for optimal DOM reconciliation.
- **🎨 Multiplatform Token Engine**: Design tokens are authored in W3C JSON format and automatically compiled into type-safe constants for Web (`tokens.ts`, `tokens.css`) and Mobile (`pokedex_tokens.dart`).
- **📱 60fps Native Hybrid & Fluid Flutter Delivery**: Ionic 9 standalone web components paired with Capacitor 8+ hardware-accelerated bridges alongside native Flutter 3.x client.
- **⚡ RPS DX Boost**: Flutter lifecycle commands unified and accessible via `rps <script>` directly from `pubspec.yaml`.
- **🚀 Nx Computation Caching**: Builds, tests, and lints are hashed and cached to ensure instant subsequent task execution.

---

> This digital ecosystem has been designed, structured, and developed to high-performance standards by **[Cabuweb](https://cabuweb.com)** - **Software Developer: Diego Villa**.
