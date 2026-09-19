export const apiConfig = {
  "apps/pokedex-api/src/**/*.java": () => {
    return [
      `bash -c 'cd apps/pokedex-api && ./mvnw spotless:apply'`,
      `bash -c 'cd apps/pokedex-api && ./mvnw test -Dtest="!PokedexApplicationTests"'`,
    ];
  },
}