import { ChangeDetectionStrategy, Component, inject, OnInit } from '@angular/core';
import { PokedexService } from '@features/pokedex/application/services/pokedex.service';
import { InfiniteScrollCustomEvent, IonContent, IonInfiniteScroll, IonInfiniteScrollContent } from "@ionic/angular";
import { PokemonCardComponent } from './components/pokemon-card/pokemon-card.component';

@Component({
  standalone: true,
  imports: [
    PokemonCardComponent,
    IonInfiniteScroll,
    IonInfiniteScrollContent,
    IonContent
  ],
  selector: 'app-pokedex-page',
  templateUrl: 'pokedex.page.html',
  styleUrl: 'pokedex.page.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class PokedexPage implements OnInit {
  public readonly pokedexSvc = inject(PokedexService);

  ngOnInit() {
    this.pokedexSvc.getAllPokemon();
  }

  public loadMore(evt: InfiniteScrollCustomEvent): void {
    const hasMore = this.pokedexSvc.loadMore();
    evt.target.complete();
    if (hasMore) {
      evt.target.disabled = true;
    }
  }
}