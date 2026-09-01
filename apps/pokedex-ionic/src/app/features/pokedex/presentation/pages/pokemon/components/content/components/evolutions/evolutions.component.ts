import { ChangeDetectionStrategy, Component, input } from '@angular/core';
import { PokemonInfo } from '@features/pokedex/application/interfaces/response';
import { PadNumberPipe } from '@features/pokedex/presentation/pipes/pad-number.pipe';
import { IonIcon } from '@ionic/angular';
import { POKEMON_TYPE_CONFIG } from '@shared/utils/type-colors.utils';
import { addIcons } from 'ionicons';
import { arrowDown, arrowForward } from 'ionicons/icons';

@Component({
  standalone: true,
  imports: [IonIcon, PadNumberPipe],
  selector: 'app-pokemon-evolutions',
  templateUrl: 'evolutions.component.html',
  styleUrl: 'evolutions.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PokemonEvolutionsComponent {
  evolutions = input.required<PokemonInfo[]>();
  currentId = input<number>();
  readonly POKEMON_TYPE_CONFIG = POKEMON_TYPE_CONFIG;

  constructor() {
    addIcons({ arrowForward, arrowDown });
  }
}
