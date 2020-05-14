import { Injectable} from "@angular/core";
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs";
import { Data } from "../data"

@Injectable({
  providedIn: 'root'
})
export class DataViewService{

  constructor(private http: HttpClient) {
  }

  getData(): Observable<Data[]> {
    return this.http.get<Data[]>('http://35.237.109.158:8080/data/api')
  }
}
