import { Route } from '@angular/router';

export const appRoutes: Route[] = [
  {
    path: '',
    loadComponent: () => import('./features/pokedex/infrastructure/pages/home/home').then(m => m.HomeComponent)
  },
  {
    path: '*',
    redirectTo: '',
    pathMatch: 'full'
  }
];
