import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class SmartKycService {

  constructor(private http: HttpClient) {}

  getChainWithHighestValue(dominoPieces: any): Observable<any> {
    return this.http.post('http://localhost:8080/chainWithHighestValue', dominoPieces);
  }
}
