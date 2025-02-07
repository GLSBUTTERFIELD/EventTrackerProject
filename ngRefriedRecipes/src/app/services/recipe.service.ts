import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Recipe } from '../models/recipe';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  private url = environment.baseUrl + 'api/recipes';

  constructor(
    private http: HttpClient,

  ) { }

  index(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          ()=> new Error('RecipeService.index(): error retrieving recipe list: ' + err)
        );
      })
    );
  }


  
}
