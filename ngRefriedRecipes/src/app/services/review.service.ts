import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from '../../environments/environment';
import { Review } from '../models/review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

private url = environment.baseUrl + 'api/reviews';

  constructor(
    private http: HttpClient,
  ) { }

  index(): Observable<Review[]> {
    return this.http.get<Review[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          ()=> new Error('ReviewService.index(): error retrieving review list: ' + err)
        );
      })
    );
  }
}
