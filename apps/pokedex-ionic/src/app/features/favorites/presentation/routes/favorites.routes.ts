import { Routes } from '@angular/router';
import { LayoutComponent } from '@shared/layout/layout.component';

const FAVORITES_ROUTES: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: '',
        redirectTo: 'favorites',
        pathMatch: 'full'
      },
      {
        path: 'favorites',
        data: {
          title: 'Favoritos',
          subtitle: '¡Listado de los mejores!',
          showFilters: false
        },
        loadComponent: () => import('../pages/home/favorites.page').then((m) => m.FavoritesPage)
      }
    ]
  }
]

export default FAVORITES_ROUTES;