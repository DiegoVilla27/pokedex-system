import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  imports: [RouterModule],
  standalone: true,
  selector: 'app-root',
  template: `<main><router-outlet /></main>`,
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class App {}
