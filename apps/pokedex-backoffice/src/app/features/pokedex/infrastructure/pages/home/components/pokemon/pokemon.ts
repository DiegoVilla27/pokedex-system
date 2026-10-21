import { ChangeDetectionStrategy, Component, input } from '@angular/core';
import { PokemonResponse } from '@pokedex/api-types';

@Component({
  standalone: true,
  imports: [],
  selector: 'app-pokemon',
  templateUrl: 'pokemon.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class Pokemon {
  public readonly pokemon = input<PokemonResponse>();
}
