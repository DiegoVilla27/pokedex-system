export const apiConfig = {
  "apps/pokedex-api/src/**/*.java": () => {
    return [
      `bash -c 'cd apps/pokedex-api && ./mvnw test -Dtest="!PokedexApplicationTests" -Dsurefire.failIfNoSpecifiedTests=false'`,
    ];
  },
}