import { Routes } from '@angular/router';
import { LayoutComponent } from '@shared/layout/layout.component';

export const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: '',
        redirectTo: 'pokedex',
        pathMatch: 'full'
      },
      {
        path: 'pokedex',
        data: {
          title: 'Pokédex',
          subtitle: '¡Atrápalos a todos!',
          showFilters: true
        },
        loadComponent: () => import('@features/pokedex/presentation/pages/home/pokedex.page').then((m) => m.PokedexPage)
      },
      {
        path: 'pokedex/:id',
        data: {
          hideLayout: true
        },
        loadComponent: () => import('@features/pokedex/presentation/pages/pokemon/pokemon.page').then((m) => m.PokemonPage)
      },
      {
        path: 'favorites',
        data: {
          title: 'Favoritos',
          subtitle: '¡Listado de los mejores!',
          showFilters: false
        },
        loadComponent: () => import('@features/favorites/presentation/pages/home/favorites.page').then((m) => m.FavoritesPage)
      }
    ]
  }
];
