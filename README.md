# 🌐 Pokédex System — Enterprise Monorepo

Enterprise-grade, multi-application monorepo powered by **Nx** and **pnpm workspaces**, architected around **Angular 22** standalone components, signal reactivity, and centralized design tokens.

---

## 📖 Core Abstract & Functional Overview

The **Pokédex System** is designed to provide high-performance management and cataloging for Pokémon ecosystems. The monorepo hosts modular applications and shared design systems with strict feature-first encapsulation, zoneless change detection readiness, and atomic design token orchestration.

### Feature Matrix

| Workspace Target | Type | Primary Technology | Description | Status |
| :--- | :--- | :--- | :--- | :--- |
| **`pokedex-backoffice`** | Application | Angular `v22.1.4` (Standalone) | Administrative backoffice for managing Pokémon data, icon galleries, and catalog metadata. | 🟢 Active |
| **`@pokedex/ui`** | Shared Library | TypeScript / CSS / JSON | Centralized design tokens, SVG icon library (`POKEDEX_ICONS`), and typography stylesheets. | 🟢 Active |
| **`.agents/`** | Architecture | Custom AI Rules & Skills | Protocol specifications for Modern Angular, Ionic, Flutter, Spring Boot, and Web Performance. | 🟢 Active |

---

## 🚀 Architectural Runtime Flow

```mermaid
graph TD
    User([User / Browser]) -->|HTTP Request| Backoffice[apps/pokedex-backoffice]
    
    subgraph apps/pokedex-backoffice [Angular 22 Application]
        Main[main.ts - bootstrapApplication]
        Config[app.config.ts - Router & Error Listeners]
        Routes[app.routes.ts - Lazy Route Resolver]
        Home[HomeComponent - OnPush & Signals]
        SafePipe[SafeHtmlPipe - DomSanitizer]
        
        Main --> Config
        Config --> Routes
        Routes -->|Lazy Load| Home
        Home --> SafePipe
    end
    
    subgraph libs/ui [@pokedex/ui Design Library]
        Tokens[tokens.json - Color & Spacing Tokens]
        Fonts[fonts.css - Typography CDN & Rules]
        Icons[icons.ts - POKEDEX_ICONS Catalog]
    end

    Home -->|Signal Input / Computed| Icons
    Backoffice -->|Global Styles Import| Fonts
    Home -->|Style Variables| Tokens
```

---

## 📁 Directory Tree

```text
pokedex-system/
├── .agents/                               # Enterprise Architecture protocols and AI Skills
│   ├── AGENTS.md                          # Master architectural protocol & coding standards
│   └── skills/                            # Domain-specific engineering skills
├── apps/
│   └── pokedex-backoffice/                # Standalone Angular 22 Backoffice Web Application
│       ├── src/
│       │   ├── app/
│       │   │   ├── features/
│       │   │   │   └── pokedex/
│       │   │   │       └── infrastructure/
│       │   │   │           └── pages/
│       │   │   │               └── home/   # Home catalog component with Signal inputs
│       │   │   ├── shared/
│       │   │   │   └── pipes/             # SafeHtmlPipe for trusted SVG rendering
│       │   │   ├── app.config.ts          # Application providers configuration
│       │   │   ├── app.routes.ts          # Lazy-loaded route definitions
│       │   │   └── app.ts                 # Root shell component
│       │   ├── index.html                 # Main entry HTML
│       │   ├── main.ts                    # Standalone bootstrapping entrypoint
│       │   └── styles.scss                # Global styles with @pokedex/ui imports
│       ├── angular.json                   # Angular workspace configuration
│       ├── project.json                   # Nx project target definitions
│       └── package.json                   # Application dependencies
├── libs/
│   └── ui/                                # Shared UI Design System package
│       ├── fonts.css                      # Global web fonts definitions
│       ├── icons.ts                       # Typed POKEDEX_ICONS catalog (SVG map)
│       ├── tokens.json                    # Design tokens (colors, palette, metrics)
│       └── package.json                   # Subpath exports definition
├── nx.json                                # Nx build system and task graph caching
├── package.json                           # Monorepo root configuration
├── pnpm-workspace.yaml                    # Workspace packages topology
└── tsconfig.base.json                     # Shared TypeScript compiler settings
```

---

## 🛠️ Technical Stack & Dependencies

### Core Workspace Dependencies

| Dependency | Category | Exact Version | Purpose |
| :--- | :--- | :--- | :--- |
| **`nx`** | Build Orchestration | `23.1.2` | Smart monorepo task runner, computation caching, and project graph |
| **`typescript`** | Language | `~6.0.3` | Strict static typing and modern ECMAScript compilation |
| **`prettier`** | Code Quality | `^3.8.1` | Unified code formatting |

### Application Dependencies (`apps/pokedex-backoffice`)

| Package | Version | Purpose |
| :--- | :--- | :--- |
| **`@angular/core`** | `^22.1.4` | Modern Angular Framework with Signals & Standalone Components |
| **`@angular/common`** | `^22.1.4` | Common Angular directives and utilities |
| **`@angular/forms`** | `^22.1.4` | Reactive forms management |
| **`@angular/platform-browser`** | `^22.1.4` | DOM and Browser execution layer |
| **`@angular/router`** | `^22.1.4` | Component input binding and lazy-loaded routing |
| **`@angular/cli` / `@angular/build`** | `^22.1.4` | Application bundling and development server |
| **`rxjs`** | `~7.8.0` | Reactive asynchronous streams |
| **`zone.js`** | `~0.15.0` | Execution context tracking |
| **`@pokedex/ui`** | `workspace:*` | Internal monorepo design system package |

---

## ⚙️ Provisioning & Setup Guide

### Prerequisites
- **Node.js**: `>= 20.x` or `>= 22.x`
- **pnpm**: `>= 9.x`
- **Git**

### 1. Repository Installation

Clone the repository and install all workspace dependencies:

```bash
# Clone the repository
git clone https://github.com/DiegoVilla27/pokedex-system.git
cd pokedex-system

# Install dependencies across all packages
pnpm install
```

### 2. Available Development Scripts

All tasks can be executed from the root workspace using `pnpm` or `nx`:

```bash
# Start all development servers
pnpm dev

# Or serve pokedex-backoffice specifically
pnpm nx serve pokedex-backoffice

# Build all applications and libraries in production mode
pnpm build

# Execute unit tests across the workspace
pnpm test

# Visualize the Nx Project Graph and dependency topology
pnpm graph

# Clean artifacts and reinstall node_modules
pnpm clean
```

---

## 📈 Performance & Architecture Highlights

- **⚡ Signal-Driven Reactivity**: Presentational and container components leverage Angular Signal primitives (`input()`, `computed()`) to ensure granular DOM updates.
- **🛡️ OnPush Change Detection**: Every routed view and component implements `ChangeDetectionStrategy.OnPush` to minimize re-renders.
- **📦 Atomic Design Tokens**: Centralized `@pokedex/ui` isolates icons, typography, and theme tokens for reuse across current and future workspace applications.
- **🚀 Nx Computation Caching**: Rebuilds and task runs (`build`, `test`, `lint`) are cached automatically through Nx named inputs.

---

> This digital ecosystem has been designed, structured, and developed to high-performance standards by **[Cabuweb](https://cabuweb.com)** - **Software Developer: Diego Villa**.
