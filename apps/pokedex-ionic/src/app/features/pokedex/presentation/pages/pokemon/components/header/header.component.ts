import { ChangeDetectionStrategy, Component, computed, inject, input } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FavoritesService } from '@features/favorites/application/services/favorites.service';
import { Pokemon } from '@features/pokedex/application/interfaces/response';
import { IonButtons, IonHeader, IonIcon, IonToolbar } from '@ionic/angular';
import { addIcons } from 'ionicons';
import { chevronBack, heart, heartOutline } from 'ionicons/icons';

@Component({
  standalone: true,
  imports: [IonHeader, IonToolbar, IonButtons, IonIcon, RouterLink],
  selector: 'app-pokemon-header',
  templateUrl: 'header.component.html',
  styleUrl: 'header.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PokemonHeaderComponent {
  pokemon = input<Pokemon | null>(null);

  private readonly favoritesSvc = inject(FavoritesService);

  isFavorite = computed(() => {
    const poke = this.pokemon();
    return poke ? this.favoritesSvc.isFavorite(poke.info.id) : false;
  });

  constructor() {
    addIcons({ chevronBack, heartOutline, heart });
  }

  public toggleFavorite(): void {
    const poke = this.pokemon();
    if (poke) {
      this.favoritesSvc.toggleFavorite(poke);
    }
  }
}
