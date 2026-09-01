import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from "@angular/router";
import { IonIcon, IonTabBar, IonTabButton } from '@ionic/angular';
import { addIcons } from 'ionicons';
import { heart, home, person } from 'ionicons/icons';

@Component({
  standalone: true,
  imports: [
    IonIcon,
    IonTabButton,
    IonTabBar,
    RouterLink,
    RouterLinkActive
  ],
  selector: 'app-navigation',
  templateUrl: 'navigation.component.html',
  styleUrl: 'navigation.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class NavigationComponent {
  constructor() {
    addIcons({
      heart,
      person,
      home
    })
  }
}