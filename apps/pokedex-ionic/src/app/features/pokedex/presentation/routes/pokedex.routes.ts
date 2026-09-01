import { Routes } from '@angular/router';
import { LayoutComponent } from '@shared/layout/layout.component';

const POKEDEX_ROUTES: Routes = [
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
          showFilters: false
        },
        loadComponent: () => import('../pages/home/pokedex.page').then((m) => m.PokedexPage)
      }
    ]
  },
  {
    path: 'pokedex/:id',
    loadComponent: () => import('../pages/pokemon/pokemon.page').then((m) => m.PokemonPage)
  }
]

export default POKEDEX_ROUTES;