import { ChangeDetectionStrategy, Component, input, signal } from '@angular/core';
import { Pokemon } from '@features/pokedex/application/interfaces/response';
import { IonContent, IonLabel, IonSegment, IonSegmentButton } from '@ionic/angular';
import { PokemonEvolutionsComponent } from './components/evolutions/evolutions.component';
import { PokemonStatsComponent } from './components/stats/stats.component';

@Component({
  standalone: true,
  imports: [
    IonContent,
    IonSegment,
    IonSegmentButton,
    IonLabel,
    PokemonStatsComponent,
    PokemonEvolutionsComponent
  ],
  selector: 'app-pokemon-content',
  templateUrl: 'content.component.html',
  styleUrl: 'content.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PokemonContentComponent {
  pokemon = input.required<Pokemon>();
  public selectedTab = signal<'stats' | 'evolutions'>('stats');

  public onTabChange(event: CustomEvent): void {
    const value = event.detail.value as 'stats' | 'evolutions';
    if (value) {
      this.selectedTab.set(value);
    }
  }
}
