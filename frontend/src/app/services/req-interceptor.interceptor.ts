import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class ReqInterceptorInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if (this.requiresToken(request.url)) {
      // Retrieve the token from storage or wherever it's stored
      const token = this.getToken();

      // Clone the request and add the token to the headers
      const modifiedReq = request.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        }
      });

      // Pass the modified request to the next interceptor or the HTTP handler
      return next.handle(modifiedReq);
    }

    // For requests that don't require the token, pass them through unchanged
    return next.handle(request);
  }
  private requiresToken(url: string): boolean {
    if (url.includes("/login")){
      return false
    }else {
      return true;
    }
  }

  private getToken(): string|null {
    return localStorage.getItem("token") ? localStorage.getItem("token") : "";;
  }
}
