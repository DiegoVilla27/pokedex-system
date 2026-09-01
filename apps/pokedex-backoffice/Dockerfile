# Imagen base con Node.js sobre Alpine
FROM node:22-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Instalar pnpm globalmente
RUN npm install -g pnpm@latest

# 1. Copiar manifiestos del workspace para aprovechar la caché de capas de Docker
COPY package.json pnpm-lock.yaml pnpm-workspace.yaml tsconfig.base.json nx.json ./
COPY libs/ui/package.json ./libs/ui/
COPY apps/pokedex-backoffice/package.json ./apps/pokedex-backoffice/

# 2. Instalar todas las dependencias del monorepo
RUN pnpm install --frozen-lockfile

# 3. Copiar el código fuente de la librería UI y del Backoffice
COPY libs/ui ./libs/ui
COPY apps/pokedex-backoffice ./apps/pokedex-backoffice

# 4. Compilar los tokens de diseño e iconos antes de iniciar Angular
RUN pnpm --filter @pokedex/ui build
WORKDIR /app/apps/pokedex-backoffice

# Exponer el puerto configurado en Angular (4200)
EXPOSE 4200

# Iniciar el servidor de desarrollo de Angular escuchando en todas las interfaces de red
CMD ["pnpm", "exec", "ng", "serve", "--host", "0.0.0.0", "--port", "4200"]