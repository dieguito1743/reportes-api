import {Injectable} from '@angular/core';
import {HttpClient, HttpEvent, HttpHeaders, HttpParams, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

const END_POINT = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  public headers = new HttpHeaders({'Content-Type': 'application/json; charset=utf-8'});
  public params = new HttpParams();

  constructor(private _http: HttpClient) {
  }

  getTransacciones(): Observable<HttpEvent<any>> {
    const req = new HttpRequest('GET', `${END_POINT}/transaction`, {
      headers: this.headers,
      params: this.params,
      responseType: 'json'
    });
    return this._http.request(req);
  }

  getUserConfiguration(): Observable<HttpEvent<any>> {
    const req = new HttpRequest('GET', `${END_POINT}/codUsuario/U00001`, {
      headers: this.headers,
      params: this.params,
      responseType: 'json'
    });
    return this._http.request(req);
  }

  getFilter(): Observable<HttpEvent<any>> {
    const req = new HttpRequest('GET', `${END_POINT}/filter`, {
      headers: this.headers,
      params: this.params,
      responseType: 'json'
    });
    return this._http.request(req);
  }

  getColumn(): Observable<HttpEvent<any>> {
    const req = new HttpRequest('GET', `${END_POINT}/column`, {
      headers: this.headers,
      params: this.params,
      responseType: 'json'
    });
    return this._http.request(req);
  }

}
