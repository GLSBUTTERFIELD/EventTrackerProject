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

  public create(recipe: Recipe): Observable<Recipe> {
    return this.http.post<Recipe>(this.url, recipe).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          ()=> new Error ('RecipeService.create(): error retrieving recipe ' + err)
        );
      })
    )
  }

  public update(recipe: Recipe): Observable<Recipe> {
    return this.http.put<Recipe>(`${this.url}/${recipe.id}`, recipe).pipe(
      catchError((err: any) =>{
        console.log(err);
        return throwError(
          ()=> new Error('RecipeService.update(): error retrieving recipe: ' + err)
        );
      })
    )
  }

  public destroy(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`).pipe (
      catchError((err: any) => {
        console.log(err);
      return throwError(
        ()=> new Error('RecipeService.destroy(): error retrieving recipe ' + err)
      );
  })
)
  }

}
