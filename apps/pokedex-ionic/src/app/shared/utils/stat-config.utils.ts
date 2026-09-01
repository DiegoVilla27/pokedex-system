import { PokemonStat } from "@features/pokedex/application/interfaces/response";
import { flash, flower, footsteps, heart, shield, sparkles } from "ionicons/icons";

export interface StatConfig {
  label: string;
  color: string;
  iconName: string;
  iconData: string;
}

export const POKEMON_STAT_CONFIG: Record<PokemonStat, StatConfig> = {
  hp: {
    label: 'HP',
    color: '#FF5959',
    iconName: 'heart',
    iconData: heart
  },
  attack: {
    label: 'ATK',
    color: '#F5AC78',
    iconName: 'flash',
    iconData: flash
  },
  defense: {
    label: 'DEF',
    color: '#FAE078',
    iconName: 'shield',
    iconData: shield
  },
  'special-attack': {
    label: 'Sp. ATK',
    color: '#9DB7F5',
    iconName: 'sparkles',
    iconData: sparkles
  },
  'special-defense': {
    label: 'Sp. DEF',
    color: '#A7DB8D',
    iconName: 'flower',
    iconData: flower
  },
  speed: {
    label: 'SPD',
    color: '#FA92B2',
    iconName: 'footsteps',
    iconData: footsteps
  }
};