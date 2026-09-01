import { ChangeDetectionStrategy, Component, inject, signal } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { IonRouterOutlet } from '@ionic/angular';
import { DrawerComponent } from '@shared/layout/components/drawer/drawer.component';
import { HeaderComponent } from '@shared/layout/components/header/header.component';
import { NavigationComponent } from '@shared/layout/components/navigation/navigation.component';
import { filter } from 'rxjs';

@Component({
  standalone: true,
  imports: [
    IonRouterOutlet,
    DrawerComponent,
    NavigationComponent,
    HeaderComponent
  ],
  selector: 'app-layout-pokedex',
  template: `
    <app-drawer />

    <div class="ion-page" id="main-content">
      @if (!hideLayout()) {
        <app-header
          [title]="title()"
          [subtitle]="subtitle()"
          [showFilters]="showFilters()"
        />
      }

      <ion-router-outlet [animated]="false" />

      @if (!hideLayout()) {
        <app-navigation />
      }
    </div>
  `,
  styles: `
    .ion-page {
      display: flex;
      flex-direction: column; 
      height: 100%;
      background: var(--app-background);
    }

    ion-router-outlet {
      flex: 1;
      position: relative;
    }
  `,
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class LayoutComponent {
  private router = inject(Router);

  // Convertimos a signals normales que se actualizan con la navegación
  title = signal<string>('');
  subtitle = signal<string>('');
  showFilters = signal<boolean>(false);
  hideLayout = signal<boolean>(false);

  ngOnInit(): void {
    // 1. Leer la ruta actual al cargar
    this.updateRouteData();
    // 2. Escuchar cada cambio de navegación (cuando cambias de tab)
    this.router.events
      .pipe(filter((event) => event instanceof NavigationEnd))
      .subscribe(() => {
        this.updateRouteData();
      });
  }

  private updateRouteData(): void {
    let currentRoute: ActivatedRoute | null = this.router.routerState?.root;
    // Recorremos de forma segura mientras haya rutas hijas
    while (currentRoute?.firstChild) {
      currentRoute = currentRoute.firstChild;
    }
    // 👈 Usamos ?. para evitar el TypeError si el snapshot aún no está listo
    const data = currentRoute?.snapshot?.data ?? {};
    this.title.set(data['title'] ?? '');
    this.subtitle.set(data['subtitle'] ?? '');
    this.showFilters.set(data['showFilters'] ?? false);
    this.hideLayout.set(data['hideLayout'] ?? false);
  }
}