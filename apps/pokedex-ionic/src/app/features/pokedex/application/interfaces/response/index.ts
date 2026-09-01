
interface Pokemon {
  name: string;
  url: string;
  info: PokemonInfo
  color: [number, number, number],
  evolution_data: PokemonInfo[]
}

interface PokemonInfo {
  id: number;
  name: string;
  height: number;
  weight: number;
  sprites: PokemonSprite,
  stats: PokemonStats[],
  types: PokemonTypes[],
}

interface PokemonSprite {
  other: {
    home: {
      front_default: string
    }
  }
}

type PokemonStat = 'hp' | 'attack' | 'defense' | 'special-attack' | 'special-defense' | 'speed';
interface PokemonStats {
  base_stat: number;
  stat: {
    name: PokemonStat;
    url: string;
  }
}

type PokemonType =
  | 'grass'
  | 'poison'
  | 'fire'
  | 'flying'
  | 'water'
  | 'bug'
  | 'normal'
  | 'electric'
  | 'ground'
  | 'fairy'
  | 'steel'
  | 'fighting'
  | 'ghost'
  | 'psychic'
  | 'rock'
  | 'ice'
  | 'dragon'
  | 'dark';
interface PokemonTypes {
  type: {
    name: PokemonType,
    url: string;
  }
}

export {
  type Pokemon,
  type PokemonInfo,
  type PokemonSprite,
  type PokemonStats,
  type PokemonTypes,
  type PokemonType,
  type PokemonStat
};