import { NgOptimizedImage, NgStyle } from '@angular/common';
import { ChangeDetectionStrategy, Component, input } from '@angular/core';
import { Pokemon } from '@features/pokedex/application/interfaces/response';
import { PadNumberPipe } from '@features/pokedex/presentation/pipes/pad-number.pipe';
import { IonIcon } from '@ionic/angular';
import { POKEMON_TYPE_CONFIG } from '@shared/utils/type-colors.utils';

@Component({
  standalone: true,
  imports: [IonIcon, PadNumberPipe, NgStyle, NgOptimizedImage],
  selector: 'app-pokemon-info',
  templateUrl: 'info.component.html',
  styleUrl: 'info.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PokemonInfoComponent {
  pokemon = input.required<Pokemon>();
  readonly POKEMON_TYPE_CONFIG = POKEMON_TYPE_CONFIG;
}
