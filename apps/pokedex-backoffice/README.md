# 💻 Pokédex Backoffice Web Application

[![Angular](https://img.shields.io/badge/Angular-22-DD0031?style=for-the-badge&logo=angular&logoColor=white)](https://angular.dev)
[![TypeScript](https://img.shields.io/badge/TypeScript-6.0-3178C6?style=for-the-badge&logo=typescript&logoColor=white)](https://www.typescriptlang.org/)
[![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![Nx](https://img.shields.io/badge/Nx-23.1-143055?style=for-the-badge&logo=nx&logoColor=white)](https://nx.dev)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)

High-performance, administrative dashboard for the **Pokédex System** built with **Angular 22** standalone components, **Signal-driven reactivity**, and **Zoneless-ready** architecture.

---

## 📑 Table of Contents

- [Overview & Architecture](#-overview--architecture)
- [✨ Key Features](#-key-features)
- [🛠️ Tech Stack & Standards](#️-tech-stack--standards)
- [🎨 Design System Integration (`@pokedex/ui`)](#-design-system-integration-pokedexui)
- [🔌 API Proxy & Backend Integration](#-api-proxy--backend-integration)
- [🐳 Docker & Containerization](#-docker--containerization)
- [🚀 Quickstart & Available Scripts](#-quickstart--available-scripts)
- [📁 Directory Structure](#-directory-structure)

---

## 📖 Overview & Architecture

The **Pokédex Backoffice** provides an enterprise management portal for cataloging Pokémon data, visualizing design token palettes, inspecting the centralized SVG icon library, and managing API resources.

### Architectural Highlights
- **100% Standalone Components**: Zero `NgModule` boilerplate.
- **Signal-Based Reactivity**: Pure synchronous state management with `signal()`, `computed()`, and `input()`.
- **OnPush Change Detection**: Every component enforces `ChangeDetectionStrategy.OnPush` for optimal DOM reconciliation performance.
- **Strict Typing**: Full strict mode with TypeScript 6.0 and explicit DTO mappings.

---

## ✨ Key Features

- 🖼️ **Icon Gallery & Asset Explorer**: Real-time preview of the single source of truth SVG icon catalog from `@pokedex/ui`.
- 🛡️ **Sanitized Dynamic SVG Rendering**: Custom `SafeHtmlPipe` leveraging Angular's `DomSanitizer` to render vector icons securely.
- 🎨 **Type Tokens & Color Badges**: Automatic visual mapping of Pokémon elemental types (`fire`, `water`, `grass`, `electric`, `psychic`, etc.) using CSS variables.
- 🔄 **API Proxy Integration**: Built-in development proxy (`proxy.conf.json`) forwarding `/api` calls directly to the Spring Boot `pokedex-api`.

---

## 🛠️ Tech Stack & Standards

| Technology | Version | Purpose |
| :--- | :--- | :--- |
| **Angular** | `^22.1.4` | Standalone components, Signals, modern control flow (`@if`, `@for`, `@switch`) |
| **TypeScript** | `~6.0.3` | Strict static typing |
| **SCSS** | Modern | Glassmorphism, CSS Custom Properties, and responsive flex/grid layouts |
| **Docker** | Node 22 Alpine | Containerized development runtime within pnpm monorepo context |
| **Nx** | `23.1.2` | Monorepo task execution and computation caching |
| **@pokedex/ui** | Monorepo Core | Multiplatform Design Token Engine (colors, typography, SVG vectors) |

---

## 🎨 Design System Integration (`@pokedex/ui`)

The Backoffice imports styles and tokens compiled by the `@pokedex/ui` library:

### 1. Global Styles (`styles.scss`)
```scss
@import "@pokedex/ui/fonts.css";
@import "@pokedex/ui/tokens.css";
```

### 2. Consuming Typed Icons in Components
```typescript
import { ChangeDetectionStrategy, Component, computed, input } from '@angular/core';
import { POKEDEX_ICONS } from '@pokedex/ui/icons';
import { SafeHtmlPipe } from '@shared/pipes/safe-html.pipe';

@Component({
  standalone: true,
  selector: 'app-home',
  templateUrl: 'home.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [SafeHtmlPipe],
})
export class HomeComponent {
  readonly icons = input<Record<string, string>>(POKEDEX_ICONS);
  readonly iconsMapped = computed(() =>
    Object.entries(this.icons()).map(([name, svg]) => ({ name, svg }))
  );
}
```

---

## 🔌 API Proxy & Backend Integration

The development server includes a proxy configuration in [`proxy.conf.json`](file:///Users/diegovilla/Desktop/pokedex-system/apps/pokedex-backoffice/proxy.conf.json) to communicate with the Spring Boot backend without CORS issues:

```json
{
  "/api": {
    "target": "http://localhost:8080",
    "secure": false
  }
}
```

---

## 🐳 Docker & Containerization

The Backoffice is fully containerized using **Docker** and pre-configured for the **pnpm monorepo**:

### Monorepo Dockerfile Strategy
Because the Backoffice depends on `@pokedex/ui` via `workspace:*` and hoisted root dependencies, the image build uses the monorepo root context (`context: .`):
1. Copies root workspace manifests (`package.json`, `pnpm-lock.yaml`, `pnpm-workspace.yaml`).
2. Installs monorepo dependencies with `pnpm install --frozen-lockfile`.
3. Pre-compiles design tokens via `pnpm --filter @pokedex/ui build`.
4. Starts the Angular server with `--host 0.0.0.0 --port 4200 --disable-host-check`.

### Build & Run via Docker

```bash
# Build standalone Docker image via Nx
pnpm nx docker-build pokedex-backoffice

# Or start the entire stack via Docker Compose
pnpm docker:up
```

---

## 🚀 Quickstart & Available Scripts

### Run Development Server (Local)
```bash
# From workspace root:
pnpm nx dev pokedex-backoffice

# Or directly in the app folder:
cd apps/pokedex-backoffice
pnpm start
```
The application will be accessible at: **`http://localhost:4200/`**.

### Build for Production
```bash
pnpm nx build pokedex-backoffice
```
Build outputs are compiled to `dist/apps/pokedex-backoffice/browser`.

### Run Unit Tests
```bash
pnpm nx test pokedex-backoffice
```

---

## 📁 Directory Structure

```text
apps/pokedex-backoffice/
├── src/
│   ├── app/
│   │   ├── app.config.ts        # Global providers & router setup
│   │   ├── app.routes.ts        # Lazy-loaded feature routes
│   │   ├── app.ts               # Root shell component
│   │   ├── features/            # Feature-first modular components
│   │   │   └── pokedex/
│   │   │       ├── application/ # Application state & orchestration services
│   │   │       └── infrastructure/
│   │   │           └── pages/
│   │   │               └── home/ # Catalog & Icon gallery view
│   │   └── shared/              # Shared utilities, pipes & presentational components
│   │       └── pipes/           # SafeHtmlPipe for dynamic SVG vectors
│   ├── public/                  # Static assets
│   ├── main.ts                  # Bootstrap entrypoint
│   └── styles.scss              # Global stylesheets & design tokens
├── angular.json                 # Angular workspace configuration
├── Dockerfile                   # Monorepo-aware Docker container definition
├── .dockerignore                # Local ignore rules for Docker
├── proxy.conf.json              # Development API proxy
├── project.json                 # Nx targets configuration (dev, build, test, docker-build)
└── package.json                 # Backoffice dependencies
```

---

> This digital ecosystem has been designed, structured, and developed to high-performance standards by **[Cabuweb](https://cabuweb.com)** - **Software Developer: Diego Villa**.
