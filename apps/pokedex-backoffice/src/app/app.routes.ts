import { Route } from '@angular/router';

export const appRoutes: Route[] = [
  {
    path: '',
    loadComponent: () =>
      import('./features/pokedex/infrastructure/pages/home/home').then(
        (m) => m.HomePage,
      ),
  },
  {
    path: 'details',
    loadComponent: () =>
      import('./features/pokedex/infrastructure/pages/details/details').then(
        (m) => m.DetailsPage,
      ),
  },
  {
    path: '*',
    redirectTo: '',
    pathMatch: 'full',
  },
];
