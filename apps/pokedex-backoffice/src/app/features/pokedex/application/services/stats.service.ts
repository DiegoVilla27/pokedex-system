import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { toSignal } from '@angular/core/rxjs-interop';
import { environment } from '@environments/environment.development';
import { StatResponse } from '@pokedex/api-types';
import { catchError, Observable, of } from 'rxjs';

const BASE_STATS: string = `${environment.API_URL}/stats`;

@Injectable({ providedIn: 'root' })
export class StatsService {
  private readonly _http: HttpClient = inject(HttpClient);

  public readonly stats = toSignal(
    this._http.get<StatResponse[]>(BASE_STATS).pipe(catchError(() => of([]))),
    { initialValue: [] },
  );
}
