import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminInsuranceService {

  constructor(private httpClient: HttpClient) { }

  getAllInsurances(): Observable<any>{
    return this.httpClient.get('http://localhost:8080/Insurances/',{responseType:'json'})
  }
}
