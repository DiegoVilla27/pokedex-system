import { HttpClient } from '@angular/common/http';
import { computed, inject, Injectable, signal } from '@angular/core';
import { environment } from '@envs/environment';
import { Pokemon, PokemonType } from '../interfaces/response';

@Injectable({ providedIn: 'root' })
export class PokedexService {
  private readonly http = inject(HttpClient);

  // Paginator
  private allPokemon: Pokemon[] = [];
  private limit: number = 10;

  // States
  private _pokemons = signal<Pokemon[]>([]);
  public readonly pokemons = computed(() => {
    const type = this.filterType();
    const search = this.search().trim().toLowerCase();

    return this.allPokemon.filter(p => {

      const matchesType =
        !type ||
        p.info.types.some(
          t => t.type.name === type
        );

      const matchesSearch =
        !search ||
        p.name.toLowerCase().includes(search);

      return matchesType && matchesSearch;
    });
  });
  private _loading = signal<boolean>(true);
  public loading = this._loading.asReadonly();
  private _error = signal<string | null>(null);
  public error = this._error.asReadonly();

  // Filter 
  public filterType = signal<PokemonType | null>(null);
  public search = signal<string>('');

  public getAllPokemon(): void {
    this.http.get<Pokemon[]>(environment.api_url)
      .subscribe({
        next: (res) => {
          this.allPokemon = res;
          this._pokemons.set(this.allPokemon.slice(0, this.limit));
        },
        error: () => this._error.set('No se pudieron cargar los Pokémon'),
        complete: () => this._loading.set(false)
      });
  }

  public loadMore(): boolean {
    const currentLength = this._pokemons().length;
    const nextChunk = this.allPokemon
      .slice(currentLength, currentLength + this.limit);

    this._pokemons.update((prev) => [...prev, ...nextChunk]);

    return currentLength >= this.allPokemon.length;
  }
}