import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '@environments/environment.development';
import { catchError, Observable, of } from 'rxjs';
import { PokemonResponse } from '@pokedex/api-types';
import { toSignal } from '@angular/core/rxjs-interop';

const BASE_POKEMONS: string = `${environment.API_URL}/pokemons`;

@Injectable({ providedIn: 'root' })
export class PokemonService {
  private readonly _http: HttpClient = inject(HttpClient);

  public readonly pokemons = toSignal(
    this._http
      .get<PokemonResponse[]>(BASE_POKEMONS)
      .pipe(catchError(() => of([]))),
    { initialValue: [] },
  );
}
