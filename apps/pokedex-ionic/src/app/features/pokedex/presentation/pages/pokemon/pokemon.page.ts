import { ChangeDetectionStrategy, Component, computed, inject, OnInit, signal } from '@angular/core';
import { Pokemon } from '@features/pokedex/application/interfaces/response';
import { StorageService } from '@shared/services/storage.service';
import { PokemonContentComponent } from './components/content/content.component';
import { PokemonHeaderComponent } from './components/header/header.component';
import { PokemonInfoComponent } from './components/info/info.component';

@Component({
  standalone: true,
  imports: [
    PokemonHeaderComponent,
    PokemonInfoComponent,
    PokemonContentComponent
  ],
  selector: 'pokemon-page',
  templateUrl: 'pokemon.page.html',
  styleUrl: 'pokemon.page.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PokemonPage implements OnInit {
  public pokemon = signal<Pokemon | null>(null);

  private readonly storageSvc = inject(StorageService);

  bgColor = computed(() => {
    if (this.pokemon()) {
      const [r, g, b] = this.pokemon()!.color;
      return `${r},${g},${b}`;
    }
    return '0,0,0';
  });

  ngOnInit(): void {
    this.storageSvc.get<Pokemon>('pokemon').then((p) => {
      if (p) this.pokemon.set(p);
    });
  }
}