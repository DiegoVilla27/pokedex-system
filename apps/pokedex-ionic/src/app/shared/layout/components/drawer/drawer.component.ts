import { ChangeDetectionStrategy, Component } from '@angular/core';
import { IonContent, IonHeader, IonMenu, IonTitle, IonToolbar } from '@ionic/angular';

@Component({
  standalone: true,
  imports: [
    IonContent,
    IonTitle,
    IonToolbar,
    IonHeader,
    IonMenu
  ],
  selector: 'app-drawer',
  templateUrl: 'drawer.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class DrawerComponent { }