import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  constructor(private http:HttpClient) { }

  public get(url:string):Observable<any>{
    return this.http.get(url);
  }
  public post(url:string,body:{}):Observable<any>{
    return this.http.post(url,body);
  }
  public put(url:string,body:{}):Observable<any>{
    return this.http.put(url,body);
  }
}
