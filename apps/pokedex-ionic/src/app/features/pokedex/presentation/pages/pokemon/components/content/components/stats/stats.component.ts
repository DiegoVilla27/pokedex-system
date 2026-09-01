import { ChangeDetectionStrategy, Component, input } from '@angular/core';
import { PokemonStats } from '@features/pokedex/application/interfaces/response';
import { IonIcon } from '@ionic/angular';
import { POKEMON_STAT_CONFIG } from '@shared/utils/stat-config.utils';
import { addIcons } from 'ionicons';
import { flash, flower, footsteps, heart, shield, sparkles } from 'ionicons/icons';

@Component({
  standalone: true,
  imports: [IonIcon],
  selector: 'app-pokemon-stats',
  templateUrl: 'stats.component.html',
  styleUrl: 'stats.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PokemonStatsComponent {
  stats = input.required<PokemonStats[]>();
  readonly POKEMON_STAT_CONFIG = POKEMON_STAT_CONFIG;

  constructor() {
    addIcons({
      heart,
      flash,
      shield,
      sparkles,
      flower,
      footsteps
    });
  }
}
