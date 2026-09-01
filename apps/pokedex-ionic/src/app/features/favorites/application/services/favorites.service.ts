import { computed, inject, Injectable, signal } from '@angular/core';
import { Pokemon } from '@features/pokedex/application/interfaces/response';
import { StorageService } from '@shared/services/storage.service';

@Injectable({ providedIn: 'root' })
export class FavoritesService {
  private readonly storageSvc = inject(StorageService);

  private _favorites = signal<Pokemon[]>([]);
  public readonly favorites = this._favorites.asReadonly();
  public readonly count = computed(() => this._favorites().length);

  constructor() {
    this.loadFavorites();
  }

  public async loadFavorites(): Promise<void> {
    const stored = await this.storageSvc.get<Pokemon[]>('favorites');
    this._favorites.set(stored || []);
  }

  public isFavorite(pokemonId: number): boolean {
    return this._favorites().some((p) => p.info.id === pokemonId);
  }

  public async toggleFavorite(pokemon: Pokemon): Promise<void> {
    const current = this._favorites();
    const exists = current.some((p) => p.info.id === pokemon.info.id);

    let updated: Pokemon[];
    if (exists) {
      updated = current.filter((p) => p.info.id !== pokemon.info.id);
    } else {
      updated = [...current, pokemon];
    }

    this._favorites.set(updated);
    await this.storageSvc.set<Pokemon[]>('favorites', updated);
  }
}
