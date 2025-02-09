import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Recipe } from '../models/recipe';
import { FoodType } from '../models/food-type';

@Injectable({
  providedIn: 'root'
})
export class FoodTypeService {
  private url = environment.baseUrl + 'api/recipes';

  constructor(
        private http: HttpClient,
  ) { }

    index(): Observable<FoodType[]> {
      return this.http.get<FoodType[]>(this.url).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            ()=> new Error('FoodTypeService.index(): error retrieving food type list: ' + err)
          );
        })
      );
    }



}
