import { ChangeDetectionStrategy, Component, computed, input } from '@angular/core';
import { POKEDEX_ICONS } from "@pokedex/ui/icons";
import { SafeHtmlPipe } from '@shared/pipes/safe-html.pipe';

@Component({
  standalone: true,
  selector: 'app-home',
  templateUrl: 'home.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [SafeHtmlPipe],
})

export class HomeComponent {

  icons = input<Record<string, string>>(POKEDEX_ICONS);
  iconsMapped = computed(() => {
    return Object.entries(this.icons()).map((i) => ({
      n: i[0],
      i: i[1]
    }));
  });
}