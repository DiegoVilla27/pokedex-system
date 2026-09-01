import { PokemonType } from "@features/pokedex/application/interfaces/response";

export interface TypeConfig {
  color: string;
  icon: string;
}

export const POKEMON_TYPE_CONFIG: Record<PokemonType, TypeConfig> = {
  grass: {
    color: '#2E7D32',
    icon: 'assets/types-pokemon/grass.svg',
  },
  poison: {
    color: '#7B1FA2',
    icon: 'assets/types-pokemon/poison.svg',
  },
  fire: {
    color: '#D84315',
    icon: 'assets/types-pokemon/fire.svg',
  },
  flying: {
    color: '#5C6BC0',
    icon: 'assets/types-pokemon/flying.svg',
  },
  water: {
    color: '#1565C0',
    icon: 'assets/types-pokemon/water.svg',
  },
  bug: {
    color: '#558B2F',
    icon: 'assets/types-pokemon/bug.svg',
  },
  normal: {
    color: '#616154',
    icon: 'assets/types-pokemon/normal.svg',
  },
  electric: {
    color: '#C67D0A',
    icon: 'assets/types-pokemon/electric.svg',
  },
  ground: {
    color: '#795548',
    icon: 'assets/types-pokemon/ground.svg',
  },
  fairy: {
    color: '#AD4891',
    icon: 'assets/types-pokemon/fairy.svg',
  },
  steel: {
    color: '#455A64',
    icon: 'assets/types-pokemon/steel.svg',
  },
  fighting: {
    color: '#A31D1D',
    icon: 'assets/types-pokemon/fighting.svg',
  },
  ghost: {
    color: '#483D73',
    icon: 'assets/types-pokemon/ghost.svg',
  },
  psychic: {
    color: '#AD1457',
    icon: 'assets/types-pokemon/psychic.svg',
  },
  rock: {
    color: '#827122',
    icon: 'assets/types-pokemon/rock.svg',
  },
  ice: {
    color: '#247B9B',
    icon: 'assets/types-pokemon/ice.svg',
  },
  dragon: {
    color: '#4A289D',
    icon: 'assets/types-pokemon/dragon.svg',
  },
  dark: {
    color: '#3E3947',
    icon: 'assets/types-pokemon/dark.svg',
  },
};