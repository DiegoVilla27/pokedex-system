import { NgOptimizedImage, NgStyle } from '@angular/common';
import { ChangeDetectionStrategy, Component, computed, inject, input } from '@angular/core';
import { Router } from '@angular/router';
import { FavoritesService } from '@features/favorites/application/services/favorites.service';
import { Pokemon } from '@features/pokedex/application/interfaces/response';
import { PadNumberPipe } from '@features/pokedex/presentation/pipes/pad-number.pipe';
import { IonCard, IonCardContent, IonCardHeader, IonIcon } from '@ionic/angular';
import { StorageService } from '@shared/services/storage.service';
import { POKEMON_TYPE_CONFIG } from '@shared/utils/type-colors.utils';
import { addIcons } from 'ionicons';
import { heart, heartOutline } from 'ionicons/icons';

@Component({
  standalone: true,
  imports: [
    IonIcon,
    IonCardContent,
    IonCardHeader,
    IonCard,
    PadNumberPipe,
    NgStyle,
    NgOptimizedImage
  ],
  selector: 'app-pokemon-card',
  templateUrl: 'pokemon-card.component.html',
  styleUrl: 'pokemon-card.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PokemonCardComponent {
  pokemon = input<Pokemon>();

  bgColor = computed(() => {
    if (this.pokemon()) {
      const [r, g, b] = this.pokemon()!.color;
      return `${r},${g},${b}`;
    }
    return '0,0,0';
  });

  readonly POKEMON_TYPE_CONFIG = POKEMON_TYPE_CONFIG;

  private readonly router = inject(Router);
  private readonly storageSvc = inject(StorageService);
  private readonly favoritesSvc = inject(FavoritesService);

  isFavorite = computed(() => {
    const poke = this.pokemon();
    return poke ? this.favoritesSvc.isFavorite(poke.info.id) : false;
  });

  constructor() {
    addIcons({ heartOutline, heart });
  }

  public toggleFavorite(evt: Event): void {
    evt.stopPropagation();
    const poke = this.pokemon();
    if (poke) {
      this.favoritesSvc.toggleFavorite(poke);
    }
  }

  public goToPokemon(pokemon: Pokemon): void {
    this.storageSvc.set<Pokemon>('pokemon', pokemon);
    this.router.navigateByUrl(`/pokedex/${pokemon.info.id}`);
  }
}