import { ChangeDetectionStrategy, Component, inject, OnInit } from '@angular/core';
import { FavoritesService } from '@features/favorites/application/services/favorites.service';
import { PokemonCardComponent } from '@features/pokedex/presentation/pages/home/components/pokemon-card/pokemon-card.component';
import { IonContent, IonIcon } from '@ionic/angular';
import { addIcons } from 'ionicons';
import { heart, heartDislikeOutline, heartOutline } from 'ionicons/icons';

@Component({
  standalone: true,
  imports: [
    IonContent,
    IonIcon,
    PokemonCardComponent
  ],
  selector: 'app-favorites-page',
  templateUrl: 'favorites.page.html',
  styleUrl: 'favorites.page.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class FavoritesPage implements OnInit {
  public readonly favoritesSvc = inject(FavoritesService);

  constructor() {
    addIcons({ heartOutline, heart, heartDislikeOutline });
  }

  ngOnInit(): void {
    this.favoritesSvc.loadFavorites();
  }
}