import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from '../../environments/environment';
import { Category } from '../models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
private url = environment.baseUrl + 'api/recipes/categories';

  constructor(
    private http: HttpClient,
  ) { }

  index(): Observable<Category[]> {
    return this.http.get<Category[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          ()=> new Error('CategoryService.index(): error retrieving category list: ' + err)
        );
      })
    );
  }

}
