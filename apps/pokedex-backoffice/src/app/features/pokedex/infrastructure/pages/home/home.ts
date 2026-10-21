import { ScrollingModule } from '@angular/cdk/scrolling';
import {
  ChangeDetectionStrategy,
  Component,
  computed,
  inject,
} from '@angular/core';
import { PokemonService } from '@features/pokedex/application/services/pokemon.service';
import { Pokemon } from './components/pokemon/pokemon';
import { PokemonResponse } from '@pokedex/api-types';

@Component({
  standalone: true,
  selector: 'app-home',
  templateUrl: 'home.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [Pokemon, ScrollingModule],
})
export class HomePage {
  public readonly pokemons = inject(PokemonService).pokemons;

  // Número de columnas en el grid
  readonly columns = 3;
  // Agrupamos el array lineal en filas: PokemonResponse[][]
  public readonly pokemonRows = computed(() => {
    const list = this.pokemons() ?? [];
    const rows: PokemonResponse[][] = [];
    const cols = this.columns;
    for (let i = 0; i < list.length; i += cols) {
      rows.push(list.slice(i, i + cols));
    }
    return rows;
  });

  trackByRow(index: number, row: PokemonResponse[]): string {
    return row.map((p) => p.id).join('-');
  }
}
