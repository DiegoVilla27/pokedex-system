import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { toSignal } from '@angular/core/rxjs-interop';
import { environment } from '@environments/environment.development';
import { TypeResponse } from '@pokedex/api-types';
import { catchError, of } from 'rxjs';

const BASE_TYPES: string = `${environment.API_URL}/types`;

@Injectable({ providedIn: 'root' })
export class TypesService {
  private readonly _http: HttpClient = inject(HttpClient);

  public readonly types = toSignal(
    this._http.get<TypeResponse[]>(BASE_TYPES).pipe(catchError(() => of([]))),
    { initialValue: [] },
  );
}
