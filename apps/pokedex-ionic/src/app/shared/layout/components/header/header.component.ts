import { ChangeDetectionStrategy, Component, ElementRef, inject, input, signal, viewChildren } from '@angular/core';
import { PokemonType } from '@features/pokedex/application/interfaces/response';
import { PokedexService } from '@features/pokedex/application/services/pokedex.service';
import { IonButtons, IonHeader, IonIcon, IonSearchbar, IonToolbar, MenuController } from '@ionic/angular';
import { POKEMON_TYPE_CONFIG } from '@shared/utils/type-colors.utils';
import { addIcons } from 'ionicons';
import { filterOutline } from 'ionicons/icons';

@Component({
  standalone: true,
  imports: [
    IonSearchbar,
    IonIcon,
    IonHeader,
    IonToolbar,
    IonButtons
  ],
  selector: 'app-header',
  templateUrl: 'header.component.html',
  styleUrl: 'header.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class HeaderComponent {

  title = input<string>('');
  subtitle = input<string>('');
  showFilters = input<boolean>(false);
  pokeballIcon: string = 'assets/pokeball-icon.svg';
  typeSelected = signal<string | null>(null);
  readonly pokemonTypes = Object.keys(
    POKEMON_TYPE_CONFIG
  ) as PokemonType[];
  POKEMON_TYPE_CONFIG = POKEMON_TYPE_CONFIG;
  typesRef = viewChildren<ElementRef<HTMLDivElement>>('type');

  private menuCtrl = inject(MenuController);
  public pokedexSvc = inject(PokedexService);

  constructor() {
    addIcons({ filterOutline });
  }

  public async toggle(): Promise<void> {
    await this.menuCtrl.toggle();
  }

  public changeType(type: PokemonType): void {
    if (this.typeSelected() == type) {
      this.typeSelected.set(null);
      this.pokedexSvc.filterType.set(null);
      return;
    }
    this.typeSelected.set(type);
    this.pokedexSvc.filterType.set(type);
    this.scrollToItem(
      this.typesRef()
        .find((t) => t.nativeElement.textContent.trim() == type)!.nativeElement
    );
  }

  public scrollToItem(element: HTMLDivElement): void {
    element.scrollIntoView({
      behavior: 'smooth', // Animación de desplazamiento suave
      inline: 'center',   // Centrado horizontal en el contenedor
      block: 'nearest'    // Evita saltos no deseados en el scroll vertical de la pantalla
    });
  }
}